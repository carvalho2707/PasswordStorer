package main.java.pt.tiago.passwordstorer.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

public class CipherUtils {
	
	public static String encrypt(String toEncrypt) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException{
		String key = "Bar12345Bar12345"; // 128 bit key
        // Create key and cipher
        Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        // encrypt the text
        cipher.init(Cipher.ENCRYPT_MODE, aesKey);
        byte[] encrypted = cipher.doFinal(toEncrypt.getBytes("UTF8"));
        //System.err.println(DatatypeConverter.printBase64Binary(encrypted));
		return new String(DatatypeConverter.printBase64Binary(encrypted));
	}
	
	public static String decrypt(String toEncrypt) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException{
		String key = "Bar12345Bar12345"; // 128 bit key
        // Create key and cipher
        Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
         //decrypt the text
        cipher.init(Cipher.DECRYPT_MODE, aesKey);
        String decrypted = new String(cipher.doFinal(DatatypeConverter.parseBase64Binary(toEncrypt)));
        //System.err.println(decrypted);
		return new String(decrypted);
	}

}
