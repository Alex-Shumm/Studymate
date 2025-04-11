package ui.qa.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.List;


public class TeachersPage {
    public TeachersPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li[contains(text(), 'Teachers')]")
    WebElement teachersLink;

    @FindBy(xpath = "//button[contains(text(), 'Add teacher')]")
    WebElement addTeacherButton;

    @FindBy(xpath = "//input[@name='name']")
    WebElement teachersFirstName;

    @FindBy(xpath = "//input[@name='lastName']")
    WebElement teacherLastName;

    @FindBy(xpath = "//input[@name='phoneNumber']")
    WebElement teachersPhoneNumber;

    @FindBy(xpath = "//input[@name='email']")
    WebElement teachersEmail;

    @FindBy(xpath = "//input[@name='specialization']")
    WebElement specialization;

    @FindBy(xpath = "//div[@role='button']")
    WebElement teachersCourse;

    @FindBy(xpath = "//li[@data-value='35']")
    WebElement seleniumCourse;

    @FindBy(xpath = "//li[@data-value='33']")
    WebElement cucumberCourse;

    @FindBy(xpath = "//div[@class='sc-gKPRtg gmDlqC actions']//button[contains(@class, 'css-79mk38')]")
    WebElement add_button;

    @FindBy(xpath = "//p[contains(text(),'successfully saved')]")
    WebElement savedTeacherMessage;

    @FindBy(xpath = "//p[contains(text(),'already exists')]")
    WebElement errorAddingMessage;

    @FindBy(xpath = "//button[.='Cancel']")
    WebElement cancelButton;

    @FindBy(xpath = "//tr[1]//button[@type='button']")
    WebElement actionsButton;

    @FindBy(xpath = "//ul[@role='menu']//*[.='Edit']")
    List<WebElement> editButton;

    @FindBy(xpath = "//button[.='Save']")
    WebElement saveButton;

    @FindBy(xpath = "//p[contains(text(),'successfully updated')]")
    WebElement editingMessage;

    @FindBy(xpath = "//ul[@role='menu']//*[.='Delete']")
    List<WebElement> deleteButton;

    @FindBy(xpath = "//button[.='Delete']")
    WebElement popupDeleteButton;

    @FindBy(xpath = "//p[contains(text(),'successfully deleted')]")
    WebElement deletingMessage;

// ------------- METHODS ------------------------

    public void validateCurrentUrl(WebDriver driver, String expectedUrl) {
        teachersLink.click();
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
    }

    public void clickAddTeacher() {
        addTeacherButton.click();
    }

    public void validateNewTeacherAddition(String teachersFirstName, String teacherLastName, String teachersPhoneNumber,
                                           String teachersEmail, String specialization) {
        this.teachersFirstName.sendKeys(teachersFirstName);
        this.teacherLastName.sendKeys(teacherLastName);
        this.teachersPhoneNumber.click();
        this.teachersPhoneNumber.sendKeys(teachersPhoneNumber);
        this.teachersEmail.sendKeys(teachersEmail);
        this.specialization.sendKeys(specialization);

    }

    public void validateNewTeacherAdditionNextStep(WebDriver driver, String chooseCourse) throws InterruptedException {
        this.teachersCourse.click();
        Thread.sleep(2000);

        Actions actions = new Actions(driver);
        if (chooseCourse.contains("Selenium")) {
            actions.moveToElement(seleniumCourse).click().perform();
        } else if (chooseCourse.contains("Cucumber")) {
            actions.moveToElement(cucumberCourse).click().perform();
        }

        BrowserUtils.clickWithJS(driver, this.teachersEmail);
        BrowserUtils.clickWithJS(driver, this.add_button);
    }

    public void validateSuccessfulTeacherAdding(WebDriver driver, String expectedMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(savedTeacherMessage));
        Assert.assertEquals(BrowserUtils.getText(savedTeacherMessage), expectedMessage);
    }

    public void validateDuplicateTeachers(WebDriver driver, String warningMessage) throws InterruptedException {

        BrowserUtils.clickWithJS(driver, cancelButton);
        Thread.sleep(2000);
        Assert.assertEquals(BrowserUtils.getText(errorAddingMessage), warningMessage);
    }

    public void clickingActionsAndEditButton() throws InterruptedException {
        actionsButton.click();
        Thread.sleep(2000);
        for (WebElement button : editButton) {
            if (button.isDisplayed()) {
                button.click();
            }
        }
    }

    public void editingTeacherInformation(WebDriver driver, String firstName, String phone, String specialization) throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.doubleClick(teachersFirstName).perform();
        teachersFirstName.sendKeys(firstName);

        this.teachersPhoneNumber.click();
        teachersPhoneNumber.sendKeys(phone);
        actions.doubleClick(this.specialization).perform();

        this.specialization.sendKeys(specialization);
    }

    public void savingEditingInformation() {
        saveButton.click();
    }

    public void validatingEditingMessage(String expectedEditMessage) {
        Assert.assertEquals(expectedEditMessage, BrowserUtils.getText(editingMessage));
    }

    public void deletingTeacher() throws InterruptedException {
        actionsButton.click();
        Thread.sleep(2000);
        for (WebElement button : deleteButton) {
            if (button.isDisplayed()) {
                button.click();
            }
        }
    }

    public void confirmingTeacherDeletion() throws InterruptedException {
        popupDeleteButton.click();
        Thread.sleep(2000);
    }

    public void validatingDeletionMessage(String expectedDeletingMessage) {
        Assert.assertEquals(expectedDeletingMessage, BrowserUtils.getText(deletingMessage));
    }


}
