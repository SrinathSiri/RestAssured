package Day6;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

public class StudentDeSerial {
    @Test
    public void studentDeserial() throws JsonProcessingException {
        String jsondata = "{\n" +
                "  \"stname\" : \"SriAnagha\",\n" +
                "  \"stlocation\" : \"Hyderabad\",\n" +
                "  \"stcourse\" : [ \"English\", \"Maths\" ],\n" +
                "  \"stage\" : 4.0\n" +
                "}";

        // converting json object to java object

        ObjectMapper objmap = new ObjectMapper();
        PojoClass pojoobj = objmap.readValue(jsondata,PojoClass.class);
        System.out.println(pojoobj.getStname());
        System.out.println(pojoobj.getStage());
        System.out.println(pojoobj.getStlocation());
        System.out.println(pojoobj.getStcourse()[0]);
        System.out.println(pojoobj.getStcourse()[1]);

    }
}
