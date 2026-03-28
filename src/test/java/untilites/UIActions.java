package untilites;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class UIActions {
    private WebDriver driver;

    public UIActions(WebDriver driver) {
        this.driver = driver;
    }

    // Click Element
    public void click(WebElement element) {
        element.click();
    }

    // Enter Text
    public void enterText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    // Get Text
    public String getText(WebElement element) {
        return element.getText();
    }

    // Check Element Displayed
    public boolean isDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    // Scroll To Element
    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // JavaScript Click (when normal click fails)
    public void jsClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    // Scroll Page Down
    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
    }

    // Dropdown Select by Visible Text
    public void selectByText(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }

    // Mouse Hover
    public void mouseHover(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    // Double Click
    public void doubleClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
    }

    // Right Click
    public void rightClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }

    // Get Page Title
    public String getPageTitle() {
        return driver.getTitle();
    }

    // Navigate To URL
    public void openURL(String url) {
        driver.get(url);
    }

    // Switch To Alert
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    // Dismiss Alert
    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }
}
