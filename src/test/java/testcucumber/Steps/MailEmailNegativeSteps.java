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

import static org.junit.Assert.assertArrayEquals;
import static testcucumber.Steps.BaseTest.getDriver;


public class MailEmailNegativeSteps {

    public WebDriver driver;

    @Given("^Пользователь находится на главной странице Mail$")
    public void User_on_the_main_Mail_page (){

        driver = getDriver();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get("https://mail.ru");

    }

   @When("^Пользователь вводит в поле логин \"(.*)\", поле пароль \"(.*)\" и нажимает кнопку войти$")

    public void The_user_enters_incorrect_credentials (String login, String password){

        driver.findElement(By.name("login")).sendKeys(login);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("[value = 'Войти']")).click();


        //driver.findElement(By.cssSelector("[value='Поиск в Google']")).click();

    }
    @Then("^Пользователь попадает на форму повторной попытки входа в почту$")
    public void user_goes_to_the_email_re_login_page (){

        driver.switchTo().frame(driver.findElement(By.cssSelector(".ag-popup__frame__layout__iframe")));

        WebElement element1 = driver.findElement(By.cssSelector("[class='b-login__errors']"));
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(element1));

      // WebElement element = driver.findElement(By.cssSelector("input.base-0-45"));
       //new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(element));

      // Assert.assertEquals("we", element1.getText());
    }



}
