package com.util;

import net.sf.json.JSONObject;
import org.apache.xerces.impl.dv.util.Base64;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class RSATest {

    /**
     * 加密算法RSA
     */
    public static final String KEY_ALGORITHM = "RSA";

    /**
     * RSA最大加密明文大小
     */
    private static final int MAX_ENCRYPT_BLOCK = 117;

    /**
     * 公钥9
     */
    private static final String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCQIRn63V8jQ73r9E5KA0+RdqIs826wWja0OI+ADjmXxaoLSS8R32to/nlHQcwqmYwg+GtBgxE2xPAZWRKxtQbbfk/+zWKAtdsIXdeVrmiBlvMZzNtrimGU38ia+oYNFjefqQU1bRPd5Sa3xJ0N3bLrc0xB+Nw161TeLaNkkgxx5wIDAQAB";

    /**
     * <p>
     * 公钥加密
     * </p>
     *
     * @param data 源数据
     * @param publicKey 公钥(BASE64编码)
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPublicKey(byte[] data, String publicKey) throws Exception {
        byte[] keyBytes = Base64Utils.decode(publicKey);
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key publicK = keyFactory.generatePublic(x509KeySpec);
        // 对数据加密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, publicK);
        int inputLen = data.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段加密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
                cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(data, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_ENCRYPT_BLOCK;
        }
        byte[] encryptedData = out.toByteArray();
        out.close();
        return encryptedData;
    }


    /**
     * <p>
     * 用公钥加密需要传输的数据,加密后的二进制数据使用BASE64编码
     * </p>
     *
     * data :{mail": "zhamin","miId": "154656788"}
     *
     * @param data
     * @return
     * @throws Exception
     */
    public static String encryptByPublicKey(String data) throws Exception{
        byte[] entry = encryptByPublicKey(data.getBytes(),publicKey);
        return new String(Base64.encode(entry));
    }
}
