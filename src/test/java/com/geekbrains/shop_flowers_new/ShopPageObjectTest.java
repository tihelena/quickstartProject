package com.geekbrains.shop_flowers_new;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Iterator;

public class ShopPageObjectTest {
    WebDriver driver;
    private final static String SHOP_URL = ("https://www.podvorje.ru/");

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.safaridriver().setup();
    }
    @BeforeEach
    void initDriver() {
        driver = new EventFiringDecorator(new CustomLoggerNewSelenium()).decorate(new SafariDriver());
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10)); //без него падает
        driver.get(SHOP_URL);
    }

    @Test
    @Description("Проверка авторизации, логин - номер телефона")
    void basicAuthWithLoginAsPhone() {
        new MainPage(driver)
                .clickAuthLink()
                .setLoginAsPhone()
                .clickPhoneConfirm()
                .setPassword()
                .clickAllConfirm()
                .checkHeader()
                .checkUserName();
    }

    @Test
    @Description("Проверка авторизации, логин - почта")
    void basicAuthWithLoginAsMail() {
        new MainPage(driver)
                .clickAuthLink()
                .clickMailLink()
                .setLoginAsMail()
                .clickMailConfirm()
                .setPassword()
                .clickAllConfirm()
                .checkHeader()
                .checkUserName();

    }

    @AfterEach
    void killDriver() {
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        Iterator<LogEntry> iterator = logEntries.iterator();

        while (iterator.hasNext()) {
            Allure.addAttachment("Лог браузера:", iterator.next().getMessage());
        }

        for (LogEntry log: logEntries) {
            Allure.addAttachment("Лог браузера:", log.getMessage());
        }
        driver.quit();  //не может выйти
    }

}

