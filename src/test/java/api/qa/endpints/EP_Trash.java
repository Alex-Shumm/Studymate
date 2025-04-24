package api.qa.endpints;

import api.qa.pojos.PJ_Trash;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import utils.ConfigReader;

public class EP_Trash {
    final String json = "application/json";
    final String contentType = "Content-Type";

    public String getTrashID() {
        RestAssured.baseURI = ConfigReader.readProperty("base_url");
        RestAssured.basePath = ConfigReader.readProperty("get_trash");

        Response response = RestAssured.given().header(contentType, json).accept(ContentType.JSON)
                .header("Origin", ConfigReader.readProperty("origin"))
                .header("Authorization", ConfigReader.readProperty("token"))
                .when().get().then().log().body().statusCode(200).extract().response();
        PJ_Trash deserializedResponse = response.as(PJ_Trash.class);
        return deserializedResponse.getObjects().get(0).getId();
    }

    public void validateDeletedItem(String expectedName, String expectedType, String expectedItemID, String expectedDate, String expectedRestorer, String courseId){
        RestAssured.baseURI = ConfigReader.readProperty("base_url");
        RestAssured.basePath = ConfigReader.readProperty("get_trash");
        Response response = RestAssured.given().header(contentType, json).accept(ContentType.JSON)
                .header("Origin", ConfigReader.readProperty("origin"))
                .header("Authorization", ConfigReader.readProperty("token"))
                .when().get().then().log().body().statusCode(200).extract().response();

        PJ_Trash deserializedResponse = response.as(PJ_Trash.class);
        Assert.assertEquals(expectedName, deserializedResponse.getObjects().get(0).getName());
        Assert.assertEquals(expectedType, deserializedResponse.getObjects().get(0).getType());
        Assert.assertEquals(expectedItemID, deserializedResponse.getObjects().get(0).getEntityId());
        Assert.assertEquals(expectedDate, deserializedResponse.getObjects().get(0).getCreatedAt());
        Assert.assertEquals(expectedRestorer, deserializedResponse.getObjects().get(0).getRestorer());
        Assert.assertEquals(courseId, deserializedResponse.getObjects().get(0).getCourseId());
    }

    public void validateRecoverFromTrash(String expectedMessage){
        String id = getTrashID();
        RestAssured.baseURI = ConfigReader.readProperty("base_url");
        RestAssured.basePath = ConfigReader.readProperty("recover_trash") + id + "/restore";

        Response response = RestAssured.given().header(contentType, json).accept(ContentType.JSON)
                .header("Origin", ConfigReader.readProperty("origin"))
                .header("Authorization", ConfigReader.readProperty("token"))
                .when().put().then().log().body().statusCode(200).extract().response();

        PJ_Trash deserializedResponse = response.as(PJ_Trash.class);
        Assert.assertEquals(expectedMessage, deserializedResponse.getMessage());

        String idCheck = getTrashID();
        Assert.assertNotEquals(id, idCheck);
    }

    public void validateDeleteFromTrash(String expectedMessage){
        String id = getTrashID();
        RestAssured.baseURI = ConfigReader.readProperty("base_url");
        RestAssured.basePath = ConfigReader.readProperty("recover_trash") + id;

        Response response = RestAssured.given().header(contentType, json).accept(ContentType.JSON)
                .header("Origin", ConfigReader.readProperty("origin"))
                .header("Authorization", ConfigReader.readProperty("token"))
                .when().delete().then().log().body().statusCode(200).extract().response();

        PJ_Trash deserializedResponse = response.as(PJ_Trash.class);
        Assert.assertEquals(expectedMessage, deserializedResponse.getMessage());

        String idCheck = getTrashID();
        Assert.assertNotEquals(id, idCheck);
    }
}
