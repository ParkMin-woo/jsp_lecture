package com.javalec.ex;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionPool {

    public static Connection getConnection() throws SQLException {
        DataSource ds = null;
        Connection con = null;
        
        try {
            Context context = new InitialContext();
            // java:comp/env 는 무조건 고정
            // jdbc/test는 context.xml의 name과 반드시 같아야 한다.
            ds = (DataSource) context.lookup("java:comp/env/jdbc/test");
            con = ds.getConnection();
        } catch (NamingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return con;
    }
	
}
