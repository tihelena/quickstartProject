package com.geekbrains.shop_flowers;

import com.geekbrains.lesson7.CustomLoggerNew;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Iterator;


@Story("Добавление товара в корзину")
public class FlowersPageObjectTest {

   WebDriver driver;
//    WebDriverWait webDriverWait;
//    Actions actions;
    private final static String SHOP_URL = "https://podvorje.ru";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.safaridriver().setup();
    }

    @BeforeEach
    void initDriver() {
//        driver = new SafariDriver();
//        driver.get(SHOP_URL);
//        driver.manage().window().maximize();
//        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        actions = new Actions(driver);
        driver = new EventFiringDecorator(new CustomLoggerNew()).decorate(new SafariDriver());
        driver.get(SHOP_URL);
        driver.manage().window().maximize();

    }

    @Test
    @Feature("Аутентификация")
    @Description("Проверка аутентификации, логин - телефон")
    void basicAuthPhone() throws InterruptedException {
        new PopUpBasicAuthPage(driver)
                .popUpAuthWithPhone()
                .checkUserName()
                .checkTitle();
    }

    @Test
    @Feature("Аутентификация")
    @Description("Проверка аутентификации, логин - email")
    void basicAuthMail() throws InterruptedException {
        new PopUpBasicAuthPage(driver)
                .popUpAuthWithMail()
                .checkUserName()
                .checkTitle();

    }

    @Test
    void addRoseToBasket() throws InterruptedException {
        new CatalogPage(driver)
                .showTopList()
                .selectFromTopList()
                .setTypeOfRoses()
                .choiceRose()
                .bayRose()
                .goToBasket()
                .addOneMore()
                .checkResult();
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
            driver.quit();
        }

}
