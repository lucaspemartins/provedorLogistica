package com.logistica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthenticationDAO {

	public AuthenticationModel findUser(Connection conn, String username) throws SQLException {
		String sql = "select * from users where username = ?";
		PreparedStatement pstm;
		pstm = conn.prepareStatement(sql);
		pstm.setString(1, username);
		ResultSet rs = pstm.executeQuery();
		AuthenticationModel authModel = new AuthenticationModel();
		if (rs.next())
		{
			String userName = rs.getString("username");
			String passWord = rs.getString("password");
			authModel = new AuthenticationModel(userName, passWord);
			return authModel;
		}
		return null;
	}

}
