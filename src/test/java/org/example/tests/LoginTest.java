package org.example.tests;

import org.example.BaseTest;
import org.example.pages.LoginPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseTest {

    @Test
    public void patientLogin() throws InterruptedException {
//        try {
        driver.get("http://localhost:5173/login");
            LoginPage lpg = new LoginPage(driver);

            lpg.loginUser("shoaib@gmail.com", "patient123");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.not(ExpectedConditions.urlContains("login")));
         //   Thread.sleep(4000);
            Assert.assertTrue(driver.getCurrentUrl().contains("patient"));
//        }catch (Exception e){
//            System.out.println("TEST  FAILED ");
//            System.out.println("Patient Login Test " + e);

//        }
    }


    @Test
    public void doctorLogin(){

        LoginPage lpg = new LoginPage(driver);
        driver.get("http://localhost:5173/login");
        lpg.loginUser("dr.rahul@dentcare.com", "doctor123");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.not(ExpectedConditions.urlContains("login")));
        Assert.assertTrue(driver.getCurrentUrl().contains("doctor"),"DOCTOR LOGIN TEST FAILED ");

    }



    @Test
    public void adminLogin(){

        LoginPage lpg = new LoginPage(driver);
        driver.get("http://localhost:5173/login");
        lpg.loginUser("admin@dentcare.com", "admin123");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.not(ExpectedConditions.urlContains("login")));
        Assert.assertTrue(driver.getCurrentUrl().contains("admin"));

    }
}
