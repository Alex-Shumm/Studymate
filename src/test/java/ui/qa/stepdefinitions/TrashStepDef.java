package ui.qa.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import ui.qa.pages.GoToPage;
import ui.qa.pages.StudentsPage;
import ui.qa.pages.TrashPage;
import utils.ConfigReader;
import utils.DriverHelper;

import java.util.Arrays;
import java.util.List;

public class TrashStepDef {
    WebDriver driver = DriverHelper.getDriver();
    TrashPage trashPage = new TrashPage(driver);
    GoToPage goTo = new GoToPage(driver);
    StudentsPage studentsPage = new StudentsPage(driver);

    @Given("User deletes first item in the trash and validates {string}")
    public void user_deletes_first_item_in_the_trash_and_validates(String message) throws InterruptedException {
        trashPage.deleteFromTrash(message);
    }
    @Then("User validates that {string} was deleted")
    public void user_validates_that_was_deleted(String name) throws InterruptedException {
        trashPage.validateThatItemWasDeleted(name);
    }
    @When("User goes to {string} page")
    public void user_goes_to_page(String pageName) {
        goTo.switchPage(pageName);
    }
    @Given("User validates header and first item {string} and {string}")
    public void user_validates_header_and_first_item_and(String name, String date) {
        List<String> firstItem = Arrays.asList(name, date);
        trashPage.validateHeaderAndFirstItem(firstItem, ConfigReader.readProperty("trash_header"));
    }
    @When("User recovers first item in the trash and validates {string}")
    public void user_recovers_first_item_in_the_trash_and_validates(String expectedMessage) {
        trashPage.recoverFromTrash(expectedMessage);
    }
    @Then("User validates first items full name {string}, group {string}, format {string}, phone {string}")
    public void user_validates_first_items_full_name_group_format_phone(String fullName, String group, String format, String phone) throws InterruptedException {
        studentsPage.validationFirstTeacher(fullName, group, format, phone);
    }
}
