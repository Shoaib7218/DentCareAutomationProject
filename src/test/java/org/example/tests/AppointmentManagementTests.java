package org.example.tests;

import org.example.BaseTest;
import org.example.pages.PatientDashboardPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AppointmentManagementTests extends BaseTest {


    // Cancelletion for Patient
    @Test
    public void appointmentCancelletionTest(){
        driver.get("http://localhost:5173/login");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PatientDashboardPage pdp = new PatientDashboardPage(driver);
        pdp.goToMyAppointments();
        WebElement cancelButton = driver.findElement(
                By.xpath(
                        "//div[contains(.,'Tooth Cleaning') and contains(.,'Dr. Dr. Rahul Sharma') and contains(.,'10:30') and contains(., '29') and contains(.,'Jun')]//button[contains(.,'Cancel')]"
                )
        );

        cancelButton.click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();



        WebElement cancelledText = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[contains(.,'Tooth Cleaning') and contains(.,'Dr. Dr. Rahul Sharma') and contains(.,'10:30') and contains(., '29') and contains(.,'Jun')]//span[text()='CANCELLED']")

        ));

        Assert.assertEquals("CANCELLED",cancelledText.getText());


    }


    // Ptient Appointment booking
    @Test
    public void AppointmentBookingTest() throws InterruptedException {
        PatientDashboardPage pdg = new PatientDashboardPage(driver);

        driver.get("http://localhost:5173/login");
        pdg.goToBookAppointments();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        WebElement doctorSelect = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.name("doctorId")
        ));

        WebElement serviceSelect = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.name("serviceId")
        ));

        WebElement date = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.name("appointmentDate")
        ));

        WebElement timingSlot = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div//button[text()='09:30']")
        ));

        WebElement notesText = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.name("notes")
        ));

        WebElement confirmButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//form//button[text()='Confirm Appointment ✅']")
        ));

        // selecting doctor
        Select doctorSelections = new Select(doctorSelect);
        doctorSelections.selectByValue("1");

        //selecting service
        Select serviceSelection = new Select(serviceSelect);
        serviceSelection.selectByValue("1");

        //entering date
        date.sendKeys("04-07-2026");

        //selecting timeslot
        timingSlot.click();

        // entering notes
        notesText.sendKeys("Doctor Help me !");

//        Confirm Appointment ✅

        confirmButton.click();

        Thread.sleep(10000);

        // Assertion if navigates to appointments page
        Assert.assertTrue(driver.getCurrentUrl().contains("appointments"));
    }

}
