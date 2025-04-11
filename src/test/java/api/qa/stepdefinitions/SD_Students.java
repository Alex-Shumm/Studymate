package api.qa.stepdefinitions;

import api.qa.endpints.EP_Students;
import io.cucumber.java.en.Then;

public class SD_Students {
    EP_Students epStudents = new EP_Students();

    @Then("User validates {string},{string}, {string},{string}, {string} and {string} from end-point and validates {string} message")
    public void user_validates_and_from_end_point_and_validates_message(String name, String lastName, String phone, String email, String groupId, String studyFormat, String expectedMessage) {
        epStudents.validateCreateStudentsData(name, lastName, phone, email, groupId, studyFormat, expectedMessage);

    }

    @Then("User validates {string}, {string},{string}, {string},{string} from end-point Get")
    public void user_validates_from_end_point_get(String name, String lastName, String studyFormat, String phoneNumber, String email) {
        epStudents.getStudentID();
        epStudents.validateGetStudentInformation(name, lastName, studyFormat, phoneNumber, email);
    }

    @Then("User validates {string} from end-point Put")
    public void user_validates_from_end_point_put(String expectedMessage) {
        epStudents.validateBlockStudentInformation(expectedMessage);
    }

    @Then("User validates {string} Delete")
    public void user_validates_delete(String expectedMessage) {
        epStudents.validateDeleteStudentInformation(expectedMessage);
    }

}
