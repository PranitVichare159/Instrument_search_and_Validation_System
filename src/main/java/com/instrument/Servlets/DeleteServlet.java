package com.instrument.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.instrument.Util.DBConn;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {

	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws IOException {
		String name= request.getParameter("in_name");
		try {
			Connection con = DBConn.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from instrument_detail where Ins_Name=? ");
			ps.setString(1, name);
			
			int row= ps.executeUpdate();
			
			con.close();
		}catch (Exception e) {
			e.printStackTrace();
		
		}
        response.sendRedirect(request.getContextPath() + "/InstrumentList");


	}

}
