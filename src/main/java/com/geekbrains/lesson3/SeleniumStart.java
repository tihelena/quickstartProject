package com.geekbrains.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class SeleniumStart {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        Thread.sleep(10000);
        driver.quit();

//        WebDriverManager.safaridriver().setup();
//        WebDriver safariDriver = new SafariDriver();
//        safariDriver.get("https://google.com");
//        Thread.sleep(10000);
//        safariDriver.quit();

    }

}
