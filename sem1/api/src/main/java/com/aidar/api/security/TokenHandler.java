package com.aidar.api.security;

import com.aidar.api.util.UserForToken;
import com.aidar.model.User;
import com.aidar.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

/**
 * Created by paradise on 16.03.16.
 */
@Component
@PropertySource("classpath:api.properties")
public class TokenHandler {

    @Autowired
    private Environment environment;

    @Autowired
    private UserRepository userRepository;

    private Mac hmac;

    @PostConstruct
    public void initialize() {
        String secret = environment.getProperty("token.secret");
        String hmac_alg = "HmacSHA256";
        byte[] secretKey = DatatypeConverter.parseBase64Binary(secret);
        try {
            hmac = Mac.getInstance(hmac_alg);
            hmac.init(new SecretKeySpec(secretKey, hmac_alg));
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            throw new IllegalStateException("failed to initialize HMAC: " + e.getMessage(), e);
        }
    }

    private byte[] toJSON(UserForToken userForToken) {
        try {
            return new ObjectMapper().writeValueAsBytes(userForToken);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException(e);
        }
    }

    private UserForToken fromJSON(final byte[] userBytes) {
        try {
            return new ObjectMapper().readValue(new ByteArrayInputStream(userBytes), UserForToken.class);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private String toBase64(byte[] content) {
//        return DatatypeConverter.printBase64Binary(content);
        return Base64.getEncoder().encodeToString(content);
    }

    private byte[] fromBase64(String content) {
//        return DatatypeConverter.parseBase64Binary(content);
        return Base64.getDecoder().decode(content);
    }

    // synchronized to guard internal hmac object
    private synchronized byte[] createHmac(byte[] content) {
        return hmac.doFinal(content);
    }

    public String createTokenForUser(User user) {
        UserForToken userForToken = UserForToken.userToUserForToken(user);
        byte[] userBytes = toJSON(userForToken);
        byte[] hash = createHmac(userBytes);
        return toBase64(userBytes) +
                "." +
                toBase64(hash);
    }

    public User parseUserFromToken(String token) {
        final String[] parts = token.split("\\.");
        if (parts.length == 2 && parts[0].length() > 0 && parts[1].length() > 0) {
            try {
                final byte[] userBytes = fromBase64(parts[0].replaceAll(" ", "+"));
                final byte[] hash = fromBase64(parts[1].replaceAll(" ", "+"));

                boolean validHash = Arrays.equals(createHmac(userBytes), hash);
                if (validHash) {
                    UserForToken userForToken = fromJSON(userBytes);
                    return userRepository.findOneByEmail(userForToken.getEmail());
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

}
