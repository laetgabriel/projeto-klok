package org.com.laetproject.mercado.pages;

import org.com.laetproject.mercado.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"root-app\"]/div/div[3]/aside/div[1]/h1")
    private WebElement tituloResultadoPesquisaValidaElement;
    @FindBy(xpath = "//*[@id=\"root-app\"]/div/div[3]/aside/div[1]/h1")
    private WebElement tituloResultadoPesquisaInvalidaElement;

    public SearchPage(WebDriver navegador) {
        super(navegador);
    }

    public String obterResultadoPesquisaValida(){
        return tituloResultadoPesquisaValidaElement.getText();
    }
    public String obterResultadoPesquisaInvalida(){
        return tituloResultadoPesquisaInvalidaElement.getText();
    }
}
