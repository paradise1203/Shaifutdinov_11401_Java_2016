package com.aidar.security;

import com.aidar.enums.UserStatus;
import com.aidar.model.User;
import com.aidar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by paradise on 16.03.16.
 */
@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenHandler tokenHandler;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    private static final String TOKEN = "token";

    public String addToken(HttpServletRequest request) {
        String email = request.getParameter("email");
        User principal = userRepository.findOneByEmail(email);
        if (principal == null) {
            throw new UsernameNotFoundException("User not found");
        }
        if (principal.getStatus() == UserStatus.BANNED) {
            throw new DisabledException("Sorry, but you are banned");
        }
        String password = request.getParameter("pass");
        if (!encoder.matches(password, principal.getPassword())) {
            throw new BadCredentialsException("Invalid password");
        }
        return tokenHandler.createTokenForUser(principal);
    }

    public User getAuthentication(HttpServletRequest request) {
        String token = request.getParameter(TOKEN);
        return token != null ? tokenHandler.parseUserFromToken(token) : null;
    }

}
