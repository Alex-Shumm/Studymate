package ui.qa.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import ui.qa.pages.AnnouncementsPage;
import utils.DriverHelper;

public class AnnouncementsStepDef {
    WebDriver driver = DriverHelper.getDriver();
    AnnouncementsPage announcementsPage = new AnnouncementsPage(driver);

    @Given("User clicks on the Add an announcement")
    public void user_clicks_on_the_add_an_announcement() {
        announcementsPage.clickAnnouncementsButton();
    }

    @Given("User provides text of announcement {string}, choose group {string} and click Add button")
    public void user_provides_text_of_announcement_choose_group_and_click_add_button(String text, String group) throws InterruptedException {
        announcementsPage.createNewAnnouncementsFunctionality(driver, text, group);
    }

    @Then("User validate successful announcement message {string}")
    public void user_validate_successful_announcement_message(String expectedMessage) {
        announcementsPage.validateSuccessfulMessage(driver, expectedMessage);
    }

    @Given("User clicks three dots and clicks Delete button")
    public void user_clicks_three_dots_and_clicks_delete_button() {
        announcementsPage.deleteAnnouncementFunctionality();
    }

    @When("User confirms delete and validates {string}")
    public void user_confirms_delete_and_validates(String expectedMessage) {
        announcementsPage.confirmDeleteAndValidateMessage(expectedMessage);
    }

    @Then("User validates type {string}, for whom {string}, who created {string}, text {string} and data {string}")
    public void user_validates_type_for_whom_who_created_text_and_data(String type, String group, String creator, String text, String data) {
        announcementsPage.validateAnnouncement(type, group, creator, text, data);
    }
    @When("User clicks three dots and clicks Show button")
    public void user_clicks_three_dots_and_clicks_show_button() {
        announcementsPage.changeVisibility();
    }
    @When("User applies and validates {string}")
    public void user_applies_and_validates(String expectedMessage) {
        announcementsPage.confirmApplyAndValidateMessage(expectedMessage);
    }
}
