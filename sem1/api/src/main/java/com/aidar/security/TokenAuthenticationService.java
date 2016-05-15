package com.aidar.security;

import org.springframework.stereotype.Service;

/**
 * Created by paradise on 16.03.16.
 */
@Service
public class TokenAuthenticationService {

//    @Autowired
//    private TokenHandler tokenHandler;
//
//    private static final String TOKEN = "token";
//
//    public void addAuthentication(HttpServletResponse response, UserAuthentication authentication) {
//        final User user = authentication.getDetails();
//        CookieUtil.addCookie(response, TOKEN, tokenHandler.createTokenForUser(user));
//    }
//
//    public Authentication getAuthentication(HttpServletRequest request) {
//        String token = CookieUtil.getCookieValue(request, TOKEN);
//        if (token != null) {
//            final User user = tokenHandler.parseUserFromToken(token);
//            if (user != null) {
//                return new UserAuthentication(user);
//            }
//        }
//        return null;
//    }

}
