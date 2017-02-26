package com.demo.jianjunhuang.tools.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密
 * @author SikiChan
 * @since 2016.1.25
 */
public class MD5Util {
	protected static MessageDigest md = null;
	static{
		 try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	
	public static String getMD5String(String s){
		StringBuffer sb = new StringBuffer();
		md.update(s.getBytes());
		byte[] b = md.digest();
		 for (int i = 0; i < b.length; i++) {
             String str = Integer.toHexString(b[i] & 0xFF);
             if (str.length() == 1) {
                 str += "F";
             }
             sb.append(str);
         }
		return sb.toString().toLowerCase();
	}
	
}
