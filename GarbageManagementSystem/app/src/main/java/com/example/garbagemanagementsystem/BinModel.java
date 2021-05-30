package com.example.garbagemanagementsystem;

public class BinModel {
    private String BinArea;

    private String Locality;
    private String LandMak;
    private String City;
    private String DriverEmail;
    private String BestRout;
    private String Load;
    public String CyclicPeriod;
    int id;
    public  BinModel(){

    }
    public BinModel(String BinArea, String Locality, String LandMak,  String City,String DriverEmail, String BestRout,String Load,String cyclicPeriod,int Id) {
        this.BinArea = BinArea;
        this.Locality= Locality;
        this.LandMak = LandMak;
        this.City = City;
        this.DriverEmail=DriverEmail;
        this.BestRout=BestRout;
        this.Load=Load;
        this.CyclicPeriod=cyclicPeriod;
        this.Id=Id;

    }
    public void setBinArea(String binArea) {
        BinArea = binArea;
    }

    public void setLocality(String locality) {
        Locality = locality;
    }

    public void setLandMak(String landMak) {
        LandMak = landMak;
    }

    public void setCity(String city) {
        City = city;
    }

    public void setDriverEmail(String driverEmail) {
        DriverEmail = driverEmail;
    }

    public void setBestRout(String bestRout) {
        BestRout = bestRout;
    }

    public void setLoad(String load) {
        Load = load;
    }

    public void setCyclicPeriod(String cyclicPeriod) {
        CyclicPeriod = cyclicPeriod;
    }

    public void setId(int id) {
        Id = id;
    }

    private int Id;

    public String getBinArea() {
        return BinArea;
    }

    public String getLocality() {
        return Locality;
    }

    public String getLandMak() {
        return LandMak;
    }

    public String getCity() {
        return City;
    }

    public String getDriverEmail() {
        return DriverEmail;
    }

    public String getBestRout() {
        return BestRout;
    }

    public String getLoad() {
        return Load;
    }

    public String getCyclicPeriod() {
        return CyclicPeriod;
    }

    public int getId() {
        return Id;
    }
}
