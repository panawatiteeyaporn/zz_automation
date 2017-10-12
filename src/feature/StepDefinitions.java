package feature;

import java.io.File;
import java.util.List;
import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
  String amazonSite;

  @Given("^I am on Google website$")
  public void i_am_on_Google_website() {
    driver.navigate().to("https://www.google.co.uk");
  }

  @When("^I click on the search text box and type iPhone$")
  public void i_click_on_the_search_text_box_and_type_iPhone() {
    driver.findElement(By.id("lst-ib")).sendKeys("iPhone");
  }

  @When("^I click google search button$")
  public void i_click_google_search_button() {
    driver.findElement(By.name("btnK")).click();
  }

  @When("^I found amazon site that sell iPhone from the search results$")
  public void i_found_amazon_site_that_sell_iPhone_from_the_search_results() {
    List<WebElement> elements = driver.findElements(By.xpath("//div[@class='g']"));
    boolean found = false;

    while (!found) {

      for (int i = 0; i < elements.size(); i++) {
        WebElement ele =
            elements.get(i).findElement(By.xpath("//h3[@class='r']")).findElement(By.tagName("a"));
        String url = ele.getAttribute("href");
        if (url.contains("amazon")) {
          amazonSite = url;
          found = true;
        }
      }

      driver.findElement(By.xpath("//*[@id='pnnext']/span[2]")).click();
      elements = driver.findElements(By.xpath("//div[@class='g']"));
    }

  }

  @Then("^I navigate to the amazon site$")
  public void i_click_on_the_amazon_site() {
    Asserts.check(amazonSite != null, "Cannot find amazon from the search");
    driver.navigate().to(amazonSite);
  }

  @Then("^I find name and size of the largest model which is cost less than (\\d+)$")
  public void i_find_name_and_size_of_the_largest_model_which_is_cost_less_than(int amount) {

  }

}
