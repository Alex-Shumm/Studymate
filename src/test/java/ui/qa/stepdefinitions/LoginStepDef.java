package ui.qa.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import ui.qa.pages.LoginPage;
import utils.ConfigReader;
import utils.DriverHelper;

public class LoginStepDef {
    WebDriver driver = DriverHelper.getDriver();
    LoginPage loginPage = new LoginPage(driver);

    @Given("User provides username and password and clicks LogIn button and validates url")
    public void user_provides_username_and_password_and_clicks_log_in_button_and_validates_url() throws InterruptedException {
        loginPage.happyLogin(ConfigReader.readProperty("username"),ConfigReader.readProperty("password"),
                ConfigReader.readProperty("studymateGroup_url"));
    }

    @Given("User provides {string} and {string}")
    public void user_provides_and(String username, String password) {
        loginPage.negativeLogin(username,password);

    }
    @When("User clicks signIn button and validates failed message {string}")
    public void user_clicks_sign_in_button_and_validates_failed_message(String message) {
        loginPage.clickSingInAndValidateErrorMessage(message);
    }
    @When("User clicks Administrator and Log out buttons")
    public void user_clicks_administrator_and_log_out_buttons() {
        loginPage.clickAdminAndLogout();
    }
    @When("User confirms Log out and validates URL")
    public void user_confirms_log_out_and_validates_url() {
        loginPage.confirmLogoutAndValidateURL(ConfigReader.readProperty("studymateLogout_url"));
    }
}
