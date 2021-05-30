package com.example.garbagemanagementsystem;

public class DriverModel {
    private String Name;
    private String Password;
    private String Mobile;
    private String Adress;
    private String Area;
    private String CNIC;
    private int Id;

    public DriverModel() {

    }

    public DriverModel(String Name, String Password, String Mobile, String Adress, String Area, String CNIC, int Id) {
        this.Name =  Name;
        this.Password=Password;
        this.Mobile=Mobile;
        this.Adress=Adress;
        this.Area=Area;
        this.CNIC=CNIC;
        this.Id=Id;

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
