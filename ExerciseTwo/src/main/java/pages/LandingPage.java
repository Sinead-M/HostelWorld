package pages;

import helper.TestDataConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

  private WebDriver driver;

  @FindBy(id = "home-search-keywords")
  private WebElement lblSearchBox;

  @FindBy(id = "location-text-input-field")
  private WebElement lblSearchBoxPwa;

  @FindBy(xpath = "//*[@id=\"top-search\"]/div[1]/div/div[2]/ul/li[2]")
  private WebElement lblFirstOption;

  @FindBy(xpath = "//*[@id=\"predicted-search-results\"]/li[2]")
  private WebElement lblFirstOptionPwa;

  @FindBy(xpath = "//*[@id=\"top-search\"]/div[2]/button")
  private WebElement lblLetsGo;

  @FindBy(id = "search-button")
  private WebElement lblLetsGoPwa;

  public LandingPage (WebDriver driver) {
    PageFactory.initElements(driver, this);
    this.driver = driver;
  }

  public LandingPage enterCityName() {
    if(driver.getCurrentUrl().equals("https://www.hostelworld.com/pwa/")) {
      lblSearchBoxPwa.sendKeys(TestDataConstants.TESTCITY);
    } else {
      lblSearchBox.sendKeys(TestDataConstants.TESTCITY);
    }
    return this;
  }

  public LandingPage selectCity() {
    if (driver.getCurrentUrl().equals("https://www.hostelworld.com/pwa/")) {
      lblFirstOptionPwa.click();
    } else {
      lblFirstOption.click();
    }
    return this;
  }

  public void letsGo() {
    if (driver.getCurrentUrl().equals("https://www.hostelworld.com/pwa/")) {
      lblSearchBoxPwa.click();
    } else {
      lblSearchBox.click();
    }
  }
}
