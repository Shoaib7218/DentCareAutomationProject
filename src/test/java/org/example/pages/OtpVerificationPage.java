package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OtpVerificationPage {

    public WebDriver driver;



    public OtpVerificationPage(WebDriver driver){
        this.driver = driver;
    }

    public void sendOtp( String email,String otp){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement inputOtp = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form//input")));

        inputOtp.sendKeys(otp); // "// means direct child not grand child "/" single means any child gchild
        driver.findElement(By.xpath("//form//button")).click();


    }
}
