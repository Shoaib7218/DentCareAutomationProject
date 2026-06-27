package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverInfo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }


    public void loginUser(String email, String password){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement emailInput = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.name("email")
        ));
        WebElement passwordInput = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.name("password")
        ));
        WebElement signInButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//Button[text()='Sign In']")
        ));

        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        signInButton.click();
    }
}
