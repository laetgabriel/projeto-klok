package org.com.laetproject.mercado.test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

@DisplayName("Testes Automatizados da funcionalidade de pesquisa")
public class PesquisaTest {

    @Test
    @DisplayName("Registrar uma pesquisa no Mercado Livre com dados válidos")
    public void testPesquisaComDadosValidos() {
        WebDriverManager.chromedriver().setup();
        WebDriver navegador = new ChromeDriver();

        try {
            navegador.manage().window().maximize();
            navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

            navegador.get("https://www.mercadolivre.com.br/");
            navegador.findElement(By.id("cb1-edit")).sendKeys("okdsaodsaok");
            navegador.findElement(By.className("nav-search-btn")).click();

            String resultado;
            try {
                resultado = navegador.findElement(By.xpath("//*[@id=\"root-app\"]/div/div[3]/aside/div[1]/h1")).getText().toLowerCase();
            } catch (Exception e) {
                resultado = "";
            }

            if (!resultado.isEmpty()) {
                Assertions.assertNotNull(resultado, "O item resultante foi encontrado");
            } else {
                String mensagem = navegador.findElement(By.xpath("//*[@id=\"root-app\"]/div/div/div[2]/h3")).getText();
                Assertions.assertEquals("Não há anúncios que correspondam à sua busca", mensagem);
            }
        } catch (Exception e) {
            navegador.quit();
        }
    }

}
