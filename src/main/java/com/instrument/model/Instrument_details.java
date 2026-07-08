package com.instrument.model;

import java.time.LocalDate;

public class Instrument_details {
	private int Ins_Id;
    private String Ins_Name;
    private String Ins_Category;
    private String Ins_desc;
    private LocalDate Ins_Added_Date;
    private LocalDate Ins_Updated_Date;

    public int getIns_Id() {
        return Ins_Id;
    }

    public void setIns_Id(int ins_Id) {
        Ins_Id = ins_Id;
    }

    public String getIns_Name() {
        return Ins_Name;
    }

    public void setIns_Name(String ins_Name) {
        Ins_Name = ins_Name;
    }

    public String getIns_Category() {
        return Ins_Category;
    }

    public void setIns_Category(String ins_Category) {
        Ins_Category = ins_Category;
    }

    public String getIns_desc() {
        return Ins_desc;
    }

    public void setIns_desc(String ins_desc) {
        Ins_desc = ins_desc;
    }

    public LocalDate getIns_Added_Date() {
        return Ins_Added_Date;
    }

    public void setIns_Added_Date(LocalDate ins_Added_Date) {
        Ins_Added_Date = ins_Added_Date;
    }

    public LocalDate getIns_Updated_Date() {
        return Ins_Updated_Date;
    }

    public void setIns_Updated_Date(LocalDate ins_Updated_Date) {
        Ins_Updated_Date = ins_Updated_Date;
    }
}
	    


