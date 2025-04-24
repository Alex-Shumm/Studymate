package api.qa.endpints;

import api.qa.pojos.PJ_Login;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import utils.APIJsonData;
import utils.ConfigReader;

public class EP_Login {
    final String json = "application/json";
    final String contentType = "Content-Type";
    final String accept = "Accept";
    final String authorization = "Authorization";

    public void validateHappyLoginData(String expectedEmail, String expectedAuthority, String expectedWorkspaceId, String expectedLanguage){
        RestAssured.baseURI = ConfigReader.readProperty("base_url");
        RestAssured.basePath = ConfigReader.readProperty("login");

        Response response =  RestAssured.given().header(contentType, json).accept(ContentType.JSON)
                .header("Origin", ConfigReader.readProperty("origin"))
                .body(APIJsonData.login(ConfigReader.readProperty("valid_username"), ConfigReader.readProperty("valid_password")))
                .when().post().then().log().body().statusCode(200).extract().response();

        PJ_Login deserializedResponse = response.as(PJ_Login.class);
        Assert.assertEquals(expectedEmail, deserializedResponse.getEmail());
        Assert.assertEquals(expectedAuthority, deserializedResponse.getAuthority());
        Assert.assertEquals(expectedWorkspaceId, deserializedResponse.getWorkspaceId());
        Assert.assertEquals(expectedLanguage, deserializedResponse.getLanguage());
    }

    public void validateNegativeLoginData(String email, String password, String expectedStatus, String expectedMessage, String statusCode){
        RestAssured.baseURI = ConfigReader.readProperty("base_url");
        RestAssured.basePath = ConfigReader.readProperty("login");

        Response response =  RestAssured.given().header(contentType, json).accept(ContentType.JSON)
                .header("Origin", ConfigReader.readProperty("origin"))
                .body(APIJsonData.login(email, password))
                .when().post().then().log().body().statusCode(Integer.parseInt(statusCode)).extract().response();

        PJ_Login deserializedResponse = response.as(PJ_Login.class);
        Assert.assertEquals(expectedStatus, deserializedResponse.getStatus());
        Assert.assertEquals(expectedMessage, deserializedResponse.getMessage());
    }

    public void validateHappyResetPassword(String expectedMessage){
        RestAssured.baseURI = ConfigReader.readProperty("base_url");
        RestAssured.basePath = ConfigReader.readProperty("reset_password");

        Response response =  RestAssured.given().header(contentType, json).accept(ContentType.JSON)
                .header("Origin", ConfigReader.readProperty("origin"))
                .header("Authorization", ConfigReader.readProperty("token"))
                .body(APIJsonData.resetPassword(ConfigReader.readProperty("username")))
                .when().post().then().log().body().statusCode(200).extract().response();

        PJ_Login deserializedResponse = response.as(PJ_Login.class);
        Assert.assertEquals(expectedMessage, deserializedResponse.getMessage());
    }
}
