package api.qa.stepdefinitions;

import api.qa.endpints.EP_Announcement;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SD_Announcement {
    EP_Announcement epAnnouncement = new EP_Announcement();

    @Then("User provides text {string}, groupId {string} and validates message {string} announcement")
    public void user_provides_text_group_id_and_validates_message_announcement(String text, String groupID, String message) {
        epAnnouncement.validateHappyCreateAnnouncement(text, groupID, message);
    }

    @Then("User validates text {string}, createdBy {string}, type {string}, groupName {string}, groupID {string}, date {string}.")
    public void user_validates_text_created_by_type_group_name_group_id_date(String text, String createdBy, String type, String groupName, String groupID, String date) {
        epAnnouncement.validateGetAllAnnouncements(text, createdBy, type, groupName, groupID, date);
    }

    @Then("User validates text {string}, createdBy {string}, type {string}, groupName {string}, groupID {string}, active {string}, date {string}, workspaceID {string}")
    public void user_validates_text_created_by_type_group_name_group_id_active_date_workspace_id( String expectedText, String expectedCreatedBy, String expectedType, String expectedGroupName, String expectedGroupId, String expectedActive, String expectedDate, String expectedSpaceID) {
        epAnnouncement.validateCreatedAnnouncement(expectedText, expectedCreatedBy, expectedType,expectedGroupName,expectedGroupId,expectedActive,expectedDate,expectedSpaceID);
    }

    @Then("User provides active status {string} and validate message {string}")
    public void user_provides_active_status_and_validate_message(String status, String message) {
        epAnnouncement.validateChangingVisibility(status,message);
    }

    @Then("User provides text {string}, groupId {string} and validates message {string} announcement update")
    public void user_provides_text_group_id_and_validates_message_announcement_update(String updateText, String groupID, String expectedMessage) {
        epAnnouncement.validateHappyUpdateAnnouncement(updateText,groupID,expectedMessage);
    }

    @When("User deletes announcement, validates deleted message {string} and checks again status {string}, message {string}")
    public void user_deletes_announcement_validates_deleted_message_and_checks_again_status_message(String deletedMessage, String status, String errorMessage) {
        epAnnouncement.validateDeleteAnnouncement(deletedMessage,status,errorMessage);
    }
}
