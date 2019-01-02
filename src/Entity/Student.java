package Entity;

public class Student {

    private String sno;
    private String sname;
    private int sage;
    private String ssex;

    public Student(String sno, String sname, int sage, String ssex) {
        this.sno = sno;
        this.sname = sname;
        this.sage = sage;
        this.ssex = ssex;
    }
    public Student() {
    }

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

    public int getSage() {
        return sage;
    }

    public void setSage(int sage) {
        this.sage = sage;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }
}
