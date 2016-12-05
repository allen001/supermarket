package com.jas.util;

public class StringUtils extends org.springframework.util.StringUtils {

	public static String joinLeftString(Object obj,int len,String chr){
		if(obj!=null){
			String src = String.valueOf(obj);
			for (int i = 1; i < len; i++) {
				src = (chr+src);
			}
			return src;
		}
		return "";
	}
}
