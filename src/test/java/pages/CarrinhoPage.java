package pages;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CarrinhoPage {

	WebDriver driver;

	@FindBy(xpath = "//div[@class='cart_item']")
	WebElement produtocarrinho;

	@FindBy(id = "checkout")
	WebElement btnckeckout;

	@FindBy(id = "first-name")
	WebElement txtfirtname;

	@FindBy(id = "last-name")
	WebElement txtlastname;

	@FindBy(id = "postal-code")
	WebElement txtpostalcode;

	@FindBy(id = "continue")
	WebElement btncontinue;

	@FindBy(id = "login-//div[@class='header_secondary_container']//span")
	WebElement txttitleinformation;

	@FindBy(xpath = "//div[@class='summary_info']")
	WebElement infooverview;

	@FindBy(xpath = "//div[@class='complete-text']")
	WebElement txtfinalizarcompra;

	@FindBy(id = "finish")
	WebElement btnfinish;

	public CarrinhoPage(WebDriver driver) throws IOException {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void validarProdutonoCarrinho() {

		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfAllElements(produtocarrinho));
	}

	public void clickcheckout() {
		btnckeckout.click();
	}

	public void preencherFirstName(String firstname) {
		txtfirtname.sendKeys(firstname);
	}

	public void preencherLastName(String lastname) {
		txtlastname.sendKeys(lastname);
	}

	public void preencherZipCode(String zipCode) {
		txtpostalcode.sendKeys(zipCode);
	}

	public void clicarcontinue() {
		btncontinue.click();
	}

	public void clickFinish() {
		btnfinish.click();
	}

	public void finalizarCompraValidacao() throws IOException {
		String expectativa = "Your order has been dispatched, and will arrive just as fast as the pony can get there!";
		String atual = txtfinalizarcompra.getText();
		assertEquals(expectativa, atual);
	}

	public void validartitulopaginaInformacoes() {
		String txtTitleInformacoes = "Checkout: Your Information";

		String txtatual = txttitleinformation.getText();

		assertEquals(txtTitleInformacoes, txtatual);
	}

	public void validarInformacoesVisivel() {

		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfAllElements(infooverview));

	}

	public void preencherInformacoesUsuario(String firstname, String lastname, String zipcode) throws IOException {
		preencherFirstName(firstname);
		preencherLastName(lastname);
		preencherZipCode(zipcode);
	}

}
