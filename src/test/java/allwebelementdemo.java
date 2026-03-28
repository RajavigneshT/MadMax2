import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import java.util.*;

public class allwebelementdemo {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(enabled =false)
    public void selectTravelDetails() {
        driver.get("https://www.phptravels.net");
        driver.findElement(By.xpath("//*[@name='from']")).click();
        driver.findElement(By.xpath("//div[@data-code='NYC']")).click();
        driver.findElement(By.xpath("//*[@name='to']")).click();
        driver.findElement(By.xpath("//div[@data-code='DEL']")).click();
        driver.findElement(By.xpath("//*[@id='flights-search' and @type='submit']")).click();
    }
    @Test(priority =1)
    public void dropdownSelectionUsingSelectMethod() {
        List<String> countries = new ArrayList<>();
        driver.get("https://testautomationpractice.blogspot.com/");
        WebElement drpCountryEle=driver.findElement(By.xpath("//*[@id='country']"));
        Select dropdowncountries=new Select(drpCountryEle);

        //select option from dropdown
        dropdowncountries.selectByVisibleText("France");
        dropdowncountries.selectByValue("japan");
        dropdowncountries.selectByIndex(1);
        dropdowncountries.selectByContainsVisibleText("C");

        //capture the options from the dropdown
        List<WebElement> options=dropdowncountries.getOptions();
        System.out.println("Number of options in dropdown "+options.size()+"\n");

        //print the options
        for(int i=0;i<options.size();i++){
            countries.add(options.get(i).getText());
        }
        System.out.println("Listed country using for loop "+countries+"\n");
        countries.clear();
        //enhanced for loop
        for(WebElement opt:options){
            countries.add(opt.getText());
        }
        System.out.println("Listed country using for loop "+countries);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
