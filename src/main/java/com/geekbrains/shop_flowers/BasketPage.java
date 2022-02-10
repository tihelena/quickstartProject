package com.geekbrains.shop_flowers;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.junit.Assert.assertEquals;



public class BasketPage extends BasePage{

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public final static String ONE_MORE_BY_XPATH = "//div[@class='basket-btn _count _more']";
    @FindBy(xpath = ONE_MORE_BY_XPATH)
    public WebElement plusOne;

    @Step("Добавление еще одного товара в корзину")
    public BasketPage addOneMore() throws InterruptedException {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ONE_MORE_BY_XPATH)));
        plusOne.click();
        Thread.sleep(3000);
        return this;
    }

    public final static String MESSAGE_BY_XPATH = "//div[@class='table-basket-results']";
    @FindBy(xpath = MESSAGE_BY_XPATH)
    public WebElement result;

    @Step("Проверка количества товара в корзине")
    public BasketPage checkResult() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MESSAGE_BY_XPATH)));
        String message = result.getText();
        assertEquals(true, message.contains("Всего в корзине 2 товара"));
        System.out.println(message);
        return this;
    }

}
