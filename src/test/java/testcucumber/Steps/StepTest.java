package testcucumber.Steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static testcucumber.Steps.BaseTest.getDriver;


public class StepTest {

    public WebDriver driver;

    @Given("^I am on the Google search page$")
    public void i_am_on_the_Google_search_page (){

        driver = getDriver();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get("https://google.com");

    }

    @When("^I search for \"(.*)\"$")
    public void i_search_for (String query){

        driver.findElement(By.name("q")).sendKeys(query);
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

        //driver.findElement(By.cssSelector("[value='Поиск в Google']")).click();

    }
    @Then("^The page title contains \"(.*)\"$")
    public void the_page_title_contains (String word){

        WebElement Element = new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.forum-topic-list > div"))));
        Assert.assertTrue(driver.getTitle().contains(word));
    }



}
