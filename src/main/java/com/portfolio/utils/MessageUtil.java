package com.portfolio.utils;

import java.util.ResourceBundle;

public class MessageUtil {
    public static String getMessage(String key, String lang) {
    	
    	ResourceBundle bundle = null;
    	
    	if (lang == null) { // 공통인 경우
    		bundle = ResourceBundle.getBundle("messages", new java.util.Locale("ko_KR"));
        	return bundle.getString(key);
        } else { // 언어 변경이 가능한 경우
        	bundle = ResourceBundle.getBundle("messages", new java.util.Locale(lang));
        	return bundle.getString(key + "." + lang);
        }
        
    }
}

