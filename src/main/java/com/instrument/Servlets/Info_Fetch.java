package com.instrument.Servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.instrument.Util.DBConn;


@WebServlet("/Info_Fetch")
public class Info_Fetch extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String name= request.getParameter("ins_name");
	PrintWriter out = response.getWriter();
	boolean isInfoAvailable=false;
	String Ins_name=null;
	String Ins_Cat=null;
	String Ins_Desc=null;
	String Ins_AddDate = null;
	String Ins_UpdateDate=null;
	try (Connection con = DBConn.getConnection()){
		PreparedStatement ps= con.prepareStatement("select * from instrument_detail where Ins_Name=?");
		ps.setString(1, name);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			isInfoAvailable = true;
			 Ins_name= rs.getString(2);
			 Ins_Cat = rs.getString(3);
			 Ins_Desc=rs.getString(4);
			 Ins_AddDate=rs.getString(5);
			 Ins_UpdateDate = rs.getString(6);
			
		}
		
		request.setAttribute("Name", Ins_name);
		request.setAttribute("Category", Ins_Cat);
		request.setAttribute("Desc", Ins_Desc);
		request.setAttribute("AddDate", Ins_AddDate);
		request.setAttribute("UpdateDate", Ins_UpdateDate);
		RequestDispatcher rd= request.getRequestDispatcher("Result.jsp");
		rd.include(request, response);
		
		
		
		
		
		

	
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	}

}
