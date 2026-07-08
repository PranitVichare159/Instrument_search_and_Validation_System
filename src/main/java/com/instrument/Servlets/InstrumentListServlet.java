package com.instrument.Servlets;

import java.io.IOException; 
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.instrument.Util.*;

import com.instrument.model.Instrument_details;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/InstrumentList")
public class InstrumentListServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Instrument_details> list = new ArrayList<>();

        try {
            Connection con = DBConn.getConnection();
            PreparedStatement ps =
                con.prepareStatement("SELECT * FROM instrument_detail");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Instrument_details ins = new Instrument_details();
                ins.setIns_Id(rs.getInt("Ins_Id"));
                ins.setIns_Name(rs.getString("Ins_Name"));
                ins.setIns_Category(rs.getString("Ins_Category"));
                ins.setIns_desc(rs.getString("Ins_desc"));
                Date addedDate = rs.getDate("Ins_Added_Date");
                if (addedDate != null) {
                    ins.setIns_Added_Date(addedDate.toLocalDate());
                }

                Date updatedDate = rs.getDate("Ins_Updated_Date");
                if (updatedDate != null) {
                    ins.setIns_Updated_Date(updatedDate.toLocalDate());
                }

                list.add(ins);
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("instrumentList", list);
        request.getRequestDispatcher("instrument.jsp")
               .forward(request, response);
    }
}