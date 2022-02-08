package com.geekbrains.lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PopUpBasicAuth {
    public static void main(String[] args) throws InterruptedException {
        /*The basic authentication pop-up is similar to the alert that pop-ups when the browser is navigated
        to a specific web page. To handle the basic authentication popup, we can pass the username and password
        along with the web page’s URL.
        The syntax for handling this login pop up is:
        https://username:password@URL*/

        final String LOGIN_NAME = "777test77er@rambler.ru";
        //в формате +7 (999) 908-7990
        final String LOGIN_PHONE = "+7 (903) 687-0254";
        final String PASSWORD = "Test777a";
        final String SHOP_URL = "https://podvorje.ru";
       // final String AUTH_URL = "https://" + LOGIN_NAME + ":" + PASSWORD + "@" + SHOP_URL;



        WebDriverManager.safaridriver().setup();
        WebDriver driver = new SafariDriver();
        driver.get(SHOP_URL);

        driver.manage().window().maximize();
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.openLoginPopup();");
        Thread.sleep(1000);
        js.executeScript("document.querySelector('#login-phone').value='+7 (903) 687-0254';");
        Thread.sleep(1000);
        js.executeScript("document.querySelector('body > div.mainblock > div.header > div.head_top > div > div >" +
                " div.login-popup > div.login-popup-inner > div.login-step.is-active > form > div.login-step-bottom > " +
                "div:nth-child(1) > a').click();");
        Thread.sleep(3000);
        js.executeScript("document.querySelector('body > div.mainblock > div.header > div.head_top > div > div >" +
                " div.login-popup > div.login-popup-inner > div.login-step.is-active > form >" +
                " input[type=\"password\"]:nth-child(1)').value='Test777a';");
        Thread.sleep(1000);
        js.executeScript("document.querySelector('body > div.mainblock > div.header > div.head_top > div > div > " +
                "div.login-popup > div.login-popup-inner > div.login-step.is-active > form > div >" +
                " div:nth-child(1) > a').click();");

        Thread.sleep(5000);

        String title = driver.getTitle();
        System.out.println("The page title is "+title);

       String userName = driver.findElement(By.xpath("//div[@class='sm_login_login']")).getText();
        System.out.println(userName);



    }
}
