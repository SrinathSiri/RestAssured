package Day2;

public class PojoData {
    private String name;
    private String location;
    private String phone;
    private String[] courses;

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getPhone() {
        return phone;
    }

    public String[] getCourses() {
        return courses;
    }
}
