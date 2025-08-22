package Day1;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class HTTPRequests1 {

    // CRUD operations

    int id;

    @Test(priority = 1)
    public void createUser(){

        HashMap objj1 = new HashMap();
        objj1.put("name","Philips");
        objj1.put("job","Teacher");

       id= given()
                .header("x-api-key","reqres-free-v1")
                .contentType("application/json")
                .body(objj1)
                .when()
                .post("https://reqres.in/api/users")
                .jsonPath().getInt("id");
    }

    @Test(priority = 2, dependsOnMethods = {"createUser"})
    public void getUser(){
        given()
                .header("x-api-key","reqres-free-v1")
                .when()
                .get("https://reqres.in/api/users/"+id)
                .then()
                //.statusCode(200)
                //.body("name",equalTo("Philips"))
                .log().all();
    }

    @Test(priority=3,dependsOnMethods = {"createUser"})
    public void updateUser(){
        HashMap objj2 = new HashMap();
        objj2.put("name","Charles");
        objj2.put("job","Builder");

        given()
                .header("x-api-key","reqres-free-v1")
                .contentType("application/json")
                .body(objj2)
                .when()
                .put("https://reqres.in/api/users/"+id)
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test(priority = 4,dependsOnMethods = {"updateUser"})
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
