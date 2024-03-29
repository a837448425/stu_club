package com.lxz.subject.infra.basic.utils;

import com.alibaba.druid.filter.config.ConfigTools;

import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;

/**
 *
 * 数据库加密
 *
 * @Author: luo
 * @date: 2023/12/12 19:56
 * @Description:
 * @Version: 1.0
 */
public class DruidEncryptUtil {

    private static String publicKey;

    private static String privateKey;

    static {
        try {
            String[] keyPair = ConfigTools.genKeyPair(512);
            privateKey = keyPair[0];
            System.out.println("privateKey:" + privateKey);

            publicKey = keyPair[1];
            System.out.println("publicKey:" + publicKey);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (NoSuchProviderException e) {
            throw new RuntimeException(e);
        }
    }

    public static String encrypt(String  plainText){
        try {
            String encrypt = ConfigTools.encrypt( privateKey,plainText);
            System.out.println("encrypt:" + encrypt);
            return encrypt;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String decrypt(String encryptText){
        try {
            String decrypt = ConfigTools.encrypt( publicKey,encryptText);
            System.out.println("decrypt:" + decrypt);
            return decrypt;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

     public static void main(String[] args) {
         String encrypt = encrypt("123456");
         System.out.println("encrypt:" + encrypt);
     }
}
