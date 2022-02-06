package com.geekbrains.lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[.='Войти']")
    private WebElement loginButton;

    @Step("Клик на кнопку логина главной страницы")
    public LoginPage clickLoginButton() {
        loginButton.click();
        return new LoginPage(driver);
    }

    @FindBy(xpath = "//a[contains(@href, 'movie')]/ancestor::div[@data-test='ITEM']")
    private List<WebElement> filmsList;

    @Step("Клик на фильм по имени")
    public MoviePage clickFilmByName(String filmName) {
        filmsList.stream().filter(f -> f.getText().contains(filmName)).findFirst().get().click();
        return new MoviePage(driver);
    }

    @FindAll({@FindBy(xpath = "//a[contains(@href, 'movie')]/ancestor::div[@data-test='ITEM']"),
            @FindBy(xpath = "//a[contains(@href, 'concert')]/ancestor::div[@data-test='ITEM']")})
    private List<WebElement> testList;

    @FindBys({
            @FindBy(xpath = "//div"),
            @FindBy(xpath = "//a")
    })
    private WebElement test;
}

