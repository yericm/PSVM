/*
package com.bywin.util;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import net.minidev.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

*/
/**
 * created by yeric on 2020/1/10
 *//*

public class JwtToken {
    */
/**
     * 1.创建一个32-byte的密匙
     *//*


    private static final byte[] secret = "geiwodiangasfdjsikolkjikolkijswe".getBytes();


    //生成一个token
    public static String creatToken(Map<String,Object> payloadMap) throws JOSEException {

        //3.先建立一个头部Header
        */
/**
         * JWSHeader参数：1.加密算法法则,2.类型，3.。。。。。。。
         * 一般只需要传入加密算法法则就可以。
         * 这里则采用HS256
         *
         * JWSAlgorithm类里面有所有的加密算法法则，直接调用。
         *//*

        JWSHeader jwsHeader = new JWSHeader(JWSAlgorithm.HS256);

        //建立一个载荷Payload
        Payload payload = new Payload(new JSONObject(payloadMap));

        //将头部和载荷结合在一起
        JWSObject jwsObject = new JWSObject(jwsHeader, payload);

        //建立一个密匙

        JWSSigner jwsSigner = new MACSigner(secret);

        //签名
        jwsObject.sign(jwsSigner);

        //生成token
        return jwsObject.serialize();
    }

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("userName", "sjw");
        map.put("appShortName", "交警");
        map.put("exp", 30);
        try {
            String s = creatToken(map);
            System.out.println(s);
        } catch (JOSEException e) {
            e.printStackTrace();
        }
    }
}
*/
