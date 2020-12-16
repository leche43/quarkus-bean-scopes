package org.acme.security.jwt;

import java.util.Arrays;
import java.util.HashSet;

import org.eclipse.microprofile.jwt.Claims;

import io.smallrye.jwt.build.Jwt;

/**
 * A simple utility class to generate and print a JWT token string to stdout.
 */
public class GenerateToken {
    /**
     * Generate JWT token
     */
    public static void main(String[] args) {
        System.out.println("max:");
        String token = Jwt.issuer("https://example.com/issuer")
                .upn("jdoe@quarkus.io")
                .groups(new HashSet<>(Arrays.asList("User", "Admin")))
                .claim(Claims.nickname.name(), "max")
                .claim(Claims.birthdate.name(), "2001-07-13")
                .expiresAt(9999999998L)
                .sign();
        System.out.println(token);
        System.out.println("peter:");
        String token2 = Jwt.issuer("https://example.com/issuer")
                .upn("jdoe@quarkus.io")
                .groups(new HashSet<>(Arrays.asList("User", "Admin")))
                .claim(Claims.nickname.name(), "peter")
                .claim(Claims.birthdate.name(), "2001-07-13")
                .expiresAt(9999999999L)
                .sign();
        System.out.println(token2);
    }
}
