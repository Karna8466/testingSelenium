package pages;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightResultsPage {

    WebDriver driver;

    public FlightResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // All IndiGo flight result cards
    @FindBy(xpath = "//div[contains(@class, 'listingCard') and .//p[contains(text(),'IndiGo')]]")
    List<WebElement> indigoCards;


    // =============== GETTERS ===============
    public List<WebElement> getIndigoCards() {
        return indigoCards;
    }

    // =============== CHILD LOCATORS (Relative XPaths) ===============

    public String getDeparture(WebElement card) {
        return card.findElement(By.xpath(".//div[contains(@class,'timeInfoLeft')]//p/span"))
                   .getText().trim();
    }

    public String getArrival(WebElement card) {
        return card.findElement(By.xpath(".//div[contains(@class,'timeInfoRight')]//p/span[not(contains(@class,'plusDisplayText'))]"))
                   .getText().trim();
    }

    public String getPrice(WebElement card) {
        return card.findElement(By.xpath(".//div[@data-test='component-fare']//span"))
                   .getText().trim();
    }
}
