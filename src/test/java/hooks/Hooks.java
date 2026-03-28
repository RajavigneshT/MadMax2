package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import untilites.ScreenshotUtil;

public class Hooks {

    WebDriver driver;

    @Before
    public void setup() {
        System.out.println("Before Scenario");
    }
    @Before(order=0)
    public void cleanScreenShotFolder(){
        ScreenshotUtil.deleteOldScreenshots();

    }


    @After
    public void tearDown() {
        System.out.println("After Scenario");
    }
    @After
    public void addScreenshot(Scenario scenario) {

        if (scenario.isFailed()) {

            byte[] screenshot =
                    ScreenshotUtil.captureScreenshotForReport(driver);

            scenario.attach(
                    screenshot,
                    "image/png",
                    scenario.getName());
        }
    }
}