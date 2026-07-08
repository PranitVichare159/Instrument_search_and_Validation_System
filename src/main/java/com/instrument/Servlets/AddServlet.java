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
import java.sql.ResultSet;

import com.instrument.Util.DBConn;


@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String name = request.getParameter("in_name");
        String category = request.getParameter("in_class");
        String desc = request.getParameter("in_desc");

        try (Connection con = DBConn.getConnection()) {

            // CHECK DUPLICATE
            PreparedStatement check =
                con.prepareStatement("SELECT COUNT(*) FROM instrument_detail WHERE ins_name=?");
            check.setString(1, name);
            ResultSet rs = check.executeQuery();

            if (rs.next() && rs.getInt(1) > 0) {
                response.sendRedirect("Add.jsp?msg=AlreadyExists");
                return;
            }

            PreparedStatement ps =
                con.prepareStatement("insert into instrument_detail values(insdetail_generator.nextval,?,?,?,sysdate,sysdate)");

            ps.setString(1, name);
            ps.setString(2, category);
            ps.setString(3, desc);

            int rows=ps.executeUpdate();
            
            if (rows>0) {
                response.sendRedirect(request.getContextPath() + "/InstrumentList");
            }
            else {
            	response.sendRedirect("addinstrument.jsp");
            }
            


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
