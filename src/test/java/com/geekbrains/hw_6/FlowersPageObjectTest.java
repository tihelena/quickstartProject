package com.geekbrains.hw_6;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class FlowersPageObjectTest {

    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;
    private final static String SHOP_URL = "https://podvorje.ru";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.safaridriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new SafariDriver();
        driver.get(SHOP_URL);
        driver.manage().window().maximize();
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
    }

    @Test
    void basicAuth() throws InterruptedException {
        new PopUpBasicAuthPage(driver)
                .popUpAuth()
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
    void tearDown() {
        driver.quit();
    }
}
