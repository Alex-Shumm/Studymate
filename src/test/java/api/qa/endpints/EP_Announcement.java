package api.qa.endpints;

import api.qa.pojos.PJ_Announcement;
import api.qa.pojos.PJ_Login;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import utils.APIJsonData;
import utils.ConfigReader;

public class EP_Announcement {
    final String json = "application/json";
    final String contentType = "Content-Type";

    public String getAnnouncementID() {
        RestAssured.baseURI = ConfigReader.readProperty("base_url");
        RestAssured.basePath = ConfigReader.readProperty("get_all_announcements");

        Response response = RestAssured.given().header(contentType, json).accept(ContentType.JSON)
                .header("Origin", ConfigReader.readProperty("origin"))
                .header("Authorization", ConfigReader.readProperty("token"))
                .when().get().then().log().body().statusCode(200).extract().response();
        PJ_Announcement deserializedResponse = response.as(PJ_Announcement.class);
        return deserializedResponse.getObjects().get(0).getId();
    }

    public void validateHappyCreateAnnouncement(String text, String groupID, String expectedMessage) {
        RestAssured.baseURI = ConfigReader.readProperty("base_url");
        RestAssured.basePath = ConfigReader.readProperty("create_announcement");

        Response response = RestAssured.given().header(contentType, json).accept(ContentType.JSON)
                .header("Origin", ConfigReader.readProperty("origin"))
                .header("Authorization", ConfigReader.readProperty("token"))
                .body(APIJsonData.createAnnouncement(text, groupID))
                .when().post().then().log().body().statusCode(200).extract().response();

        PJ_Announcement deserializedResponse = response.as(PJ_Announcement.class);
        Assert.assertEquals(expectedMessage, deserializedResponse.getMessage());
    }

    public void validateGetAllAnnouncements(String text, String createdBy, String type, String groupName, String groupID, String date) {
        RestAssured.baseURI = ConfigReader.readProperty("base_url");
        RestAssured.basePath = ConfigReader.readProperty("get_all_announcements");

        Response response = RestAssured.given().header(contentType, json).accept(ContentType.JSON)
                .header("Origin", ConfigReader.readProperty("origin"))
                .header("Authorization", ConfigReader.readProperty("token"))
                .when().get().then().log().body().statusCode(200).extract().response();

        PJ_Announcement deserializedResponse = response.as(PJ_Announcement.class);
        Assert.assertEquals(text, deserializedResponse.getObjects().get(0).getText());
        Assert.assertEquals(createdBy, deserializedResponse.getObjects().get(0).getCreatedBy());
        Assert.assertEquals(type, deserializedResponse.getObjects().get(0).getAnnouncementType());
        Assert.assertEquals(groupName, deserializedResponse.getObjects().get(0).getGroupName());
        Assert.assertEquals(groupID, deserializedResponse.getObjects().get(0).getGroupId());
        Assert.assertEquals(date, deserializedResponse.getObjects().get(0).getDate());
    }

    public void validateCreatedAnnouncement(String expectedText, String expectedCreatedBy, String expectedType, String expectedGroupName, String expectedGroupId, String expectedActive, String expectedDate, String expectedSpaceID) {
        String id = getAnnouncementID();
        RestAssured.baseURI = ConfigReader.readProperty("base_url");
        RestAssured.basePath = ConfigReader.readProperty("get_announcement") + id;

        Response response = RestAssured.given().header(contentType, json).accept(ContentType.JSON)
                .header("Origin", ConfigReader.readProperty("origin"))
                .header("Authorization", ConfigReader.readProperty("token"))
                .when().get().then().log().body().statusCode(200).extract().response();

        PJ_Announcement deserializedResponse = response.as(PJ_Announcement.class);
        Assert.assertEquals(id, deserializedResponse.getId());
        Assert.assertEquals(expectedText, deserializedResponse.getText());
        Assert.assertEquals(expectedCreatedBy, deserializedResponse.getCreatedBy());
        Assert.assertEquals(expectedType, deserializedResponse.getAnnouncementType());
        Assert.assertEquals(expectedGroupName, deserializedResponse.getGroupName());
        Assert.assertEquals(expectedGroupId, deserializedResponse.getGroupId());
        Assert.assertEquals(expectedActive, deserializedResponse.getActive());
        Assert.assertEquals(expectedDate, deserializedResponse.getDate());
        Assert.assertEquals(expectedSpaceID, deserializedResponse.getWorkspaceId());
    }

    public void validateChangingVisibility(String status, String message) {
        String id = getAnnouncementID();
        RestAssured.baseURI = ConfigReader.readProperty("base_url");
        RestAssured.basePath = ConfigReader.readProperty("get_announcement") + id + "/activation";

        Response response = RestAssured.given().header(contentType, json).accept(ContentType.JSON)
                .header("Origin", ConfigReader.readProperty("origin"))
                .header("Authorization", ConfigReader.readProperty("token"))
                .queryParam("active", status)
                .when().put().then().log().body().statusCode(200).extract().response();

        PJ_Announcement deserializedResponse = response.as(PJ_Announcement.class);
        Assert.assertEquals(message, deserializedResponse.getMessage());
    }

    public void validateHappyUpdateAnnouncement(String updateText, String groupID, String expectedMessage) {
        String id = getAnnouncementID();
        RestAssured.baseURI = ConfigReader.readProperty("base_url");
        RestAssured.basePath = ConfigReader.readProperty("update_announcement") + id;

        Response response = RestAssured.given().header(contentType, json).accept(ContentType.JSON)
                .header("Origin", ConfigReader.readProperty("origin"))
                .header("Authorization", ConfigReader.readProperty("token"))
                .body(APIJsonData.createAnnouncement(updateText, groupID))
                .when().put().then().log().body().statusCode(200).extract().response();

        PJ_Announcement deserializedResponse = response.as(PJ_Announcement.class);
        Assert.assertEquals(expectedMessage, deserializedResponse.getMessage());
    }

    public void validateDeleteAnnouncement(String deletedMessage, String status, String errorMessage) {
        String id = getAnnouncementID();
        RestAssured.baseURI = ConfigReader.readProperty("base_url");
        RestAssured.basePath = ConfigReader.readProperty("delete_announcement") + id;

        Response response = RestAssured.given().header(contentType, json).accept(ContentType.JSON)
                .header("Origin", ConfigReader.readProperty("origin"))
                .header("Authorization", ConfigReader.readProperty("token"))
                .when().delete().then().log().body().statusCode(200).extract().response();

        PJ_Announcement deserializedResponse = response.as(PJ_Announcement.class);
        Assert.assertEquals(deletedMessage, deserializedResponse.getMessage());

        response = RestAssured.given().header(contentType, json).accept(ContentType.JSON)
                .header("Origin", ConfigReader.readProperty("origin"))
                .header("Authorization", ConfigReader.readProperty("token"))
                .when().delete().then().log().body().statusCode(404).extract().response();

        deserializedResponse = response.as(PJ_Announcement.class);
        Assert.assertEquals(status, deserializedResponse.getStatus());
        Assert.assertEquals(errorMessage, deserializedResponse.getMessage());
    }
}
