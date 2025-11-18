package testcases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;
import pages.FlightResultsPage;

public class FlightDetailsTest extends BaseClass {

    @Test
    public void getIndigoFlightDetails() throws InterruptedException {

        driver.get("https://www.makemytrip.com/");

        LoginPage login = new LoginPage(driver);
        FlightResultsPage results = new FlightResultsPage(driver);

        login.closeInitialPopup();
        login.clickSearch();
        login.clickOkayGotIt();

        Thread.sleep(4000); // give time to load data

        List<WebElement> flights = results.getIndigoCards();
        System.out.println("Total Indigo Flights Found: " + flights.size());
        System.out.println("====== INDIGO FLIGHT DETAILS ======");

        for (WebElement card : flights) {
            try {
                String dep = results.getDeparture(card);
                String arr = results.getArrival(card);
                String price = results.getPrice(card);

                System.out.println(
                        "IndiGo | Departure: " + dep +
                        " | Arrival: " + arr +
                        " | Price: " + price);
            }
            catch (Exception e) {
                System.out.println("Skipping a card due to missing details.");
            }
        }

        System.out.println("====================================");
    }
}
