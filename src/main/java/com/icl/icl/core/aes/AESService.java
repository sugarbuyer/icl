package com.icl.icl.core.aes;

public interface AESService {
    String encode(String str); // 암호화
    String decode(String str); // 복호화
}
