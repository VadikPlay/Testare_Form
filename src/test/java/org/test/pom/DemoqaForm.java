package org.test.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

    @FindBy(id = "userNumber")
    WebElement userNumber;

    @FindBy(id = "subjectsInput")
    WebElement subjectsInput;

    @FindBy(id = "hobbies-checkbox-1")
    WebElement hobbiesSports;

    @FindBy(id = "hobbies-checkbox-2")
    WebElement hobbiesReading;

    @FindBy(id = "hobbies-checkbox-3")
    WebElement hobbiesMusic;

    @FindBy(id = "state")
    WebElement state;

    @FindBy(id = "city")
    WebElement city;

    @FindBy(id = "submit")
    WebElement submit;

    public DemoqaForm(WebDriver driverParam) {
        this.driver = driverParam;
        PageFactory.initElements(driverParam, this);
    }

    public void setFirstName(String firstNameParam) {
        firstName.click();
        firstName.clear();
        firstName.sendKeys(firstNameParam);
        if (firstName.getAttribute("value").isEmpty()) {
            firstName.sendKeys(firstNameParam);
        }
    }

    public void setLastName(String lastNameParam) {
        lastName.clear();
        lastName.sendKeys(lastNameParam);
    }

    public void setUserEmail(String userEmailParam) {
        userEmail.clear();
        userEmail.sendKeys(userEmailParam);
    }

    public void selectGenderMale() {
        genderMale.click();
    }

    public void setUserNumber(String userNumberParam) {
        userNumber.clear();
        userNumber.sendKeys(userNumberParam);
    }

    public void setSubjects(String subjectsParam) {
        subjectsInput.sendKeys(subjectsParam);
        subjectsInput.sendKeys(Keys.ENTER);
    }

    public void selectHobbiesSports() {
        try {
            hobbiesSports.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", hobbiesSports);
        }
    }

    public void selectHobbiesReading() {
        try {
            hobbiesReading.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", hobbiesReading);
        }
    }

    public void selectHobbiesMusic() {
        try {
            hobbiesMusic.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", hobbiesMusic);
        }
    }

    public void scrollToEl(WebElement el) {
        new Actions(driver).scrollToElement(el).perform();
    }

    public void setState(String stateParam) {
        new Actions(driver).scrollByAmount(0, 500).perform();
        state.click();
        WebElement el = driver.findElement(By.xpath("//div[text()='" + stateParam + "']"));
        el.click();
    }

    public void setCity(String cityParam) {
        city.click();
        WebElement el = driver.findElement(By.xpath("//div[text()='" + cityParam + "']"));
        el.click();
    }

    public void clickSubmit() {
        try {
            submit.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submit);
        }
    }
}
