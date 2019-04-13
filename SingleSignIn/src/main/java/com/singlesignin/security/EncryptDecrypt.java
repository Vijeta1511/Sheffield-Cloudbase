package com.singlesignin.security;
/**
 * This class provides methods to encrypt and decrypt a string.
 * @author sanika
 * Ref: https://docs.oracle.com/javase/7/docs/technotes/guides/security/crypto/CryptoSpec.html#AppA
 */

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class EncryptDecrypt {

    private static SecretKeySpec secretKey;
    private static byte[] key;
 
    /*
     * This method construct a secret key
     */
    public static void setKey(String myKey)
    {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1"); // MessageDigest class provides applications the functionality of a message digest algorithm, such as SHA-1 or SHA-256.
            key = sha.digest(key); // Completes the hash computation by performing final operations such as padding.
            key = Arrays.copyOf(key, 8);
            secretKey = new SecretKeySpec(key, "DES"); // Constructs a secret key from the given byte array.
            System.out.println("secertkey: "+secretKey);
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
    }
 
    public static String encrypt(String strToEncrypt, String secret)
    {
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding"); // cipher transformation : "(algorithm/mode/padding) > (DES/ECB/NoPadding)"
            cipher.init(Cipher.ENCRYPT_MODE, secretKey); //Encryption of data with a secret key.
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8"))); // getEncoder(): Returns a Base64.Encoder that encodes using the Basic type base64 encoding scheme.
            // encodeToString(byte[] src): Encodes the specified byte array into a String using the Base64 encoding scheme.
            // doFinal(byte[] input): Encrypts or decrypts data in a single-part operation, or finishes a multiple-part operation.
        }
        catch (Exception e)
        {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }
 
    public static String decrypt(String strToDecrypt, String secret)
    {
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt))); // getDecoder(): Returns a Base64.Decoder that decodes using the Basic type base64 encoding scheme.
        }
        catch (Exception e)
        {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }
}
	  
		  
