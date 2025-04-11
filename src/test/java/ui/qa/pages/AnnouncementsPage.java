package ui.qa.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AnnouncementsPage {

    public AnnouncementsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[.='Add an announcement']")
    WebElement addAnnouncementButton;

    @FindBy(xpath = "//textarea")
    WebElement textInput;

    @FindBy(css = "#mui-component-select-groups")
    WebElement groupSelectButton;

    @FindBy(xpath = "//li[.='Batch8']")
    WebElement batch8Group;

    @FindBy(xpath = "//li[.='Batch7']")
    WebElement batch7Group;

    @FindBy(xpath = "//button[.='Add']")
    WebElement add_btn;

    @FindBy(xpath = "//p[contains(text(),'successfully saved')]")
    WebElement announcementMessage;

    @FindBy(xpath = "//div[@class='css-yys58j']")
    WebElement threeDots;

    @FindBy(xpath = "//li[.='Delete']")
    WebElement deleteButton;

    @FindBy(xpath = "//button[.='Delete']")
    WebElement confirmDeleteButton;

    @FindBy(xpath = "//p[.='ANNOUNCEMENT successfully deleted']")
    WebElement successfullyDeletedMessage;

    @FindBy(xpath = "//span[.='Hidden']")
    WebElement hiddenText;

    @FindBy(xpath = "//div[.='Batch8']")
    WebElement batch8Text;

    @FindBy(xpath = "//div[.='ADMIN']")
    WebElement adminText;

    @FindBy(xpath = "//p[contains(text(),'Dear')]")
    WebElement annText;

    @FindBy(xpath = "//p[.='03.28.25']")
    WebElement creatingData;

    @FindBy(xpath ="//p[.='Announcement successfully activated']")
    WebElement activatedMessage;

    @FindBy(xpath = "//li[.='Show']")
    WebElement showButton;

    @FindBy(xpath = "//button[contains(@class,'css-fab8xs')]")
    WebElement applyButton;

    public void changeVisibility(){
        threeDots.click();
        showButton.click();
    }

    public void confirmApplyAndValidateMessage(String message){
        applyButton.click();
        Assert.assertEquals(message, activatedMessage.getText());
    }

    public void validateAnnouncement(String type, String group, String creator, String text, String data){
        Assert.assertEquals(type, hiddenText.getText());
        Assert.assertEquals(group, batch8Text.getText());
        Assert.assertEquals(creator, adminText.getText());
        Assert.assertEquals(text, annText.getText());
        Assert.assertEquals(data, creatingData.getText());
    }


    public void deleteAnnouncementFunctionality(){
        threeDots.click();
        deleteButton.click();
    }

    public void confirmDeleteAndValidateMessage(String expectedMessage){
        confirmDeleteButton.click();
        Assert.assertEquals(expectedMessage, successfullyDeletedMessage.getText());
    }

    public void clickAnnouncementsButton() {
        addAnnouncementButton.click();
    }

    public void createNewAnnouncementsFunctionality(WebDriver driver, String textInput, String group) throws InterruptedException {
        this.textInput.sendKeys(textInput);
        Actions actions = new Actions(driver);

        this.groupSelectButton.click();
        Thread.sleep(1000);
        if (group.equalsIgnoreCase("Batch8")) {
            actions.moveToElement(batch8Group).click().perform();
        } else if (group.equalsIgnoreCase("Batch7")) {
            actions.moveToElement(batch7Group).click().perform();
        }
        Thread.sleep(1000);
        add_btn.click();
    }

    public void validateSuccessfulMessage(WebDriver driver, String expectedAnnouncementMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(announcementMessage));
        Assert.assertEquals(announcementMessage.getText(), expectedAnnouncementMessage);
    }

}
