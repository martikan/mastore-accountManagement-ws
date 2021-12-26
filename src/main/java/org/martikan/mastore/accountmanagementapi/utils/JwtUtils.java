package org.martikan.mastore.accountmanagementapi.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;

/**
 * Util class for Jwt actions.
 */
@Slf4j
@Component
public class JwtUtils {

    @Value("${token.expiration}")
    private String expirationTime;

    @Value("${token.secret}")
    private String secret;

    public boolean isVerificationTokenValid(final String jwtToken) {

        var valid = false;

        try {

            final var subject = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(jwtToken)
                    .getBody()
                    .getSubject();

            if (subject != null && !subject.isBlank()) {
                valid = true;
            }

        } catch (Exception e) {
            log.warn("JWT Token validation error", e);
        }

        return valid;
    }

    public String generateVerificationToken(final String email) {
        return Jwts.builder()
                .setSubject(email)
                .setExpiration(new Date(System.currentTimeMillis() + Long.parseLong(Objects.requireNonNull(expirationTime))))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

}
