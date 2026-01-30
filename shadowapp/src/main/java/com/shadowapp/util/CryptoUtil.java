package com.shadowapp.util;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Service;


@Service
public class CryptoUtil {

	public static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
	public static final String DES_ENCRYPTION_SCHEME = "DES";
	public static final String DEFAULT_ENCRYPTION_KEY = "scatisqrapp";
	// public static final String DEFAULT_ENCRYPTION_KEY = ("X" +
	// (DU.trimTime(DU.addDays(new Date(), 1, true)).getTime()))
	// .substring(0, 8);

	public static final String DEFAULT_ENCRYPTION_SCHEME = DES_ENCRYPTION_SCHEME;
	private KeySpec keySpec;
	private SecretKeyFactory keyFactory;
	private Cipher cipher;
	private static final String UNICODE_FORMAT = "UTF8";

	public CryptoUtil() throws EncryptionException {
		this(DEFAULT_ENCRYPTION_SCHEME, DEFAULT_ENCRYPTION_KEY);
	}

	public CryptoUtil(String encryptionKey) throws EncryptionException {
		this(DEFAULT_ENCRYPTION_SCHEME, encryptionKey);
	}

	public CryptoUtil(String encryptionScheme, String encryptionKey) throws EncryptionException {
		if (encryptionKey == null) {
			throw new IllegalArgumentException("encryption key was null");
		}
		if (encryptionKey.trim().length() < 8) {
			throw new IllegalArgumentException("encryption key was less than 8 characters");
		}
		try {
			byte[] keyAsBytes = encryptionKey.getBytes(UNICODE_FORMAT);
			if (encryptionScheme.equals(DESEDE_ENCRYPTION_SCHEME)) {
				keySpec = new DESedeKeySpec(keyAsBytes);
			} else if (encryptionScheme.equals(DES_ENCRYPTION_SCHEME)) {
				keySpec = new DESKeySpec(keyAsBytes);
			} else {
				throw new IllegalArgumentException("Encryption scheme not supported: " + encryptionScheme);
			}
			keyFactory = SecretKeyFactory.getInstance(encryptionScheme);
			cipher = Cipher.getInstance(DEFAULT_ENCRYPTION_SCHEME);
		} catch (InvalidKeyException e) {
			throw new EncryptionException(e);
		} catch (UnsupportedEncodingException e) {
			throw new EncryptionException(e);
		} catch (NoSuchAlgorithmException e) {
			throw new EncryptionException(e);
		} catch (NoSuchPaddingException e) {
			throw new EncryptionException(e);
		}
	}

	public String encrypt(String unencryptedString, boolean encode)
			throws EncryptionException, UnsupportedEncodingException {
		if (encode) {
			return URLEncoder.encode(encrypt(unencryptedString), "UTF-8");
		} else {
			return encrypt(unencryptedString);
		}
	}

	public String decrypt(String encryptedString, boolean decode)
			throws EncryptionException, UnsupportedEncodingException {
		if (decode) {
			return decrypt(URLDecoder.decode(encryptedString, "UTF-8"));
		} else {
			return decrypt(encryptedString);
		}
	}

