package api.qa.endpints;

import api.qa.pojos.PJ_Teacher;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import utils.APIJsonData;
import utils.ConfigReader;

public class EP_Teachers {
    final String json = "application/json";
    final String contentType = "Content-Type";

    public void validateAddNewTeacher(String name, String lastName, String phone,
                                      String email, String specialization, String courses) {

        RestAssured.baseURI = ConfigReader.readProperty("base_url");
        RestAssured.basePath = ConfigReader.readProperty("add_teacher");

        Response response = RestAssured.given().header("Content-Type", json)
                .accept(ContentType.JSON)
                .header("Origin", ConfigReader.readProperty("origin")).
                header("Authorization", ConfigReader.readProperty("token"))
                .body(APIJsonData.addTeacher(name, lastName, phone, email, specialization, courses))
                .when().post().then().log().body().statusCode(200).extract().response();

        PJ_Teacher deserializedResponse = response.as(PJ_Teacher.class);

        Assert.assertEquals("Instructor successfully saved", deserializedResponse.getMessage());

    }

    public String getTeacherID() {
        RestAssured.baseURI = ConfigReader.readProperty("base_url");
        RestAssured.basePath = ConfigReader.readProperty("get_all_teachers_info");

        Response response = RestAssured.given().header(contentType, json).accept(ContentType.JSON)
                .header("Origin", ConfigReader.readProperty("origin"))
                .header("Authorization", ConfigReader.readProperty("token"))
                .when().get().then().log().body().statusCode(200).extract().response();
        PJ_Teacher deserializedResponse = response.as(PJ_Teacher.class);
        return deserializedResponse.getObjects().get(0).getId();
    }

    public void validateGetTeacherInformation(String name, String lastName, String phone,
                                              String email, String specialization) {
        String id = getTeacherID();
        RestAssured.baseURI = ConfigReader.readProperty("base_url");
        RestAssured.basePath = ConfigReader.readProperty("get_teacher_information") + id;

        Response response = RestAssured.given()
                .accept(ContentType.JSON)
                .header("Origin", ConfigReader.readProperty("origin"))
                .header("Authorization", ConfigReader.readProperty("token"))
                .when().get().then().log().body().statusCode(200).extract().response();

        PJ_Teacher deserializedResponse = response.as(PJ_Teacher.class);
        Assert.assertEquals(name, deserializedResponse.getName());
        Assert.assertEquals(lastName, deserializedResponse.getLastName());
        Assert.assertEquals(phone, deserializedResponse.getPhoneNumber());
        Assert.assertEquals(email, deserializedResponse.getEmail());
        Assert.assertEquals(specialization, deserializedResponse.getSpecialization());

    }

    public void validateTeacherUpdateInformation(String name, String lastName, String phone,
                                                 String email, String specialization, String courses, String expectedMessage) {
        String id = getTeacherID();
        RestAssured.baseURI = ConfigReader.readProperty("base_url");
        RestAssured.basePath = ConfigReader.readProperty("update_teacher_info") + id;

        Response response = RestAssured.given().header(contentType, json).accept(ContentType.JSON)
                .header("Origin", ConfigReader.readProperty("origin"))
                .header("Authorization", ConfigReader.readProperty("token"))
                .body(APIJsonData.updateTeacher(name, lastName, phone,
                        email, specialization, courses))
                .when().put().then().log().body().statusCode(200).extract().response();

        PJ_Teacher deserializedResponse = response.as(PJ_Teacher.class);

        Assert.assertEquals(expectedMessage, deserializedResponse.getMessage());

    }

    public void validateDeleteTeacherInformation(String expectedMessage) {
        String id = getTeacherID();
        RestAssured.baseURI = ConfigReader.readProperty("base_url");
        RestAssured.basePath = ConfigReader.readProperty("delete_teacher") + id;

        Response response = RestAssured.given()
                .accept(ContentType.JSON)
                .header("Origin", ConfigReader.readProperty("origin"))
                .header("Authorization", ConfigReader.readProperty("token"))
                .when().delete().then().log().body().statusCode(200).extract().response();

        PJ_Teacher deserializedResponse = response.as(PJ_Teacher.class);

        Assert.assertEquals(expectedMessage, deserializedResponse.getMessage());
        String doubleCheck = getTeacherID();
        Assert.assertNotEquals(id, doubleCheck);
    }

}
