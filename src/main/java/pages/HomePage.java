package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;
    By profileName = By.xpath("//a[@class='oxd-main-menu-item']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getLoggedInUser() {
        return driver.findElement(profileName).getText();
    }
}