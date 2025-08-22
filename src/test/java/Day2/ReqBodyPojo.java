package Day2;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class ReqBodyPojo {

    @Test
    public void reqPayloadPojo(){
        PojoData obj = new PojoData();
        obj.setName("RajaMouli");
        obj.setLocation("AndhraPradesh");
        obj.setPhone("8765676567");
        String[] coursesarray = {"Docker","Kubernetis"};
        obj.setCourses(coursesarray);

        given()
                .contentType("application/json")
                .body(obj)
                .when()
                .post("http://localhost:3000/students")
                .then()
                .statusCode(201)
                .body("courses[0]",equalTo("Docker"))
                .log().all();
    }

}
