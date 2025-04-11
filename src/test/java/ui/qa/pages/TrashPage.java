package ui.qa.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverHelper;

import java.time.Duration;
import java.util.List;

public class TrashPage {
    public TrashPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    WebDriver driver = DriverHelper.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    @FindBy(xpath = "//p[@class='sc-dEVLtI ffxMPc']")
    WebElement trashHeader;

    @FindBy(xpath = "//tbody//tr[1]//td")
    List<WebElement> deletedItem;

    @FindBy(xpath = "//tbody/tr[1]/td[3]/div/*[2]")
    WebElement deleteFromTrashButton;

    @FindBy(xpath = "//div[@class='sc-bWOGAC jjzJTo']//*[2]")
    List<WebElement> firstLine;

    @FindBy(xpath = "//tbody/tr[1]/td[3]/div/*[1]")
    WebElement recoverFromTrashButton;

    @FindBy(xpath = "//p[.='Data deleted successfully']")
    WebElement deletedFromTrashMessage;

    @FindBy(xpath = "//p[.='Data successfully recovered']")
    WebElement recoveredFromTrashMessage;


    public void validateHeaderAndFirstItem(List<String> expectedDeletedItemInfo, String header) {
        Assert.assertEquals(trashHeader.getText(), header);
        for (int i = 0; i < deletedItem.size() - 1; i++) {
            Assert.assertEquals(deletedItem.get(i).getText(), expectedDeletedItemInfo.get(i));
        }
    }

    public void deleteFromTrash(String message) throws InterruptedException {
        deleteFromTrashButton.click();
        wait.until(ExpectedConditions.visibilityOf(deletedFromTrashMessage));
        Assert.assertEquals(message, deletedFromTrashMessage.getText());
    }

    public void validateThatItemWasDeleted(String name) throws InterruptedException {
        wait.until(ExpectedConditions.invisibilityOf(deletedItem.get(0)));
        Assert.assertNotEquals(name, deletedItem.get(0).getText());
    }

    public void recoverFromTrash(String message){
        recoverFromTrashButton.click();
        Assert.assertEquals(recoveredFromTrashMessage.getText(),message);
    }
}
