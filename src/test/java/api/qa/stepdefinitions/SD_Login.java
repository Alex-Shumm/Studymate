package api.qa.stepdefinitions;

import api.qa.endpints.EP_Login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class SD_Login {
    EP_Login epLogin = new EP_Login();

    @Then("User validates email {string}, authority {string}, workspaceId {string}, language {string}")
    public void user_validates_email_authority_workspace_id_language(String expectedEmail, String expectedAuthority, String expectedWorkspaceId, String expectedLanguage) {
        epLogin.validateHappyLoginData(expectedEmail, expectedAuthority, expectedWorkspaceId, expectedLanguage);
    }

    @Then("User provides email {string}, password {string}, then validates status {string}, message {string} and statusCode {string}")
    public void user_provides_email_password_then_validates_status_message_and_status_code(String email, String password, String status, String message, String statusCode) {
        epLogin.validateNegativeLoginData(email, password, status, message, statusCode);
    }

    @Then("User validates message {string}")
    public void user_validates_message(String expectedMessage) {
        epLogin.validateHappyResetPassword(expectedMessage);
    }

}
