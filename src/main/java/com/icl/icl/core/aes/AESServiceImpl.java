package com.icl.icl.core.aes;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.net.URLCodec;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;

@Service
public class AESServiceImpl implements AESService {
    private String iv;
    private Key keySpec;
    private URLCodec codec = new URLCodec();

    public AESServiceImpl(){
        try{
            // key 값은 16자 이상
            String key = "icl-private-keys";
            this.iv = key.substring(0, 16);

            byte[] keyBytes = new byte[16];
            byte[] b = key.getBytes(StandardCharsets.UTF_8);
            int len = b.length;
            if (len > keyBytes.length) {
                len = keyBytes.length;
            }
            System.arraycopy(b, 0, keyBytes, 0, len);

            this.keySpec = new SecretKeySpec(keyBytes, "AES");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public String encode(String str) {
        String enStr = null;

        try{
            Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
            c.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(iv.getBytes()));

            byte[] encrypted = c.doFinal(str.getBytes(StandardCharsets.UTF_8));

            enStr = new String(Base64.encodeBase64(encrypted));
            enStr = codec.encode(enStr);
        }catch (Exception e){
            e.printStackTrace();
        }

        return enStr;
    }

    @Override
    public String decode(String str) {
        String deStr = null;

        try{
            str = codec.decode(str);
            Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
            c.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(iv.getBytes(StandardCharsets.UTF_8)));

            byte[] byteStr = Base64.decodeBase64(str.getBytes());

            deStr = new String(c.doFinal(byteStr), StandardCharsets.UTF_8);
        }catch (Exception e){
            e.printStackTrace();
        }

        return deStr;
    }
}
