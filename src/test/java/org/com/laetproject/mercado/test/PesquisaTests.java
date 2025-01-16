package org.com.laetproject.mercado.test;

import org.com.laetproject.mercado.pages.HomePage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

@DisplayName("Testes Automatizados da funcionalidade de pesquisa")
public class PesquisaTests {

    private WebDriver navegador;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        navegador = new ChromeDriver();
        navegador.manage().window().maximize();
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
    }

    @Test
    @DisplayName("Fazer uma pesquisa no Mercado Livre com dados válidos")
    public void testPesquisaComDadosValidos() {
        String resultado = new HomePage(navegador)
                .acessarPaginaHomeMercadoLivre()
                .inserirPesquisaMercadoLivre("cadeira ergonomica")
                .fazerPesquisaMercadoLivre()
                .obterResultadoPesquisaValida();

        Assertions.assertNotNull(resultado, "O item resultante foi encontrado");

    }

    @Test
    @DisplayName("Fazer uma pesquisa no Mercado Livre com dados inválidos")
    public void testPesquisaComDadosInvalidos() {
        String resultado = new HomePage(navegador)
                .acessarPaginaHomeMercadoLivre()
                .inserirPesquisaMercadoLivre("kdsaoks")
                .fazerPesquisaMercadoLivre()
                .obterResultadoPesquisaInvalida();

        Assertions.assertEquals("Não há anúncios que correspondam à sua busca", resultado);


    }

    @AfterEach
    public void tearDown() {
        navegador.quit();
    }
}
