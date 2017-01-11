package com.superxu.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.superxu.action.util.SSOCheck;

/**
 * 登录校验 
 * 1、校验用户名密码
 * 2、校验cookie
 * @author xuzj
 *
 */
public class SSOAction extends ActionSupport{

	private String username;
	private String password;
	private String gotourl;

	public String dologin(){
		//同域下的sso
		boolean ok = SSOCheck.checklogin(username, password);
		if(ok){
			Cookie cookie = new Cookie("ssocookie", "sso");
			cookie.setPath("/");//设置到顶层
			HttpServletResponse response = ServletActionContext.getResponse();
			response.addCookie(cookie);
			return SUCCESS;
		}
		return "login";
	}
	
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getGotourl() {
		return gotourl;
	}

	public void setGotourl(String gotourl) {
		this.gotourl = gotourl;
	}
}
