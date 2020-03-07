package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ResultsPage {

  private WebDriver driver;

  private WebDriverWait defaultWebDriverWait;

  @FindBy(xpath = "//*[@id=\"top-search\"]/div/div[1]/div")
  private WebElement lblSearchBox;

  public ResultsPage(WebDriver driver) {
    PageFactory.initElements(driver, this);
    this.driver = driver;
  }

  public void verifyProperties() {
    defaultWebDriverWait.until(ExpectedConditions.visibilityOf(lblSearchBox));
    String text = lblSearchBox.getAttribute("value");
    assertThat(text.contains("Madrid"), is(true));
    String searchUrl = driver.getCurrentUrl();
    assertThat(searchUrl.contains("Madrid"), is(true));
  }

}
