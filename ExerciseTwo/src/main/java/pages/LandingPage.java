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
  private WebElement lblSearchBoxPWA;

  @FindBy(xpath = "//*[@id=\"top-search\"]/div[1]/div/div[2]/ul/li[2]")
  private WebElement lblFirstOption;

  @FindBy(xpath = "//*[@id=\"top-search\"]/div[2]/button")
  private WebElement lblLetsGo;

  public LandingPage (WebDriver driver) {
    PageFactory.initElements(driver, this);
    this.driver = driver;
  }

  public LandingPage enterCityName() {
    if(driver.getCurrentUrl().equals("https://www.hostelworld.com/pwa/")) {
      lblSearchBoxPWA.sendKeys(TestDataConstants.TESTCITY);
    } else {
      lblSearchBox.sendKeys(TestDataConstants.TESTCITY);
    }
    return this;
  }

  public LandingPage selectCity() {
    lblFirstOption.click();
    return this;
  }

  public void letsGo() {
    lblLetsGo.click();
  }
}
