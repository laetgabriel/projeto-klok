package org.com.laetproject.mercado.pages;

import org.com.laetproject.mercado.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {

    private final By resultadoPesquisaValida = By.xpath("//*[@id=\"root-app\"]/div/div[3]/aside/div[1]/h1");
    private final By resultadoPesquisaInvalida = By.xpath("//*[@id=\"root-app\"]/div/div[3]/aside/div[1]/h3");
    public SearchPage(WebDriver navegador) {
        super(navegador);
    }

    public String obterResultadoPesquisaValida(){
        return navegador.findElement(resultadoPesquisaValida).getText();
    }
    public String obterResultadoPesquisaInvalida(){
        return navegador.findElement(resultadoPesquisaInvalida).getText();
    }
}
