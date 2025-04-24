package ui.qa.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import ui.qa.pages.TeachersPage;
import utils.DriverHelper;

public class TeachersStepDef {
    public WebDriver driver = DriverHelper.getDriver();

    TeachersPage teachersPage = new TeachersPage(driver);

    @When("User clicks on the Teachers Page and validates current url {string}")
    public void user_clicks_on_the_teachers_page_and_validates_current_url(String expectedUrl) {
        teachersPage.validateCurrentUrl(driver, expectedUrl);
    }

    @Then("User clicks on the Add teacher")
    public void user_clicks_on_the_add_teacher() {
        teachersPage.clickAddTeacher();
    }

    @Then("User provides first name {string}, last name {string}, phone {string}, email {string}, specialization {string}")
    public void user_provides_first_name_last_name_phone_email_specialization(String teachersFirstName, String teacherLastName, String teachersPhoneNumber,
                                                                              String teachersEmail, String specialization) {
        teachersPage.validateNewTeacherAddition(teachersFirstName, teacherLastName, teachersPhoneNumber, teachersEmail, specialization);
    }

    @Then("User chooses Courses {string} and clicks Add button")
    public void user_chooses_courses_and_clicks_add_button(String chooseCourse) throws InterruptedException {
        teachersPage.validateNewTeacherAdditionNextStep(driver, chooseCourse);
    }

    @Then("User validates successful message {string}")
    public void user_validates_successful_message(String expectedMessage) {
        teachersPage.validateSuccessfulTeacherAdding(driver, expectedMessage);
    }

    @Then("User validates warning message {string}")
    public void user_validates_warning_message(String warningMessage) throws InterruptedException {
        teachersPage.validateDuplicateTeachers(driver, warningMessage);
    }

    @When("User presses Actions button and clicks Edit button")
    public void user_presses_actions_button_and_clicks_edit_button() throws InterruptedException {
        teachersPage.clickingActionsAndEditButton();
    }

    @When("User provides new first name {string}, phone {string}, specialization {string}")
    public void user_provides_new_first_name_phone_specialization(String firstName, String phone, String specialization) throws InterruptedException {
        teachersPage.editingTeacherInformation(driver, firstName, phone, specialization);
    }

    @When("User clicks Save button")
    public void user_clicks_save_button() {
        teachersPage.savingEditingInformation();
    }

    @Then("Validates successful edit message {string}")
    public void validates_successful_edit_message(String expectedEditMessage) {
        teachersPage.validatingEditingMessage(expectedEditMessage);
    }

    @When("User presses Actions button and clicks Delete button")
    public void user_presses_actions_button_and_clicks_delete_button() throws InterruptedException {
        teachersPage.deletingTeacher();
    }
    @When("User clicks Delete button in pop up message")
    public void user_clicks_delete_button_in_pop_up_message() throws InterruptedException {
        teachersPage.confirmingTeacherDeletion();
    }
    @Then("Validates successful deletion message {string}")
    public void validates_successful_deletion_message(String expectedDeletionMessage) {
        teachersPage.validatingDeletionMessage(expectedDeletionMessage);
}

}
