package tests;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseAT {

  WebDriver driver;

  @BeforeClass
  public void testSetup()
  {
    System.setProperty("webdriver.chrome.driver", "src/main/java/helper/driver/chromedriver");
    driver=new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    driver.get("https://www.hostelworld.com/");
  }
}
