package api.qa.stepdefinitions;

import api.qa.endpints.EP_Trash;
import io.cucumber.java.en.Then;

public class SD_Trash {
    EP_Trash epTrash = new EP_Trash();

    @Then("User validates name {string}, type {string}, entityId {string}, createdAt {string}, restorer {string}, courseId {string}")
    public void user_validates_name_type_entity_id_created_at_restorer_course_id(String expectedName, String expectedType, String expectedItemID, String expectedDate, String expectedRestorer, String expectedCourseId) {
        epTrash.validateDeletedItem(expectedName, expectedType, expectedItemID, expectedDate, expectedRestorer, expectedCourseId);
    }

    @Then("User validates message {string} recover and check it again")
    public void user_validates_message_recover_and_check_it_again(String expectedMessage) {
        epTrash.validateRecoverFromTrash(expectedMessage);
    }

    @Then("User validates message {string} delete and check it again")
    public void user_validates_message_delete_and_check_it_again(String expectedMessage) {
        epTrash.validateDeleteFromTrash(expectedMessage);
    }

}
