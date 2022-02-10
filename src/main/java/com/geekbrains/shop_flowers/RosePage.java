package com.geekbrains.shop_flowers;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RosePage extends BasePage{

    public RosePage(WebDriver driver) {
        super(driver);
    }

    public final static String FAVORITE_OF_ROSES_BY_XPATH = "//div[@class='list list-tile']//a[.='Роза Квиксильвер']";
    @FindBy(xpath = FAVORITE_OF_ROSES_BY_XPATH)
    public WebElement favorOfRoses;

    @Step("Выбор конкретного товара")
    public FavoriteRosePage choiceRose() {

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FAVORITE_OF_ROSES_BY_XPATH)));
        favorOfRoses.click();
        return new FavoriteRosePage(driver);
    }



}
