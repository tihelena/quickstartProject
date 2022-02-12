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


public class PhoneTest {
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
  public void ath() throws InterruptedException {
    driver.get("https://www.podvorje.ru/");
    driver.manage().window().setSize(new Dimension(1187, 710));
    driver.findElement(By.cssSelector("i")).click();
    driver.findElement(By.id("login-phone")).sendKeys("903 687-0254");
    webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".login-step-bottom:nth-child(9) .btn")));
    driver.findElement(By.cssSelector(".login-step-bottom:nth-child(9) .btn")).click();
    webDriverWait.until(ExpectedConditions.elementToBeClickable(By.name("login_password")));
    driver.findElement(By.name("login_password")).sendKeys("Test777a");
    webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".login-step-bottom:nth-child(6) .btn")));
    driver.findElement(By.cssSelector(".login-step-bottom:nth-child(6) .btn")).click();
    Thread.sleep(3000);
  }
}
