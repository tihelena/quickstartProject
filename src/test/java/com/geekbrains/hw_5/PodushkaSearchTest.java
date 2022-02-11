package com.geekbrains.hw_5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;


public class PodushkaSearchTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;
    private final static String URL = "https://podushka.ru";
    private static Logger logger = LoggerFactory.getLogger("PodushkaTest.class");

    @BeforeAll
    static void beforeAll() {
        logger.info("log data");
        logger.trace("trace log data");
        logger.error("err log data");
        WebDriverManager.safaridriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new SafariDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.get(URL);
        actions.moveToElement(driver.findElement(By.xpath("//header//span[@data-aq-search]")))
                .click()
                .build()
                .perform();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input")));
    }

    @Test
    @DisplayName("Поиск по категории товара")
    void searchCategoryItem() {

        By.cssSelector("input").findElement(driver)
                .sendKeys("одеяло");
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article[@data-aq-product-card]" +
                "//a//div[contains(@class, 'text-black-100')]")));

        List<WebElement> divs = driver.findElements(By.xpath("//article[@data-aq-product-card]" +
                "//a//div[contains(@class, 'text-black-100')]"));
        int size = divs.size();
        assertThat(size != 0);

        for(WebElement div:divs){
            String text =div.getText();
            System.out.println(text);
            assertThat(text.contains("Одеяло") || text.contains("одеяло"));
        }

    }
    @Test
    @DisplayName("Пустой запрос в строке поиска")
    void searchEmptyQuery() {
        By.cssSelector("input").findElement(driver)
                .sendKeys("       ");
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3")));
        String answer =
        driver.findElement(By.cssSelector("h3")).getText();
        assertThat(answer.contains("Ничего не найдено"));

    }

    @Test
    @DisplayName("Поиск несуществующего товара")
    void searchNotExistingItem() {
        By.cssSelector("input").findElement(driver)
                .sendKeys("самолет");
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3")));
        String answer =
                driver.findElement(By.cssSelector("h3")).getText();
        assertThat(answer.contains("Ничего не найдено"));

    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}