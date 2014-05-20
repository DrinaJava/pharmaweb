package com.pharmaweb.www;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Connect the user from cookies
 * @author Anthony DENAUD
 *
 */
public class LoginCookieHandler {
	
	/**
	 * Log the user if his brower contains a login cookie
	 */
	public static void login(HttpServletRequest request){

		Cookie[] cookies = request.getCookies();
		
		if(cookies != null){
		
			for (int i = 0; i < cookies.length; i++) {
				if(cookies[i].getName().equals("idClient")){
					int idClient = Integer.parseInt(cookies[i].getValue());
					request.getSession().setAttribute("idClient", idClient);
				}
			}
		}
		
	}
}
