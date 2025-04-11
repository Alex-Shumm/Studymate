package ui.qa.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GroupsPage {
    public GroupsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li[.='Groups']")
    WebElement groupLink;

    @FindBy(xpath = "//button[.='Create group']")
    WebElement createGroupButton;

    @FindBy(xpath = "//img[@alt='there should be a photo here']")
    WebElement clickPicture;

    @FindBy(xpath = "//input[@type='file']")
    WebElement uploadFile;

    @FindBy(xpath = "//input[@name='name']")
    WebElement groupName;
    @FindBy(xpath = "//input[@placeholder='dd.mm.y']")
    WebElement date;

    @FindBy(xpath = "//textarea[@name='description']")
    WebElement description;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement createButton;

    @FindBy(xpath = "//p[.='Group successfully saved']")
    WebElement confirmationMessage;

//    public void clickGroupsAndValidateUrl(WebDriver driver, String expectedUrl) {
//        groupLink.click();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//       wait.until(ExpectedConditions.urlToBe(expectedUrl));
//        Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
//    }

    public void clickCreateGroup() {
        createGroupButton.click();
    }

    public void createNewGroupsFunctionality(WebDriver driver, String groupName, String description) throws InterruptedException {

        this.groupName.sendKeys(groupName);
        String todayDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.date.sendKeys(todayDate);

        this.description.sendKeys(description);

        //    clickPicture.click();

        uploadFile.sendKeys("C://Users//shuma//OneDrive//Desktop//usa.png");

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement uploadElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='file']")));
//        uploadElement.sendKeys("C://Users//Scott//Downloads//usa.png");

    }

    public void clickCreateButton() {
        createButton.click();
    }

    public void validationHappyMessage(WebDriver driver, String expectedConfirmationMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(confirmationMessage));
        Assert.assertEquals(expectedConfirmationMessage, confirmationMessage.getText());
}

}
