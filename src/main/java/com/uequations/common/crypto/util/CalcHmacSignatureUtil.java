package com.uequations.common.crypto.util;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.SignatureException;

public final class CalcHmacSignatureUtil {

    private static final String HmacSHA1 = "HmacSHA1";
    private static final String CHARSET = "UTF-8";

    public static String getSignatureForBytes(String secretKey, String content) throws java.security.SignatureException {

        try {
            SecretKeySpec keySpec = new SecretKeySpec(javax.xml.bind.DatatypeConverter.parseBase64Binary(secretKey),HmacSHA1);

            Mac mac = Mac.getInstance(HmacSHA1);

            mac.init(keySpec);

            byte[] digest = mac.doFinal(content.getBytes(CHARSET));

            return javax.xml.bind.DatatypeConverter.printBase64Binary(digest);
        } catch(Exception e) {
            throw new SignatureException("Failed to generate signature: " + e.getMessage());
        }
    }
}
