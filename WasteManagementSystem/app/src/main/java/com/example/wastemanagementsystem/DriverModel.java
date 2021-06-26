package com.example.wastemanagementsystem;

import java.io.Serializable;

public class DriverModel implements Serializable {
    private String Name;
    private String Password;
    private String Mobile;
    private String Adress;
    private String Area;
    private String CNIC;
    private String EMAIL;
    private String Status;
    private int Id;
    public DriverModel() {

    }
    public DriverModel(String Name, String Password, String Mobile, String Adress, String Area, String CNIC, int Id,String EMAIL,String status) {
        this.Name =  Name;
        this.Password=Password;
        this.Mobile=Mobile;
        this.Adress=Adress;
        this.Area=Area;
        this.CNIC=CNIC;
        this.Id=Id;
        this.EMAIL=EMAIL;
        this.Status=status;

    }
    public void setName(String name) {
        Name = name;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public void setAdress(String adress) {
        Adress = adress;
    }

    public void setArea(String area) {
        Area = area;
    }

    public void setCNIC(String CNIC) {
        this.CNIC = CNIC;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getName() {
        return Name;
    }

    public String getPassword() {
        return Password;
    }

    public String getMobile() {
        return Mobile;
    }

    public String getAdress() {
        return Adress;
    }

    public String getArea() {
        return Area;
    }

    public String getCNIC() {
        return CNIC;
    }

    public int getId() {
        return Id;
    }
}
