package apiCollection;

import general.EnvGlobals;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

import java.sql.SQLException;

import static config.ConfigProperties.*;
import static io.restassured.RestAssured.given;


public class GetResponse {

    public static String getResponseInString() {



        EnvGlobals.response =
                given()
                        .contentType(contentType)
                        .auth().basic(userNameForAuthentication, userPasswordForAuthentication)
                        .when()
                        .get(baseUrl+"security/authenticate");
        Assert.assertEquals( EnvGlobals.response.getStatusCode(),200);
        String jsonAsString=EnvGlobals.response.asString();



        return jsonAsString;

    }

    public static JsonPath getResponseInJson()
    {
        EnvGlobals.response =
                given()
                        .contentType(contentType)
                        .auth().basic(userNameForAuthentication, userPasswordForAuthentication)
                        .when()
                        .get(baseUrl+"security/authenticate");
        Assert.assertEquals( EnvGlobals.response.getStatusCode(),200);
        String jsonAsString=EnvGlobals.response.asString();
        JsonPath jsonPath=new JsonPath(jsonAsString);
        return jsonPath;

    }
    public static Response getBodyValue()
    {
        EnvGlobals.response =
                given()
                        .contentType(contentType)
                        .auth().basic(userNameForAuthentication, userPasswordForAuthentication)
                        .when()
                        .get(baseUrl+"security/authenticate")
                                .getBody().path("team.locations[0].display");
       return EnvGlobals.response;

    }
    public static Response getResponseInPostCall() throws SQLException {
        EnvGlobals.response=
                given()
                        .contentType(contentType)
                        .auth().basic(userNameForAuthentication, userPasswordForAuthentication)
                        .body(Payloads.getPayload())
            .when()
                        .post(baseUrl+"security/authenticate").then().extract().response();
        return EnvGlobals.response;
    }


}
