package Interview;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.greaterThan;

public class SpecBuilder {

    public static RequestSpecification reqSpec() {
        return given()
                .baseUri("https://reqres.in")
                .contentType("application/json");
    }

    public static ResponseSpecification resSpec(int statuscode){

        return new ResponseSpecBuilder()
                .expectStatusCode(statuscode)
                .expectContentType("application/json")
                .expectBody("data.id",greaterThan(0))
                .expectBody("data.email",equalToIgnoringCase("janet.weaver@reqres.in"))
                .build();
    }
}
