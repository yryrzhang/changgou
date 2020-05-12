package com.changgou.system.util;

/**
 * @author : Gordon Zhang
 * @Date: 5/7/2020 9:43 AM
 * @Version 1.0
 */

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 * jwt校验工具类
 */
public class JWTUtil {
    //有效期为 1 hour
    public static final Long JWT_TTL = 3600000L;

    //设置秘钥明文
    public static final String JWT_KEY = "itcast";

    /**
     * 生成加密后的秘钥 secretKey
     *
     * @return
     */
    public static SecretKey generalKey() {
        byte[] encodedkey = Base64.getDecoder().decode(JWTUtil.JWT_KEY);
        SecretKey secretKey = new SecretKeySpec(encodedkey, 0, encodedkey.length, "AES");
        return secretKey;
    }

    /**
     * 解析
     *
     * @param jwt
     * @return
     * @throws Exception
     */

    public static Claims parseJWT(String jwt) {
        SecretKey secretKey = generalKey();
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwt).getBody();
    }
}
