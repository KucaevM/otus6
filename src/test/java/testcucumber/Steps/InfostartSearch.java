package testcucumber.Steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static testcucumber.Steps.BaseTest.getDriver;

public class InfostartSearch {
    public WebDriver driver;

    @Given("^Я нахожусь на странице форума$")
    public void I_am_on_the_forum_page (){

        driver = getDriver();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get("https://forum.infostart.ru");

    }

    @When("^Я ищу \"(.*)\"$")
    public void I_search_for(String query){

        driver.findElement(By.id("forum-filter-search")).sendKeys(query);
        driver.findElement(By.cssSelector("[value = 'Найти']")).click();

    }

    @Then("^Результаты поиска содержат \"(.*)\"$")
    public void The_search_results_contain (String query){

        WebElement elementTable = driver.findElement(By.cssSelector("div.forum-topic-list > div > div > table"));

        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(elementTable));

        Assert.assertTrue(elementTable.getText().contains(query));

     }
}
