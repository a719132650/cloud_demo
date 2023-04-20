package org.example.user.component.kgJWT;
/*
author : Kigooo
verson : 0.0.3
update date : 2022-02-14
*/

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.example.user.config.KgProperties;
import org.example.user.util.KgSpringUtil;

import java.util.Date;

public class KgJWTUtil {

    private static KgProperties kgProperties = KgSpringUtil.getBean(KgProperties.class);
    public static final long EXPIRATION = Long.parseLong(kgProperties.getTokenDefaultExpire())*1000;
    public static final String SELECT_KEY = kgProperties.getTokenSelectKey(); //密钥

    /**
     * 创建token
     * @param userOID 用户OID
     * @return java.lang.String token
     * @author
     * @date 2021/8/30 13:07
     */
    public static String createToken(String userOID){
        String token = Jwts
                .builder()
                .setSubject(userOID)
                .claim("userOID",userOID)
                // 签发时间
                .setIssuedAt(new Date())
                //设置过期时间
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                // 算法及密钥
                .signWith(SignatureAlgorithm.HS256,SELECT_KEY)
                // 压缩
                .compact();
        return token;
    }

    /**
     * 获取token过期时间
     * @param token token
     * @return java.util.Date
     * @author
     * @date 2021/8/30 13:07
     */
    public static Date getExpiration(String token){
        Claims claims = Jwts.parser().setSigningKey(SELECT_KEY).parseClaimsJws(token).getBody();
        return claims.getExpiration();
    }

    /**
     * 获取token创建时间
     * @param token token
     * @return java.util.Date
     * @author
     * @date 2021/8/30 13:08
     */
    public static Date getIssuedAt(String token){
        Claims claims = Jwts.parser().setSigningKey(SELECT_KEY).parseClaimsJws(token).getBody();
        return claims.getIssuedAt();
    }

    /**
     * 获取token中userOID
     * @param token token
     * @return java.lang.String
     * @author
     * @date 2021/8/30 13:08
     */
    public static String getUserOIDByToken(String token){
        String str = "";
        try{
            Claims claims = Jwts.parser().setSigningKey(SELECT_KEY).parseClaimsJws(token).getBody();
            str = claims.get("userOID").toString();
        }catch (Exception e){}
        return str;
    }
}
