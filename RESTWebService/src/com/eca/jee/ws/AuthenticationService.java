package com.eca.jee.ws;

public class AuthenticationService {

	public static boolean authenticate(String token) {
		// TODO Auto-generated method stub
		if(token.equals("daohaodesi")) return true;
		return false;
	}

}
