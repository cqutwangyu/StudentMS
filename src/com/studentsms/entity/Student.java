package com.studentsms.entity;

/**
 * @author WangYu
 */
public class Student {

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSdatebirth() {
        return sdatebirth;
    }

    public void setSdatebirth(String sdatebirth) {
        this.sdatebirth = sdatebirth;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public String getSnativeplace() {
        return snativeplace;
    }

    public void setSnativeplace(String snativeplace) {
        this.snativeplace = snativeplace;
    }

    public String getShouseaddress() {
        return shouseaddress;
    }

    public void setShouseaddress(String shouseaddress) {
        this.shouseaddress = shouseaddress;
    }

    public String getSnation() {
        return snation;
    }

    public void setSnation(String snation) {
        this.snation = snation;
    }

    public Student(String sno, String sname, String sdatebirth, String ssex, String snativeplace, String shouseaddress, String snation) {
        this.sno = sno;
        this.sname = sname;
        this.sdatebirth = sdatebirth;
        this.ssex = ssex;
        this.snativeplace = snativeplace;
        this.shouseaddress = shouseaddress;
        this.snation = snation;
    }

    public Student() {
    }

    private String sno;
    private String sname;
    private String sdatebirth;
    private String ssex;
    private String snativeplace;
    private String shouseaddress;
    private String snation;
}