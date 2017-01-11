package com.superxu.action.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class SSOCheck {

	public static boolean checklogin(String username,String password){
		if(username.equals("123")&& password.equals("123")){
			return true;
		}
		return false;
	}
	
	public static boolean checkcookie(HttpServletRequest request){
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for(Cookie cookie:cookies){
				if(cookie.getName().equals("ssocookie")&& cookie.getValue().equals("sso")){
					return true;
				}
			}
		}
		return false;
	}
}
