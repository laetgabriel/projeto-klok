package org.com.laetproject.mercado.test;

import org.com.laetproject.mercado.pages.HomePage;
import org.com.laetproject.mercado.pages.SearchPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

@DisplayName("Testes Automatizados da funcionalidade de pesquisa")
public class PesquisaTest {

    private WebDriver navegador;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        navegador = new ChromeDriver();
        navegador.manage().window().maximize();
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
    }

    @Test
    @DisplayName("Registrar uma pesquisa no Mercado Livre com dados válidos")
    public void testPesquisaComDadosValidos() {
        try {

            HomePage homePage = new HomePage(navegador);
            homePage.acessarPaginaHomeMercadoLivre();
            homePage.inserirPesquisaMercadoLivre("cadeira ergonomica");
            homePage.fazerPesquisaMercadoLivre();


            SearchPage searchPage = new SearchPage(navegador);
            String resultado = searchPage.obterResultadoPesquisaValida();
            Assertions.assertNotNull(resultado, "O item resultante foi encontrado");

        } catch (Exception e) {
            navegador.quit();
        }
    }

    @Test
    @DisplayName("Registrar uma pesquisa no Mercado Livre com dados inválidos")
    public void testPesquisaComDadosInvalidos() {
        WebDriverManager.chromedriver().setup();
        WebDriver navegador = new ChromeDriver();
        try {
            navegador.manage().window().maximize();
            navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

            HomePage homePage = new HomePage(navegador);
            homePage.acessarPaginaHomeMercadoLivre();
            homePage.inserirPesquisaMercadoLivre("okdsaokdak");
            homePage.fazerPesquisaMercadoLivre();
            SearchPage searchPage = new SearchPage(navegador);
            String mensagem = searchPage.obterResultadoPesquisaInvalida();

            Assertions.assertEquals("Não há anúncios que correspondam à sua busca", mensagem);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @AfterEach
    public void tearDown() {
        navegador.quit();
    }
}
