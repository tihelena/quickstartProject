package com.geekbrains;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MailTest {
  private WebDriver driver;
  private WebDriverWait webDriverWait;
  @Before
  public void setUp() {
    WebDriverManager.safaridriver().setup();
    driver = new SafariDriver();
    webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void mail() {
    driver.get("https://www.podvorje.ru/");
    driver.manage().window().setSize(new Dimension(1187, 710));
    driver.findElement(By.cssSelector("i")).click();
    driver.findElement(By.linkText("Войти по email-адресу")).click();
    driver.findElement(By.name("login_mail")).sendKeys("777test77er@rambler.ru");
    driver.findElement(By.cssSelector(".login-step-bottom:nth-child(7) .btn")).click();
    webDriverWait.until(ExpectedConditions.elementToBeClickable(By.name("login_password")));
    driver.findElement(By.name("login_password")).sendKeys("Test777a");
    driver.findElement(By.cssSelector(".login-step-bottom:nth-child(6) .btn")).click();
  }
}
