package com.taotr.stockquant.commons.utils.encrypt;

import org.apache.commons.lang3.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密算法
 */
public class Md5Encrypt {

	/**
	 * Used building output as Hex
	 */
	private static final char[] DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
	private static final byte[] keyBytes = {0x02, 0x04, 0x06, 0x08, 0x10, 0x12, 0x14, 0x16, (byte)0x99, (byte)0x97, (byte)0x95, (byte)0x93, (byte)0x91, (byte)0x89, (byte)0x87, (byte)0x85, 0x02, 0x04,
			0x06, 0x08, 0x10, 0x12, 0x14, 0x16};
	private static final String Algorithm = "DESede/ECB/NoPadding"; // c ECB/Zeros
	private static final byte[] IV = {1, 2, 3, 4, 5, 6, 7, 8};

	/**
	 * 对字符串进行MD5加密
	 * @param text
	 *        明文
	 * @return 密文
	 */
	public static String md5(String text) {
		return md5ByEncode(text, "GBK");
	}

	public static String md5ByEncode(String text, String encode) {
		MessageDigest msgDigest = null;
		try {
			msgDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalStateException("System doesn't support MD5 algorithm.");
		}
		try {
			msgDigest.update(text.getBytes(encode));
		} catch (UnsupportedEncodingException e) {
			throw new IllegalStateException("System doesn't support your  EncodingException.");
		}
		byte[] bytes = msgDigest.digest();
		String md5Str = new String(encodeHex(bytes));
		return md5Str;
	}

	private static char[] encodeHex(byte[] data) {
		int l = data.length;
		char[] out = new char[l << 1];
		// two characters form the hex value.
		for (int i = 0, j = 0; i < l; i++) {
			out[j++] = DIGITS[(0xF0 & data[i]) >>> 4];
			out[j++] = DIGITS[0x0F & data[i]];
		}
		return out;
	}

	public static void main(String[] arg) {
		System.out.println(decode("050275607216babc5acdf3b6525a96df"));
		System.out.println(MD5("147258"));
	}


	/**
	 * MD5对字符串加密
	 * @param str
	 * @return
	 */
	public static String MD5(byte[] bytes) {
		StringBuffer strBuf = new StringBuffer("");
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.reset();
			md.update(bytes);
			byte[] b = md.digest();
			for (int i = 0; i < b.length; i++) {
				int temp = b[i] & 0xff;
				if (temp < 16) strBuf.append("0");
				strBuf.append(Integer.toHexString(temp));
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return strBuf.toString();
	}

	/**
	 * MD5对字符串加密
	 * @param str
	 * @return
	 */
	public static String MD5(String str) {
		return MD5(str.getBytes());
	}

	/**
	 * 解密
	 * @param src 密文
	 * @return
	 */
	public static String decode(String src) {
		if (StringUtils.isBlank(src)) {
			return "";
		}
		return decryptMode(keyBytes, src);
	}

	/**
	 * 指定密钥解密
	 * @param keybyte 密钥
	 * @param src 密文
	 * @return
	 */
	public static String decryptMode(byte[] keybyte, String src) {
		try {
			SecretKey deskey = new SecretKeySpec(keybyte, "DESede");
			Cipher c1 = Cipher.getInstance(Algorithm);

			IvParameterSpec iv = new IvParameterSpec(IV);
			// c1.init(Cipher.DECRYPT_MODE, deskey, iv);
			c1.init(Cipher.DECRYPT_MODE, deskey);
			byte[] d = c1.doFinal(hex2Byte(src));

			return (new String(d)).trim();
		} catch (Exception e) {
			e.printStackTrace();
			// e.getMessage();
		}
		return "";
	}

	private static byte[] hex2Byte(String str) {
		if (str == null) return null;
		str = str.trim();
		int len = str.length();
		if (len == 0 || len % 2 == 1) return null;
		byte[] b = new byte[len / 2];
		try {
			for (int i = 0; i < str.length(); i += 2) {
				// b[i / 2] = (byte) Integer
				// .decode("0x" + str.substring(i, i + 2)).intValue();

				int byteValue = Integer.parseInt(str.substring(i, i + 2), 16);
				b[i / 2] = (byte)byteValue;
			}
			return b;
		} catch (Exception e) {
			return null;
		}
	}
}