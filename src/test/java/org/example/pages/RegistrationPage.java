package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.text.Element;
import java.time.Duration;

public class RegistrationPage {

    public WebDriver driver;

    public RegistrationPage(WebDriver driver){
        this.driver = driver;
    }

    public void register(String fullName, String email,String pasword,String phone){


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement fullName1 = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.name("fullName")
                )
        );



        fullName1.sendKeys("Shoaib");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(phone);
        driver.findElement(By.name("password")).sendKeys(pasword);
        WebElement registerButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//button[text()='Create Account']")));

        registerButton.click();
    }

}
