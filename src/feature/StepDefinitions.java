package feature;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions {

  File binaryFile = new File("resources/firefox.exe");
  FirefoxBinary ffBinary = new FirefoxBinary(binaryFile);
  FirefoxProfile ffProfile = new FirefoxProfile();

  WebDriver driver = new FirefoxDriver(ffBinary, ffProfile);

  @Given("^I navigate to BBC News website$")
  public void navigateToBBCHomePage() throws Throwable {
    driver.navigate().to("http://www.bbc.co.uk/news");
  }

  @When("^I click on the sport section$")
  public void clickedSportLink() throws Throwable {
    driver.findElement(By.id("mybbc-wrapper")).click();
  }

  @Then("^I am at the sport section$")
  public void validateSportHeader() throws Throwable {

  }

}
