package com.example.wastemanagementsystem;

public class UserCompalint {
    private String title;
    private String complaint;
    private String usercomplaint;
    private int Id;

    public UserCompalint(String title, String complaint, String usercomplaint, int id) {
        this.title = title;
        this.complaint = complaint;
        this.usercomplaint = usercomplaint;
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getComplaint() {
        return complaint;
    }

    public String getUsercomplaint() {
        return usercomplaint;
    }

    public int getId() {
        return Id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public void setUsercomplaint(String usercomplaint) {
        this.usercomplaint = usercomplaint;
    }

    public void setId(int id) {
        Id = id;
    }

    @Override
    public String toString() {
        return "UserCompalint{" +
                "title='" + title + '\'' +
                ", complaint='" + complaint + '\'' +
                ", usercomplaint='" + usercomplaint + '\'' +
                ", Id=" + Id +
                '}';
    }
}
