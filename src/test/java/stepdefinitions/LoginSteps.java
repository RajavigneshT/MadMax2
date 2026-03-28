package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;

import static untilites.ScreenshotUtil.captureScreenshot;


public class LoginSteps {

    public static WebDriver driver;

    @Given("user launches browser")
    public void user_launches_browser() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    @When("user opens application")
    public void user_opens_application() {
        driver.get("https://google.com");
    }

    @Then("page title should be visible")
    public void page_title_should_be_visible() {
        System.out.println(driver.getTitle());
    }
    @Then("Take a screenshot of the {string} page")
    public void takeScreenshotCurrentPage(String screnshotPage)
    {
        captureScreenshot(driver,screnshotPage);
    }
    @And("user closes browser")
    public void user_closes_browser() {
        driver.quit();
    }

}