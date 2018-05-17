package testcucumber.Steps;



import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseTest {

    static WebDriver driver;

    public static WebDriver getDriver(){
        return driver;
    }
      @Before
    public void BeforeClass(){
          System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/FirstTest/chromedriver.exe");
          driver = testcucumber.Steps.WebDriverManager.getInstance();
      //    driver = new ChromeDriver();
        //driver = testcucumber.Steps.WebDriverManager.getInstance();
    }


    @After
    public void AfterClass() {

        driver.quit();
    }
}
