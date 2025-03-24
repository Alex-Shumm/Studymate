package ui.qa.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BrowserUtils;
import utils.DriverHelper;

import java.time.Duration;

public class LoginPage {
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public WebDriver driver = DriverHelper.getDriver();

    @FindBy(xpath = "//input[@id=':r0:']")
    WebElement username;

    @FindBy(xpath = "//input[@id=':r1:']")
    WebElement password;

    @FindBy(xpath = "//button[.='Log in']")
    WebElement loginButton;

    @FindBy(xpath = "//p[@class='sc-dkrFOg hbyUzQ']")
    WebElement errorMessage;

    @FindBy(xpath = "//p[.='Administrator']")
    WebElement adminButton;

    @FindBy(xpath = "//li[contains(@class,'css-1km1ehz')]")
    WebElement logoutButton;

    @FindBy(xpath = "//button[.='Log out']")
    WebElement confirmLogoutButton;

    public void happyLogin(String username, String password, String URL) throws InterruptedException {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
//        adminButton.click();
//        adminButton.click();
        Assert.assertEquals(URL, driver.getCurrentUrl());
    }

    public void negativeLogin(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
    }

    public void clickSingInAndValidateErrorMessage(String message){
        loginButton.click();
        Assert.assertEquals(message, BrowserUtils.getText(errorMessage));
    }

    public void clickAdminAndLogout(){
        BrowserUtils.clickWithJS(driver, adminButton);
        BrowserUtils.clickWithJS(driver, logoutButton);
    }

    public void confirmLogoutAndValidateURL(String url){
        confirmLogoutButton.click();
        Assert.assertEquals(url, driver.getCurrentUrl());
    }
}
