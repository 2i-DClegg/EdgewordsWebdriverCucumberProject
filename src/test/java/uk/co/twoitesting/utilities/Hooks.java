package uk.co.twoitesting.utilities;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.sl.In;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import uk.co.twoitesting.POMPages.CartPagePOM;

import java.util.List;

public class Hooks {
    private final SharedDictionary sharedDictionary;
    private WebDriver driver;

    public Hooks (SharedDictionary sharedDictionary){
        this.sharedDictionary = sharedDictionary;
    }

    @Before
    public void SetUp () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        sharedDictionary.addValue("driver", driver);
    }

    @After
    public void TearDown()throws InterruptedException {
        WebDriver sharedDriver = (WebDriver) sharedDictionary.getValue("driver");
        //Clear our cart


        sharedDriver.findElement(By.linkText("Cart")).click();
        //clear discount code
        try{
            sharedDriver.findElement(By.linkText("[Remove]")).click();
        } catch (NoSuchElementException ignored) {

        }

        //clear all items in cart
        try {
           List<WebElement> removeButtons =  sharedDriver.findElements(By.className("remove"));
            for(WebElement removeButton: removeButtons) {
                removeButton.click();
            }
        } catch (NoSuchElementException ignored){

        }

        sharedDriver.quit();
    }
}
