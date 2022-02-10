package com.geekbrains.shop_flowers;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.junit.Assert.assertTrue;

public class CatalogPage extends BasePage{

    public CatalogPage(WebDriver driver) {
        super(driver);
    }


    public final static String USER_NAME_BY_XPATH = "//div[@class='sm_login_login']";
    @FindBy(xpath = USER_NAME_BY_XPATH)
    public WebElement user;

    @Step("Проверка имени пользователя ")
    public CatalogPage checkUserName() {
        String userName = user.getText();
        assertTrue(userName.contains("Елена"));
        return this;
    }

    @FindBy(xpath = "//title")
    public WebElement title;

    @Step("Проверка текста титла страницы")
    public CatalogPage checkTitle() {
        String textTitle = title.getText();
        assertTrue(textTitle.contains("Подворье"));
        return this;
    }

    @FindBy(xpath = "//div[@data-catalog='cat']")
    public WebElement catalog;

    @Step("Клик на кнопку Каталог на главной странице")
    public CatalogPage showTopList() {
        catalog.click();
        return this;
    }

    public final static String SELECT_ROSES_BY_XPATH = "//a[@href='/retail/catalogue/roses/index.html']//img[@src='/img/logos/_s50/rose.png']";
    @FindBy(xpath = SELECT_ROSES_BY_XPATH )
    public WebElement roses;

    @Step("Выбор категории товара из выпадающего списка каталога")
    public CatalogPage selectFromTopList() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SELECT_ROSES_BY_XPATH)));
        roses.click();

        return this;
    }

    public final static String SELECT_TYPE_OF_ROSES_BY_XPATH = "//a[@href='/retail/catalogue/roses/climbing.html']";
    @FindBy(xpath = SELECT_TYPE_OF_ROSES_BY_XPATH)
    public WebElement typeOfRoses;

    @Step("Выбор типа товара из категории")
    public RosePage setTypeOfRoses() throws InterruptedException {
        Thread.sleep(3000);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SELECT_TYPE_OF_ROSES_BY_XPATH)));
        typeOfRoses.click();
        return new RosePage(driver);


    }
}
