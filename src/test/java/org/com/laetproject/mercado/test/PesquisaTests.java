package org.com.laetproject.mercado.test;

import org.com.laetproject.mercado.pages.HomePage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

/**
 * Classe responsável pelos testes automatizados da funcionalidade de pesquisa
 * no site Mercado Livre.
 *
 * Utiliza as bibliotecas JUnit, Selenium e WebDriverManager.
 *
 * @author Gabriel Laet
 */

@DisplayName("Testes Automatizados da funcionalidade de pesquisa")
public class PesquisaTests {

    /*
    Caso o Chrome abra e feche e estoure algum erro de versão, tire o comentários do itens abaixo,
    ele vai limpar o cache do navegador e o problema será resolvido. Executar o teste para corrigir
    o problema, e comentar as linhas novamente ou apenas remove-las.
     */
    private WebDriver navegador;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
       // WebDriverManager.chromedriver().clearDriverCache().setup();
       // WebDriverManager.chromedriver().clearResolutionCache().setup();
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
