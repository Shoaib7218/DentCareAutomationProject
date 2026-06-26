package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;


    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Test Started");
    }

    @AfterMethod
    public void tear(){
       if(driver != null){
           driver.quit();
       }

       // the if condition is because what if we only write Webdriver driver; do not assing any browser driver like chrome
        // in that case we write the if condition so that if the browser is not loaded we do not get unexpected errors.
    }
}
