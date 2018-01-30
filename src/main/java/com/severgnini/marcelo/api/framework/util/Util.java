package com.severgnini.marcelo.api.framework.util;

import io.jsonwebtoken.impl.TextCodec;
import io.jsonwebtoken.impl.crypto.MacProvider;

public class Util {

    public static String createSecretKeyBase64(){
        byte[] keyBytes = MacProvider.generateKey().getEncoded();
        return TextCodec.BASE64.encode(keyBytes);
    }
}
