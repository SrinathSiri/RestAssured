package Questions;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilder {


    //  https://projects-api3.stage.shutterfly.com/projects/projectid

    public static RequestSpecification reqSpec(){

        RequestSpecBuilder reqbuilder = new RequestSpecBuilder();
        reqbuilder.setBaseUri("https://projects-api3.stage.shutterfly.com");
        reqbuilder.setContentType("application/json");
        RequestSpecification reqspec = reqbuilder.build();

        return reqspec;
    }

    public static ResponseSpecification resSpec(){
        ResponseSpecBuilder resbuilder = new ResponseSpecBuilder();
        resbuilder.expectStatusCode(200);
        resbuilder.expectContentType("application/json");
        ResponseSpecification resspec = resbuilder.build();

        return resspec;
    }
}
