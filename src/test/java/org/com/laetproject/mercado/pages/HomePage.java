package org.com.laetproject.mercado.pages;

import org.com.laetproject.mercado.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    private final static String URL = "https://www.mercadolivre.com.br/";

    @FindBy(id = "cb1-edit")
    private WebElement campoPesquisaElement;

    @FindBy(className ="nav-search-btn")
    private WebElement botaoPesquisaElement;

    public HomePage(WebDriver navegador) {
        super(navegador);
    }

    public HomePage acessarPaginaHomeMercadoLivre() {
        navegador.get(URL);
        return this;
    }

    public HomePage inserirPesquisaMercadoLivre(String pesquisa){
        campoPesquisaElement.sendKeys(pesquisa);
        return this;
    }

    public SearchPage fazerPesquisaMercadoLivre(){
        botaoPesquisaElement.click();
        return new SearchPage(navegador);
    }
}

