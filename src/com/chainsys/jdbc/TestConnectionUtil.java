package com.chainsys.jdbc;

import java.sql.Connection;

public class TestConnectionUtil {

	public static void main(String[] args) {
		Connection connection = ConnectionUtil.getconnection();
		System.out.println(connection);
	}

}
