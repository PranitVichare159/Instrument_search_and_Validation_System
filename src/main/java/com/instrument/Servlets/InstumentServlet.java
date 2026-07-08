package com.instrument.Servlets;

import jakarta.servlet.ServletException;   
import java.sql.Date;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.instrument.Util.*;
import com.instrument.model.Instrument_details;


@WebServlet("/InstumentDetail")
public class InstumentServlet extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 List<Instrument_details> list = new ArrayList<>();
		 try(Connection con= DBConn.getConnection()){
			 PreparedStatement ps = con.prepareStatement("select * from instrument_detail ");
			 ResultSet rs= ps.executeQuery();
			 
			 while(rs.next()) {
				 Instrument_details ins_detail= new Instrument_details();
				 ins_detail.setIns_Id(rs.getInt(1));
				 ins_detail.setIns_Name(rs.getString(2));
				 ins_detail.setIns_Category(rs.getString(3));
				 ins_detail.setIns_desc(rs.getString(4));
				 Date addedDate = rs.getDate(5);
				 if (addedDate != null) {
					    ins_detail.setIns_Added_Date(addedDate.toLocalDate());
				 }
				 Date updatedDate = rs.getDate(6);
				 if (updatedDate != null) {
					    ins_detail.setIns_Updated_Date(updatedDate.toLocalDate());
				 }
				 
				 list.add(ins_detail);

			 }
			 
		 }catch (Exception e) {
			 e.printStackTrace();
		 }
		 
		 request.setAttribute("instrumentList", list);
	        request.getRequestDispatcher("instrument.jsp").forward(request, response);
	
	
	
	}

}
