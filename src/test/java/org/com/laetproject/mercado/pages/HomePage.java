package org.com.laetproject.mercado.pages;

import org.com.laetproject.mercado.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final static String URL = "https://www.mercadolivre.com.br/";
    private final By campoPesquisa = By.id("cb1-edit");
    private final By botaoPesquisa = By.className("nav-search-btn");

    public HomePage(WebDriver navegador) {
        super(navegador);
    }

    public void acessarPaginaHomeMercadoLivre() {
        navegador.get(URL);
    }

    public void inserirPesquisaMercadoLivre(String pesquisa){
        navegador.findElement(campoPesquisa).sendKeys(pesquisa);
    }

    public void fazerPesquisaMercadoLivre(){
        navegador.findElement(botaoPesquisa).click();
    }
}

