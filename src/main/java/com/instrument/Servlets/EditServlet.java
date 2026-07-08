package com.instrument.Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.instrument.Util.DBConn;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/EditInstrument")
public class EditServlet  extends HttpServlet{
	
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		 
		 

		 
		 
		 String name = request.getParameter("in_name");

	        try {
	            Connection con = DBConn.getConnection();
	            PreparedStatement ps = con.prepareStatement(
	                "SELECT * FROM instrument_detail WHERE Ins_Name = ?"
	            );
	            ps.setString(1, name);

	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {
	                request.setAttribute("name", rs.getString("Ins_Name"));
	                request.setAttribute("category", rs.getString("Ins_Category"));
	                request.setAttribute("desc", rs.getString("Ins_desc"));
	                request.setAttribute("updateDate", rs.getDate("Ins_Updated_Date"));
	            }

	            con.close();
	            request.getRequestDispatcher("update.jsp").forward(request, response);

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	 }
