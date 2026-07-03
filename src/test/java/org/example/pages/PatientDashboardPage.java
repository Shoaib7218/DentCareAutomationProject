package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PatientDashboardPage {

    WebDriver driver;

    public PatientDashboardPage(WebDriver driver){
        this.driver = driver;
    }

    public void goToDahsboard(){
        LoginPage lpg = new LoginPage(driver);
        lpg.loginUser("shoaib@gmail.com","patient123");
    }

    public void goToMyAppointments(){
        goToDahsboard();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement myAppointmentsLink = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//a[@href='/patient/appointments']")
        ));
        myAppointmentsLink.click();
    }

    public void goToBookAppointments(){
        goToDahsboard();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement bookAppointmentsLink = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//a[@href='/patient/book']")
        ));

        bookAppointmentsLink.click();
    }

}
