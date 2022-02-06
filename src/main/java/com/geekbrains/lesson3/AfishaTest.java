package com.geekbrains.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class AfishaTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--headless");
//        System.out.println(Integer.parseInt("14"));
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
        driver.get("https://afisha.ru");
        //WebDriverWait webDriverWait = new WebDriverWait(driver, 5); //Selenium3
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //WebElement loginButton = driver.findElement(By.xpath("//button[.='Войти']"));
        //loginButton.click();
        driver.findElement(By.xpath("//button[.='Войти']")).click();
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src, 'login')]")));
        //driver.switchTo().parentFrame(); - если фрейм не закрылся как тут, надо самому вернуться назад
        //Thread.sleep(5000);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
        driver.findElement(By.id("login")).sendKeys("spartalex1993");
        driver.findElement(By.id("password")).sendKeys("Test4test");
        webDriverWait.until(d -> d.findElement(By.id("login")).getAttribute("value").contains("@rambler"));
        //Thread.sleep(1000);//сложно разобраться
        driver.findElement(By.xpath("//span[.='Войти']/..")).click();
        Thread.sleep(20000);
        //driver.switchTo().parentFrame();

        List<WebElement> filmsList = driver.findElements(By.xpath("//a[contains(@href, 'movie')]/ancestor::div[@data-test='ITEM']"));
        filmsList.stream().filter(f -> f.getText().contains("Человек-паук")).findFirst().get().click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-test='PAGE-SECTION TITLE-SECTION']//button[@data-test='BUTTON FAVORITE']")));
        driver.findElement(By.xpath("//section[@data-test='PAGE-SECTION TITLE-SECTION']//button[@data-test='BUTTON FAVORITE']")).click();
        Thread.sleep(5000);
        driver.quit();
    }
}
