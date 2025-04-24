package ui.qa.stepdefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import ui.qa.pages.StudentsPage;
import utils.DriverHelper;

public class StudentsStepDef {
    WebDriver driver = DriverHelper.getDriver();
    StudentsPage studentsPage = new StudentsPage(driver);

    @Then("User click on the Add students")
    public void user_click_on_the_add_students() {
        studentsPage.clickAddStudentsButton();
    }

    @Then("User provides first name {string}, last name {string}, phone {string}, email {string}")
    public void user_provides_first_name_last_name_phone_email(String firstName, String lastName, String phone, String email) {
        studentsPage.createNewStudents(driver, firstName, lastName, phone, email);
    }

    @Then("User choose Group {string} and Study format {string} and click Add button")
    public void user_choose_group_and_study_format_and_click_add_button(String group, String format) throws InterruptedException {
        studentsPage.createNewStudentsNextStep(driver, group, format);
    }

    @Then("User validate successful message {string}")
    public void user_validate_successful_message(String expectedMessage) {
        studentsPage.validateHappyPath(driver, expectedMessage);
    }

    @Then("User validate negative message {string}")
    public void user_validate_negative_message(String expectedNegativeMessage) {
        studentsPage.validateDuplicateStudents(driver, expectedNegativeMessage);
    }

}
