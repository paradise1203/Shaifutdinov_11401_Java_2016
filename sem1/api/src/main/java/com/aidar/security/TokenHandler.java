package com.aidar.security;

import org.springframework.stereotype.Component;

/**
 * Created by paradise on 16.03.16.
 */
@Component
public class TokenHandler {

//    private Mac hmac;
//
//    @Value("${token.secret}")
//    private String secret;
//
//    @PostConstruct
//    public void initializeHmac() {
//        String hmac_alg = "HmacSHA256";
//        byte[] secretKey = DatatypeConverter.parseBase64Binary(secret);
//        try {
//            hmac = Mac.getInstance(hmac_alg);
//            hmac.init(new SecretKeySpec(secretKey, hmac_alg));
//        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
//            throw new IllegalStateException("failed to initialize HMAC: " + e.getMessage(), e);
//        }
//    }
//
//    private User fromJSON(final byte[] userBytes) {
//        try {
//            return new ObjectMapper().readValue(new ByteArrayInputStream(userBytes), User.class);
//        } catch (IOException e) {
//            throw new IllegalStateException(e);
//        }
//    }
//
//    private byte[] toJSON(User user) {
//        try {
//            return new ObjectMapper().writeValueAsBytes(user);
//        } catch (JsonProcessingException e) {
//            throw new IllegalStateException(e);
//        }
//    }
//
//    private String toBase64(byte[] content) {
//        return DatatypeConverter.printBase64Binary(content);
//    }
//
//    private byte[] fromBase64(String content) {
//        return DatatypeConverter.parseBase64Binary(content);
//    }
//
//    // synchronized to guard internal hmac object
//    private synchronized byte[] createHmac(byte[] content) {
//        return hmac.doFinal(content);
//    }
//
//    public User parseUserFromToken(String token) {
//        final String[] parts = token.split("\\.");
//        if (parts.length == 2 && parts[0].length() > 0 && parts[1].length() > 0) {
//            try {
//                final byte[] userBytes = fromBase64(parts[0]);
//                final byte[] hash = fromBase64(parts[1]);
//
//                boolean validHash = Arrays.equals(createHmac(userBytes), hash);
//                if (validHash) {
//                    return fromJSON(userBytes);
//                }
//            } catch (IllegalArgumentException ignore) {
//            }
//        }
//        return null;
//    }
//
//    public String createTokenForUser(User user) {
//        byte[] userBytes = toJSON(user);
//        byte[] hash = createHmac(userBytes);
//        return toBase64(userBytes) +
//                "." +
//                toBase64(hash);
//    }

}
