package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Close initial login popup
    @FindBy(xpath = "//span[@class='commonModal__close']")
    WebElement closePopup;

    // Search button
    @FindBy(xpath = "//a[text()='Search']")
    WebElement searchBtn;

    // After search → OKAY GOT IT popup
    @FindBy(xpath = "//button[text()='OKAY, GOT IT!']")
    WebElement okGotItBtn;


    // ===================== METHODS =======================

    public void closeInitialPopup() {
        try { closePopup.click(); } catch (Exception e) {}
    }

    public void clickSearch() {
        searchBtn.click();
    }

    public void clickOkayGotIt() {
        try { okGotItBtn.click(); } catch (Exception e) {}
    }
}
