package tests;

import org.testng.annotations.Test;
import pages.LandingPage;
import pages.ResultsPage;

public class CitySearchAT extends BaseAT {

  private LandingPage landingPage;

  private ResultsPage resultsPage;

  @Test()
  public void searchCity() {
     landingPage = new LandingPage(driver);
     resultsPage = new ResultsPage(driver);
     landingPage
         .enterCityName()
         .selectCity()
         .letsGo();
     resultsPage.verifyProperties();
  }
}
