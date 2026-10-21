package org.test.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoqaForm {

    WebDriver driver;

    @FindBy(id = "firstName")
    WebElement firstName;

    @FindBy(id = "lastName")
    WebElement lastName;

    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "gender-radio-1")
    WebElement genderMale;

    public DemoqaForm(WebDriver driverParam) {
        this.driver = driverParam;
        PageFactory.initElements(driverParam, this);
    }

    public void setFirstName(String firstNameParam) {
        firstName.sendKeys(firstNameParam);
    }

    public void setLastName(String lastNameParam) {
        lastName.sendKeys(lastNameParam);
    }

    public void setUserEmail(String userEmailParam) {
        userEmail.sendKeys(userEmailParam);
    }

    public void selectGenderMale() {
        genderMale.click();
    }
}
