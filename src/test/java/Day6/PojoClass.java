package Day6;

public class PojoClass {

    private String stname;
    private String stlocation;
    private String[] stcourse;
    private double stage;

    public void setStName(String stname){
        this.stname = stname;
    }

    public void setStLocation(String stlocation){
        this.stlocation=stlocation;
    }

    public void setStAge(double stage){
        this.stage=stage;
    }

    public void setStCourse(String[] stcourse){
        this.stcourse=stcourse;
    }

    public String getStname() {
        return stname;
    }

    public double getStage(){
        return stage;
    }

    public String getStlocation() {
        return stlocation;
    }

    public String[] getStcourse() {
        return stcourse;
    }
}
