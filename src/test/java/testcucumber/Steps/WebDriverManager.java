package testcucumber.Steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverManager {
    private static WebDriver driver;

    public static WebDriver getInstance() {
        String browserName = "chrome";

        if (driver == null) {

            switch (browserName) {
                case "chrome": {
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    break;
                }
                case "chrome-headless": {
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless");
                    driver = new ChromeDriver(options);
                    break;
                }
                case "IE": {
                    driver = new InternetExplorerDriver();
                    break;
                }
            }

        }
        return driver;
    }

}
