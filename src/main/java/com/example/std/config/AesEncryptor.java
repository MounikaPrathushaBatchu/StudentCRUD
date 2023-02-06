package com.example.std.config;

import java.security.GeneralSecurityException;
import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.SerializationUtils;

import jakarta.persistence.AttributeConverter;
import lombok.SneakyThrows;
//import lombok.Value;

@Configuration
public class AesEncryptor implements AttributeConverter<Object, String> {
	
	//@Value("${aes.encryption.key}")
	private String encryptionKey = "this-is-test-key";
	
	private final String encriptionCipher = "AES";
	
	private Key key;
	private Cipher cipher;
	
	private Key getKey() {
		if(key == null)
			key = new SecretKeySpec(encryptionKey.getBytes(),encriptionCipher);
		return key;
	}
	
	private Cipher getCipher() throws GeneralSecurityException {
		if(cipher == null)
			cipher = Cipher.getInstance(encriptionCipher);
		return cipher;
	}
	private void initCipher(int encryptMode) throws GeneralSecurityException{
		getCipher().init(encryptMode, getKey());
	}
	@SneakyThrows
	@Override
	public String convertToDatabaseColumn(Object attribute) {
		if(attribute == null)
			return null;
		try{
			initCipher(Cipher.ENCRYPT_MODE);
			byte[] bytes = SerializationUtils.serialize(attribute);
			return Base64.getEncoder().encodeToString(getCipher().doFinal(bytes));
		}
		catch(Exception e) {
			e.addSuppressed(e);
		}
		return null;
	}
	@SneakyThrows
	@Override
	public Object convertToEntityAttribute(String dbData) {
		if(dbData == null)
			return null;
		try {
		initCipher(Cipher.DECRYPT_MODE);
		byte[] bytes = getCipher().doFinal(Base64.getDecoder().decode(dbData));
		return SerializationUtils.deserialize(bytes);
		}
		catch(Exception e) {
			e.addSuppressed(e);
		}
		return null;
	}
}