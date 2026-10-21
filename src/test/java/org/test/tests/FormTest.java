package org.test.tests;

import org.openqa.selenium.WebDriver;
import org.test.pom.DemoqaForm;
import org.test.utils.SeleniumDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FormTest {

    public static WebDriver driver;
    public static DemoqaForm demoqaForm;

    public static String firstName = "Vadim";
    public static String lastName = "Noroc";
    public static String userEmail = "noroc.vadim@gmail.com";

    @BeforeTest
    public void beforeTest() {
        driver = SeleniumDriver.getAutoLocalDriver();
        driver.manage().window().maximize();
        demoqaForm = new DemoqaForm(driver);
    }

    @Test
    public void testForm() {
        driver.get("https://demoqa.com/automation-practice-form");
        demoqaForm.setFirstName(firstName);
        demoqaForm.setLastName(lastName);
        demoqaForm.setUserEmail(userEmail);
        demoqaForm.selectGenderMale();
    }

    @AfterTest
    public void afterTest() {
    }
}
