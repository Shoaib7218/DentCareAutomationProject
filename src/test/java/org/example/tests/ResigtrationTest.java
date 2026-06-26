package org.example.tests;

import com.sun.source.tree.AssertTree;
import io.restassured.response.Response;
import org.example.BaseTest;
import org.example.pages.OtpVerificationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.example.pages.RegistrationPage;

import java.time.Duration;

import static io.restassured.RestAssured.given;

public class ResigtrationTest extends BaseTest {




   @Test
    public void ValidRegistration() throws InterruptedException {

      RegistrationPage rgp = new RegistrationPage(driver);

       driver.get("http://localhost:5173/register");
       System.out.println(driver.getCurrentUrl());
       rgp.register("Shoaib Shaikh","rocky2@gmail.com","Shoaib123","1234567890");
       Thread.sleep(10000);
       Assert.assertTrue(driver.getCurrentUrl().contains("verify-otp"));

   }


    public String checkOtp(String email){
        Response response =
                given()
                        .log().all()
                        .when()
                        .get("http://localhost:8080/api/auth/test/get-otp?email="+email)
                ;

        System.out.println(response.asString());
        return response.asString();
    }

   @Test
    public void otpVerificationTest() throws InterruptedException {
       RegistrationPage rpg = new RegistrationPage(driver);
       OtpVerificationPage otp = new OtpVerificationPage(driver);

       driver.get("http://localhost:5173/register");

       rpg.register("Shoaib Shaikh","rocky1@gmail.com","Shoaib123","1234567890");

       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       wait.until(ExpectedConditions.urlContains("verify-otp"));

       String otpValue = checkOtp("rocky1@gmail.com");
       System.out.println("OTP received: [" + otpValue + "]");

       otp.sendOtp("rocky1@gmail.com",checkOtp("rocky1@gmail.com"));



       Thread.sleep(7000);
       Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));




   }

}
