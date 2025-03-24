package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Map;


public class MyStepdefs {

    WebDriver driver;

    @Given("I am on the right page")
    public void iAmOnTheRightPage() {

        driver = new ChromeDriver();

        // driver = new SafariDriver();

        driver.get("https://membership.basketballengland.co.uk/NewSupporterAccount");
    }

    @When("I put all the login info")
    public void iPutAllTheLoginInfo(DataTable table) throws InterruptedException {

        List<Map<String, String>> data = table.asMaps(String.class, String.class);

        WebElement date = driver.findElement(By.name("DateOfBirth"));
        //date.sendKeys(data.get(0).get("DateOfBirth"));
        date.sendKeys("14/04/2002");

        WebElement firstName = driver.findElement(By.name("Forename"));
        //firstName.sendKeys(data.get(0).get("FirstName"));
        firstName.sendKeys("Nahom");

        WebElement lastName = driver.findElement(By.name("Surname"));
        //lastName.sendKeys(data.get(0).get("LastName"));
        lastName.sendKeys("Tesfay");

        WebElement email = driver.findElement(By.name("EmailAddress"));
        //email.sendKeys(data.get(0).get("Email"));
        email.sendKeys("OfficeNT.3@gmail.com");

        WebElement emailConfirmation = driver.findElement(By.name("ConfirmEmailAddress"));
        //emailConfirmation.sendKeys(data.get(0).get("ConfirmEmail"));
        emailConfirmation.sendKeys("OfficeNT.3@gmail.com");

        WebElement password = driver.findElement(By.name("Password"));
        //password.sendKeys(data.get(0).get("Password"));
        password.sendKeys("2468.Tesfay");

        WebElement passwordConfirmation = driver.findElement(By.name("ConfirmPassword"));
        //passwordConfirmation.sendKeys(data.get(0).get("ConfirmPassword"));
        passwordConfirmation.sendKeys("2468.Tesfay");


    }

    @And("Click the right boxes")
    public void clickTheRightBoxes() throws InterruptedException {

        //Check this out
        WebElement termsAndConditions = driver.findElement(By.cssSelector("label[for='sign_up_25']"));
        termsAndConditions.click();

        WebElement ageConsent = driver.findElement(By.cssSelector("label[for='sign_up_26']"));
        ageConsent.click();

        WebElement consent = driver.findElement(By.cssSelector("label[for='fanmembersignup_agreetocodeofethicsandconduct']"));
        consent.click();

        WebElement join = driver.findElement(By.name("join"));
        join.click();
    }

    @Then("I will get to the confirmation page")
    public void iWillGetToTheConfirmationPage() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.urlContains("SignUpConfirmation"));

        boolean urlContainsConfirmation = wait.until(ExpectedConditions.urlContains("SignUpConfirmation"));
        Assert.assertTrue("The URL does not contain 'SignUpConfirmation'", urlContainsConfirmation);




    }
}
