package com.geekbrains;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PodushkaCheck {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        WebDriverWait webDriverWait;
        Actions actions;
        final String URL = "https://podushka.ru";

        WebDriverManager.safaridriver().setup();
        driver = new SafariDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.get(URL);
        actions.moveToElement(driver.findElement(By.xpath("//header//span[@data-aq-search]")))
                .click()
                .build()
                .perform();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input")));


        By.cssSelector("input").findElement(driver)
                .sendKeys("одеяло");
        Thread.sleep(5000);

        List<WebElement> divs = driver.findElements(By.xpath("//article[@data-aq-product-card]" +
                "//a//div[contains(@class, 'text-black-100')]"));
        System.out.println(divs.size());


        for(WebElement div:divs) {
            String text = div.getText();
            System.out.println(text);
        }
        driver.quit();
        }

    }



