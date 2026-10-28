package org.test.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;

public class SeleniumDriver {

    public static WebDriver getAutoLocalDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-search-engine-choice-screen");
        return new ChromeDriver(options);
    }

    public static WebDriver setLocalDriver() {
        String customPath = "D:\\WebDriver\\chromedriver-win64\\chromedriver.exe";
        if (new File(customPath).exists()) {
            System.setProperty("webdriver.chrome.driver", customPath);
        } else {
            WebDriverManager.chromedriver().setup();
        }
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-search-engine-choice-screen");
        return new ChromeDriver(options);
    }

    public static RemoteWebDriver getRemoteDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.setCapability("browserVersion", "128.0");
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            put("name", "Test badge...");
            put("sessionTimeout", "15m");
            put("env", new ArrayList<String>() {{
                add("TZ=UTC");
            }});
            put("enableVideo", true);
            put("enableVNC", true);
            put("enableLog", true);
        }});
        RemoteWebDriver remoteDriver = null;
        try {
            remoteDriver = new RemoteWebDriver(URI.create("http://127.0.0.1:4444/wd/hub").toURL(), options);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return remoteDriver;
    }

    public static void scrollToEl(WebDriver driver, WebElement el) {
        new Actions(driver).scrollToElement(el).perform();
    }

    public static void scrollByAmount(WebDriver driver, int x, int y) {
        new Actions(driver).scrollByAmount(x, y).perform();
    }
}
