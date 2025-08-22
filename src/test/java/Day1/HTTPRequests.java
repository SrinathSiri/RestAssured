package Day1;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class HTTPRequests {

    int id;

    @Test(priority = 1)
    public void getUsers(){
        given()
                .when()
                    .get("https://reqres.in/api/users?page=2")
                .then()
                    .statusCode(200)
                    .body("page",equalTo(2))
                    //.body("email",equalTo("michael.lawson@reqres.in"))
                    .log().all();
    }

    @Test(priority = 2)
    public void createUser(){

        HashMap obj = new HashMap();
        obj.put("name","pavan");
        obj.put("job","Architect");

        id=given()
                .header("x-api-key","reqres-free-v1")
                .contentType("application/json")
                .body(obj)
                    .when()
                        .post("https://reqres.in/api/users")
                        .jsonPath().getInt("id");
    }

    @Test(priority =3,dependsOnMethods = {"createUser"})
    public void updateUser(){

        HashMap obj1 = new HashMap();
        obj1.put("name","PAVAN SDET");
        obj1.put("job","SDET Automation Architect");

        given()
                .header("x-api-key","reqres-free-v1")
                .contentType("application/json")
                .body(obj1)
                .when()
                    .put("https://reqres.in/api/users/"+id)
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test(priority=4)
    public void deleteUser(){
        given()
                .header("x-api-key","reqres-free-v1")
                .when()
                .delete("https://reqres.in/api/users/"+id)
                .then()
                .statusCode(204)
                .log().all();
    }
}