
# 🚀 Testes Automatizados - Pesquisa no Mercado Livre  

Esse pequeno projeto contém testes automatizados desenvolvidos para validar a funcionalidade de pesquisa no site [Mercado Livre](https://www.mercadolivre.com.br/). Os testes foram criados utilizando **JUnit**, **Selenium** e a biblioteca **WebDriver**.

---

## 🛠️ Tecnologias Utilizadas  

- **Java**.
- **JUnit 5**.
- **Selenium**: Biblioteca para automação de navegadores.  
- **WebDriverManager**: Gerenciador automático de drivers de navegador.  

---

## ⚙️ Como Executar os Testes  

### Pré-requisitos  

1. Recomendo fortemente o **Intellj IDEA**
2. Apenas o **Google Chrome** :)

### Passos  

1. Clone o repositório para sua máquina local:
   ```bash
   git clone https://github.com/laetgabriel/projeto-klok.git
   cd projeto-klok
   ```

2. Abra o projeto no Intellj IDEA

---
### Tratativa de Erros Comuns no WebDriver

Em alguns casos, o Chrome pode abrir e fechar imediatamente, estourando erros relacionados à versão do WebDriver. Para resolver isso, é possível limpar o cache do driver e a resolução usando os métodos fornecidos pelo `WebDriverManager`.

Basta descomentar as linhas indicadas no método `setUp` que se encontra na classe `PesquisaTests`.


## 📋 Testes Implementados  

### 1️⃣ **Testes com Dados Válidos**  
Testa a pesquisa com uma palavra válida, como *"cadeira ergonomica"*, para verificar se existem resultados correspondentes.

- Método: `testPesquisaComDadosValidos`  
- Resultado esperado: Um texto retornando resultados da pesquisa.  

---

### 2️⃣ **Testes com Dados Inválidos**  
Testa a pesquisa com uma palavra inválida, como *"kdsaoks"*, para verificar se a mensagem de "Não há anúncios que correspondam à sua busca" é exibida.  

- Método: `testPesquisaComDadosInvalidos`  
- Resultado esperado: Mensagem indicando que não há resultados.  

---

## 🔧 Detalhes das Classes  

### **1. `BasePage`**  
- Configura os elementos das páginas com o Selenium.  
- Responsável por inicializar os elementos das classes que estendem a `BasePage`.

### **2. `HomePage`**  
- Representa a página inicial do Mercado Livre.  
- Métodos principais:
  - `acessarPaginaHomeMercadoLivre`: Acessa a URL principal.  
  - `inserirPesquisaMercadoLivre`: Insere o texto no campo de pesquisa.  
  - `fazerPesquisaMercadoLivre`: Executa a pesquisa clicando no botão.

### **3. `SearchPage`**  
- Representa a página de resultados de pesquisa.  
- Métodos principais:
  - `obterResultadoPesquisaValida`: Obtém o texto do resultado em caso de pesquisa válida.  
  - `obterResultadoPesquisaInvalida`: Obtém a mensagem exibida quando não há resultados.  

### **4. `PesquisaTests`**  
- Contém os testes automatizados utilizando JUnit 5.  
- Configuração:
  - `@BeforeEach`: Inicializa o navegador antes de cada teste.  
  - `@AfterEach`: Fecha o navegador após cada teste.  

---

## 💼 Sobre a Vaga  

Esse projeto foi desenvolvido como parte do processo seletivo para a vaga de estágio QA na empresa **Klok Tech**. Ele demonstra habilidades de automação de testes, boas práticas em programação e uso das ferramentas Selenium e JUnit.

---

## 📞 Contato  

- **LinkedIn:** [Meu LinkedIn](https://www.linkedin.com/in/gabriel-laet-53a865264/)  
- **Email:** gabriellaetfm12@gmail.com 