	public String encrypt(String unencryptedString) throws EncryptionException {
		if (unencryptedString == null || unencryptedString.trim().length() == 0) {
			throw new IllegalArgumentException("unencrypted string was null or empty");
		}
		try {
			SecretKey key = keyFactory.generateSecret(keySpec);
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] cleartext = unencryptedString.getBytes(UNICODE_FORMAT);
			byte[] ciphertext = cipher.doFinal(cleartext);

			// Use URL-safe Base64 encoding
			Base64.Encoder encoder = Base64.getUrlEncoder();
			return encoder.encodeToString(ciphertext);
		} catch (Exception e) {
			throw new EncryptionException(e);
		}
	}

	public String decrypt(String encryptedString) throws EncryptionException {
		if (encryptedString == null || encryptedString.trim().length() <= 0) {
			throw new IllegalArgumentException("encrypted string was null or empty");
		}
		try {
			SecretKey key = keyFactory.generateSecret(keySpec);
			cipher.init(Cipher.DECRYPT_MODE, key);

			// Use URL-safe Base64 decoding
			Base64.Decoder decoder = Base64.getUrlDecoder();
			byte[] cleartext = decoder.decode(encryptedString);
			byte[] ciphertext = cipher.doFinal(cleartext);

			return bytes2String(ciphertext);
		} catch (Exception e) {
			throw new EncryptionException(e);
		}
	}

	private static String bytes2String(byte[] bytes) {
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < bytes.length; i++) {
			stringBuffer.append((char) bytes[i]);
		}
		return stringBuffer.toString();
	}

	public static class EncryptionException extends Exception {
		private static final long serialVersionUID = -2541346667624184847L;

		public EncryptionException(Throwable t) {
			super(t);
		}
	}

	public static void main(String args[])
			throws EncryptionException, NoSuchAlgorithmException, NoSuchPaddingException, IOException {
		CryptoUtil cu = new CryptoUtil();
		String encName = cu.encrypt("getKYCURL");
		System.out.println(encName);
		// encName="c2Nmb2xsb3d1cDpzZWNyZXQ=";
		String dncName = cu.decrypt("KIOismWUOWEREEkxzikVzA");
		System.out.println(dncName);

		Charset credentialsCharset = StandardCharsets.UTF_8;

		byte[] base64Token = "scemployee:secret".getBytes(StandardCharsets.UTF_8);
		byte[] decoded = null;
		try {
			decoded = Base64.getEncoder().encode(base64Token);
		} catch (IllegalArgumentException e) {
		}

		String token = new String(decoded, credentialsCharset);

		System.out.println(token);

	}

	public String getrandomOTP() {
		String[] i = new String[25];
		Random rand = new Random();
		String randVal = String.valueOf(rand.nextLong());
		Date val = new Date();
		int secVal = val.getSeconds();
		/* System.out.println(randVal.substring(0, 6)); */

		if (String.valueOf(secVal).length() == 1) {
			randVal = randVal.substring(0, 7) + "0" + secVal + randVal.substring(8, 15);
		} else if (String.valueOf(secVal).length() == 0) {
			randVal = randVal.substring(0, 7) + "00" + randVal.substring(8, 15);
		} else {
			randVal = randVal.substring(0, 7) + secVal + randVal.substring(8, 15);
		}
		if (Long.valueOf(randVal) < 0L) {
			randVal = String.valueOf(Long.valueOf(randVal) * (-1L));
			if (randVal.length() < 16) {
				randVal = randVal + "0";
			}
			randVal = randVal.substring(0, 4);
			System.out.println(randVal);
			return randVal;
		} else {
			randVal = randVal.substring(0, 4);
			System.out.println(randVal);
			return randVal;
		}
	}

	private static final String SECRET_KEY = "scaitapplication"; // MUST be 16 bytes
	private static final String IV = "1234567890123456"; // MUST be 16 bytes

	private static byte[] fixAESKey(String key, int length) {
		return Arrays.copyOf(key.getBytes(StandardCharsets.UTF_8), length); // Truncate or pad
	}

	// Decrypt function
	public static String decrypts(String encryptedText) throws Exception {
		byte[] keyBytes = fixAESKey(SECRET_KEY, 16); // Fix key length to 16 bytes
		SecretKeySpec secretKey = new SecretKeySpec(keyBytes, "AES");
		

		byte[] ivBytes = IV.getBytes(StandardCharsets.UTF_8);

		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(ivBytes));
		
		Base64.Decoder decoder = Base64.getUrlDecoder();
		byte[] cleartext = decoder.decode(encryptedText);
		byte[] ciphertext = cipher.doFinal(cleartext);

		return new String(ciphertext, StandardCharsets.UTF_8);
	}
	
	public static String encrypts(String plainText) throws Exception {
        byte[] keyBytes = fixAESKey(SECRET_KEY, 16);
        SecretKeySpec secretKey = new SecretKeySpec(keyBytes, "AES");

        byte[] ivBytes = IV.getBytes(StandardCharsets.UTF_8);
        IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);

        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
        
        String base64Encrypted = Base64.getEncoder().encodeToString(encryptedBytes);

		// Replace '+' with '-' and '/' with '_'
		String modifiedBase64Encrypted = base64Encrypted.replace("+", "-").replace("/", "_");

		return modifiedBase64Encrypted;

    }



}
