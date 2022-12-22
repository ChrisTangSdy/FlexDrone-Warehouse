package com.fdmgroup.flexdronewarehouse.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

import static java.util.Map.entry;

/**
 * This class is mainly used to generate/extract/validate token
 *
 * @author Chris
 */
@Component
@Slf4j
public class JwtUtils {

    @Value("${app.jwt.secret}")
    private String SECRET_KEY;


    /**
     * extract username from claims
     * @param token a token string
     * @return username
     */
    public String extractUsername(String token) {
        String username = null;
        try{
            username = extractClaim(token, Claims::getSubject);
        } catch (Exception e){
            log.info(e.getMessage());
        } finally {
            return  username;
        }


    }

    /**
     * extract expiration date from claims
     * @param token
     * @return expiration date
     */
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    /**
     *
     * @param token token string from frontend
     * @param claimsResolver lambda function
     * @return
     * @param <T>  String or date
     */
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    /**
     * extract the whole body of token
     * @param token
     * @return
     */
    private Claims extractAllClaims(String token) {
        byte[] signingKey = SECRET_KEY.getBytes();
        return Jwts.parserBuilder()
                .setSigningKey(signingKey)
                .build()
                .parseClaimsJws(token).getBody();
    }

    /**
     * Check whether token is expired
     * @param token
     * @return
     */
    private Boolean isTokenExpired(String token) {


        return extractExpiration(token).before(new Date());
    }

    /**
     * create a token based on user details
     *
     * @param warehouseUserDetails
     * @return
     */
    public String generateToken(WarehouseUserDetails warehouseUserDetails) {

        // add claims which

        Map<String, Object> claims = Map.ofEntries(
                entry("userId", warehouseUserDetails.getId()),
                entry("username", warehouseUserDetails.getUsername()),
                entry("role", warehouseUserDetails.getAuthorities())
        );
        return createToken(claims, warehouseUserDetails.getUsername());
    }

    /**
     * The actual implementation of create token
     * @param claims
     * @param subject
     * @return
     */
    private String createToken(Map<String, Object> claims, String subject) {
        byte[] signingKey = SECRET_KEY.getBytes();


        return Jwts.builder()
                .setClaims(claims)
                .signWith(Keys.hmacShaKeyFor(signingKey), SignatureAlgorithm.HS512)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .compact();
    }

    /**
     * Check whether token is valid
     *
     * @param token             token string
     * @param warehouseUserDetails userDetails
     * @return
     */
    public Boolean isTokenValid(String token, WarehouseUserDetails warehouseUserDetails) {

        final String username = extractUsername(token);
        return (username.equals(warehouseUserDetails.getUsername()) && !isTokenExpired(token));
    }
}
