package com.instrument.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.concurrent.ExecutionException;

import com.instrument.Util.DBConn;


@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("username");
		String password= request.getParameter("password");
		
		boolean isValidUser=false;
		
		try {
			Connection con = DBConn.getConnection();
			PreparedStatement ps= con.prepareStatement("select * from admin_credentials where Username =? and Password =? ");
			ps.setString(1, uname);
			ps.setString(2, password);
			
			ResultSet rs= ps.executeQuery();
			
			if(rs.next()) {
				isValidUser=true;
				con.close();
			}
			

		}catch(Exception e) {
			e.printStackTrace();
		}
		if(isValidUser) {
			response.sendRedirect(request.getContextPath() + "/InstrumentList");
			 
				
			}
			else {
				response.sendRedirect("adminLogin.jsp?error=InvalidCredentials");
			}
		
		
	}

}
