package com.instrument.Servlets;

import jakarta.servlet.ServletException; 
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import com.instrument.Util.DBConn;


@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("instrument.jsp");
    }


	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

		 String name = request.getParameter("in_name");
	        String classification = request.getParameter("in_class");
	        String desc = request.getParameter("in_desc");
	        Date date = Date.valueOf(request.getParameter("in_UpdateDate"));

	        try {
	            Connection con = DBConn.getConnection();
	            PreparedStatement ps = con.prepareStatement(
	                "UPDATE instrument_detail SET Ins_Category=?, Ins_desc=?, Ins_Updated_Date=? WHERE Ins_Name=?"
	            );

	            ps.setString(1, classification);
	            ps.setString(2, desc);
	            ps.setDate(3, date);
	            ps.setString(4, name);

	            ps.executeUpdate();
	            
	            int rows=ps.executeUpdate();
	            
	            if (rows>0) {
	                response.sendRedirect(request.getContextPath() + "/InstrumentList");
	            }
	            else {
	            	response.sendRedirect("addinstrument.jsp");
	            }
	            
	            con.close();

	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    

}
