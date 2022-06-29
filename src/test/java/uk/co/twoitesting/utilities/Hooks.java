package uk.co.twoitesting.utilities;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    private final SharedDictionary sharedDictionary;
    WebDriver driver;

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
    public void TearDown(){
        WebDriver sharedDriver = (WebDriver) sharedDictionary.getValue("driver");
        sharedDriver.quit();
    }
}
