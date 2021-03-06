package com.logistica;

import java.io.IOException;
import java.sql.Connection;
import java.util.Base64;
import java.util.StringTokenizer;

public class AuthenticationService {

	public boolean authenticate(String authCredentials) {
		if (null == authCredentials)
			return false;
		// header value format will be "Basic encodedstring" for Basic
		// authentication. Example "Basic YWRtaW46YWRtaW4="
		final String encodedUserPassword = authCredentials.replaceFirst("Basic"+ " ", "");
		String usernameAndPassword = null;
		try {
			byte[] decodedBytes = Base64.getDecoder().decode(encodedUserPassword);
			usernameAndPassword = new String(decodedBytes, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		final StringTokenizer tokenizer = new StringTokenizer(usernameAndPassword, ":");
		final String username = tokenizer.nextToken();
		final String password = tokenizer.nextToken();
		// we have fixed the userid and password as admin
		// call some UserService/LDAP here
//		boolean authenticationStatus = "admin".equals(username) && "admin".equals(password);
//		return authenticationStatus;
		
		ConnectionFactory connectionFactory = new ConnectionFactory();

		try {
			Connection conn = connectionFactory.getConnection();
			AuthenticationDAO authDAO = new AuthenticationDAO();
			AuthenticationModel authModel = authDAO.findUser(conn, username);
			
			if (authModel.getUsername() == null && authModel.getPassword() == null) {
				return false;
			}
			boolean authenticationStatus = authModel.getUsername().equals(username) && authModel.getPassword().equals(password);
			return authenticationStatus;
		} catch (Exception e) {
			return false;
		}
		
	}
}
