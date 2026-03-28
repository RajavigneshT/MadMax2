import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class amasonEcommerceMoveToCart {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @Test(groups = "cart")
    public void addProductToCart() throws InterruptedException {

        // 1. Go to Amazon URL
        driver.get("https://www.flipkart.com/");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@alt='Cart']")).click();
        driver.findElement(By.xpath("")).sendKeys("water cup");

//        // 2. Search product
//        WebElement searchBox = wait.until(
//                ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox"))
//        );
//        searchBox.sendKeys("shoes for men sports");
//        driver.findElement(By.id("nav-search-submit-button")).click();
//
//        // 3. Get product list
//        List<WebElement> products =
//                driver.findElements(By.xpath("//div[@data-cy='title-recipe']"));
//
//// Store clean product names
//        List<String> productNames = new ArrayList<>();
//
//        for (WebElement getproduct : products) {
//            String cleanText = getproduct.getText()
//                    .replace("Sponsored", "")
//                    .replace("Campus", "")
//                    .trim();
//
//            if (!cleanText.isEmpty()) {
//                productNames.add(cleanText);
//            }
//        }
//
//// Print ALL products
//        System.out.println("All Products:");
//        for (String name : productNames) {
//            System.out.println(name);
//        }
//
//// 4. Match product name and click
//        WebElement clickAddtoCart=driver.findElement(By.xpath("//button[@aria-label='Add to cart']"));
//        clickAddtoCart.click();
//
//
//        // 5. Switch to new tab
//        for (String window : driver.getWindowHandles()) {
//            driver.switchTo().window(window);
//            clickAddtoCart.click();
//            break;
//        }

    }

    @AfterClass
    public void tearDown() {
       driver.quit();
    }
}
