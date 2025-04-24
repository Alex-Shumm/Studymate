package api.qa.endpints;

import api.qa.pojos.PJ_Students;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import utils.APIJsonData;
import utils.ConfigReader;

public class EP_Students {
    final String json = "application/json";
    final String contentType = "Content-Type";


    public void validateCreateStudentsData(String name, String lastName, String phoneNumber, String email, String groupId, String studyFormat, String expectedMessage) {

        RestAssured.baseURI = ConfigReader.readProperty("base_url");
        RestAssured.basePath = ConfigReader.readProperty("create_student");

        Response response = RestAssured.given().header("Content-Type", json)
                .accept(ContentType.JSON)
                .header("Origin", ConfigReader.readProperty("origin")).
                header("Authorization", ConfigReader.readProperty("token"))
                .body(APIJsonData.createStudent(name, lastName, phoneNumber, email, groupId, studyFormat))
                .when().post().then().log().body().statusCode(200).extract().response();

        PJ_Students deserializedResponse = response.as(PJ_Students.class);

        Assert.assertEquals(expectedMessage, deserializedResponse.getMessage());
    }

    public String getStudentID() {
        RestAssured.baseURI = ConfigReader.readProperty("base_url");
        RestAssured.basePath = ConfigReader.readProperty("get_all_students_info");

        Response response = RestAssured.given().header(contentType, json).accept(ContentType.JSON)
                .header("Origin", ConfigReader.readProperty("origin"))
                .header("Authorization", ConfigReader.readProperty("token"))
                .when().get().then().log().body().statusCode(200).extract().response();
        PJ_Students deserializedResponse = response.as(PJ_Students.class);
        return deserializedResponse.getObjects().get(0).getStudentId();
    }

    public void validateGetStudentInformation(String name, String lastName, String studyFormat, String phoneNumber, String email) {
        String id = getStudentID();
        RestAssured.baseURI = ConfigReader.readProperty("base_url");
        RestAssured.basePath = ConfigReader.readProperty("get_student_information") + id;

        Response response = RestAssured.given()
                .accept(ContentType.JSON)
                .header("Origin", ConfigReader.readProperty("origin"))
                .header("Authorization", ConfigReader.readProperty("token"))
                .when().get().then().log().body().statusCode(200).extract().response();

        PJ_Students deserializedResponse = response.as(PJ_Students.class);


        Assert.assertEquals(name, deserializedResponse.getName());
        Assert.assertEquals(lastName, deserializedResponse.getLastName());
        Assert.assertEquals(email, deserializedResponse.getEmail());
        Assert.assertEquals(phoneNumber, deserializedResponse.getPhoneNumber());
        Assert.assertEquals(studyFormat, deserializedResponse.getStudyFormat());

    }


    public void validateBlockStudentInformation(String expectedMessage) {
        String id = getStudentID();
        RestAssured.baseURI = ConfigReader.readProperty("base_url");
        RestAssured.basePath = ConfigReader.readProperty("block_student") + id + "/block";

        Response response = RestAssured.given()
                .accept(ContentType.JSON)
                .header("Origin", ConfigReader.readProperty("origin"))
                .header("Authorization", ConfigReader.readProperty("token"))
                .when().put().then().log().body().statusCode(200).extract().response();

        PJ_Students deserializedResponse = response.as(PJ_Students.class);

        Assert.assertEquals(expectedMessage, deserializedResponse.getMessage());

    }

    public void validateDeleteStudentInformation(String expectedMessage) {
        String id = getStudentID();
        RestAssured.baseURI = ConfigReader.readProperty("base_url");
        RestAssured.basePath = ConfigReader.readProperty("delete_student") + id;

        Response response = RestAssured.given()
                .accept(ContentType.JSON)
                .header("Origin", ConfigReader.readProperty("origin"))
                .header("Authorization", ConfigReader.readProperty("token"))
                .when().delete().then().log().body().statusCode(200).extract().response();

        PJ_Students deserializedResponse = response.as(PJ_Students.class);

        Assert.assertEquals(expectedMessage, deserializedResponse.getMessage());

    }

}
