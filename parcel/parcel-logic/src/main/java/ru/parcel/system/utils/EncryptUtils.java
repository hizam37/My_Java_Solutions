package ru.parcel.system.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptUtils {

	public static String encrypt(String value) {

		MessageDigest m;

		StringBuilder builder=new StringBuilder();

		try {

		m = MessageDigest.getInstance("MD5");

		for(byte b: m.digest(value.getBytes())) {

		builder.append(String.format("%02X", b));

		}

		} catch (NoSuchAlgorithmException e) {

		e.printStackTrace();

		}

		return builder.toString();

		}
}
