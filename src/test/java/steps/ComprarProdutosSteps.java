package steps;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CarrinhoPage;
import pages.DaskbordingPage;
import pages.LoginPage;

public class ComprarProdutosSteps {
	private WebDriver driver;
	LoginPage loginpage;
	DaskbordingPage daskbording;
	CarrinhoPage carrinho;

	public ComprarProdutosSteps() throws IOException {

		this.driver = new ChromeDriver();
		loginpage = new LoginPage(driver);
		daskbording = new DaskbordingPage(driver);
		carrinho = new CarrinhoPage(driver);

	}

	@Given("Que eu esteja logado no sistema saucedemo")
	public void que_eu_esteja_logado_no_sistema_saucedemo() throws IOException {

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.saucedemo.com/");

		String username = "standard_user";
		String password = "secret_sauce";

		loginpage.preencherLogin(username, password);
	}

	@When("coloco a camisa vermelha no carrinho")
	public void coloco_a_camisa_vermelha_no_carrinho() throws IOException {

		daskbording.addCamisaCarrinho();
	}

	@And("preencho as informações para finalizar compra")
	public void preencho_as_informações_para_finalizar_compra() throws IOException {

		String firstname = "mario";
		String lastname = "jose";
		String zippostcod = "06730000";

		daskbording.acessarCarrinho();
		carrinho.validarProdutonoCarrinho();
		carrinho.clickcheckout();
		carrinho.preencherInformacoesUsuario(firstname, lastname, zippostcod);
		carrinho.clicarcontinue();
		carrinho.validarInformacoesVisivel();
		carrinho.clickFinish();
	}

	@Then("valido se a compra foi feita com sucesso")
	public void valido_se_a_compra_foi_feita_com_sucesso() throws IOException {
		carrinho.finalizarCompraValidacao();
		driver.quit();
	}

	@When("coloco a bolsa no carrinho")
	public void coloco_a_bolsa_no_carrinho() throws IOException {
		daskbording.addBolsaCarrinho();
	}

	@When("adiciono produtos no carrinho com preço menor")
	public void ordeno_os_valores_do_menor_para_o_maior() throws IOException {
		daskbording.selecionarMenorpreco();
		daskbording.addProdutoPrecoMenor();
	}

}
