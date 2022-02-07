package com.geekbrains.hw_6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.hamcrest.MatcherAssert.assertThat;



public class BasketPage extends BasePage{

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public final static String ONE_MORE_BY_XPATH = "//div[@class='basket-btn _count _more']";
    @FindBy(xpath = ONE_MORE_BY_XPATH)
    public WebElement plusOne;

    public BasketPage addOneMore() throws InterruptedException {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ONE_MORE_BY_XPATH)));
        plusOne.click();
        webDriverWait.wait(3000);
        return this;
    }

    public final static String MESSAGE_BY_XPATH = "//div[@class='table-basket-results']";
    @FindBy(xpath = MESSAGE_BY_XPATH)
    public WebElement result;

    public BasketPage checkResult() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MESSAGE_BY_XPATH)));
       String message = result.getText();
      //assertThat(message.contains("2999"));
        System.out.println(message);
        return this;
    }



}
