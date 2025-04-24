package api.qa.stepdefinitions;

import api.qa.endpints.EP_Teachers;
import io.cucumber.java.en.Then;

public class SD_Teachers {

    EP_Teachers epTeachers = new EP_Teachers();

    @Then("User validates {string}, {string},{string}, {string}, {string} and {string} from end-point")
    public void user_validates_and_from_end_point(String firstName, String lastName, String phoneNumber,
                                                  String email, String specialization, String courses) {
        epTeachers.validateAddNewTeacher(firstName, lastName, phoneNumber, email, specialization, courses);
    }

    @Then("User validates {string}, {string},{string}, {string}, {string} from end-point get")
    public void user_validates_from_end_point_get(String name, String lastName, String phoneNumber, String email, String specialization) {
        epTeachers.validateGetTeacherInformation(name, lastName, phoneNumber, email, specialization);
    }


    @Then("User updates {string},{string},{string}, {string}, {string}, {string} and validates {string} from end-point put")
    public void user_updates_and_validates_from_end_point_put(String firstName, String lastName, String phoneNumber,
                                                              String email, String specialization, String courses, String expectedMessage) {
        epTeachers.validateTeacherUpdateInformation(firstName, lastName, phoneNumber, email, specialization, courses, expectedMessage);
    }


    @Then("User validates {string} from end-point Delete")
    public void user_validates_from_end_point_delete(String expectedMessage) {
        epTeachers.validateDeleteTeacherInformation(expectedMessage);
    }

}
