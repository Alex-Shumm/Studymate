package ui.qa.stepdefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import ui.qa.pages.GroupsPage;
import utils.DriverHelper;

public class GroupsFunctionalityStepDef {
    WebDriver driver = DriverHelper.getDriver();
    GroupsPage groupsPage = new GroupsPage(driver);

    @Then("User click on the Create groups")
    public void user_click_on_the_create_groups() throws InterruptedException {
        groupsPage.clickCreateGroup();
    }

    @Then("User provides group name {string}, description {string} and upload picture")
    public void user_provides_group_name_description_date_and_upload_picture(String groupName, String description) throws InterruptedException {
        groupsPage.createNewGroupsFunctionality(driver, groupName, description);
    }

    @Then("User click Create button")
    public void user_click_create_button() {
        groupsPage.clickCreateButton();
    }

    @Then("User validate successful group message {string}")
    public void user_validate_successful_group_message(String expectedConfirmationMessage) {
        groupsPage.validationHappyMessage(driver, expectedConfirmationMessage);
    }

}
