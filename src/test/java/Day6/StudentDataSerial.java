package Day6;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

public class StudentDataSerial {

    @Test
    public void studentData() throws JsonProcessingException {

        PojoClass pobj = new PojoClass();
        pobj.setStName("SriAnagha");
        pobj.setStAge(4);
        pobj.setStLocation("Hyderabad");
        String[] courses = {"English","Maths"};
        pobj.setStCourse(courses);

        System.out.println("Java Object data is : "+pobj);

        // converting java object to json object

        ObjectMapper om = new ObjectMapper();
        String jsonobject = om.writerWithDefaultPrettyPrinter().writeValueAsString(pobj);
        System.out.println("JSON object data is : "+jsonobject);
    }
}
