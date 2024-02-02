package pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DaskbordingPage {

	WebDriver driver;

	@FindBy(xpath = "//img[@alt='Test.allTheThings() T-Shirt (Red)']//following::div[5]//button")
	WebElement btnaddcardcamisa;

	@FindBy(xpath = "//div[text()='Sauce Labs Backpack']//following::div[2]//button[text()='Add to cart']")
	WebElement btnaddcardbolsa;

	@FindBy(xpath = "(//div[@class='inventory_item_description']//button)[1]")
	WebElement btnprimeiroproduto;

	@FindBy(xpath = "(//div[@class='inventory_item_description']//button)[2]")
	WebElement btnsegundoproduto;

	@FindBy(xpath = "//span[text()='Products']")
	WebElement titlevalidate;

	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	WebElement btncarrinho;

	@FindBy(xpath = "//select[@class='product_sort_container']")
	WebElement filtroselect;

	public DaskbordingPage(WebDriver driver) throws IOException {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void validandoAcesso() {
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfAllElements(titlevalidate));
	}

	public void clickAddCardCamisa() {
		btnaddcardcamisa.click();
	}

	public void clickAddCardbolsa() {
		btnaddcardcamisa.click();
	}

	public void clickCarrinho() {
		btncarrinho.click();
	}

	public void addPrimeiroPorduto() {
		btnprimeiroproduto.click();
	}

	public void addSegundoPorduto() {
		btnsegundoproduto.click();
	}

	public void addCamisaCarrinho() throws IOException {
		validandoAcesso();
		clickAddCardCamisa();
	}

	public void addBolsaCarrinho() throws IOException {
		validandoAcesso();
		clickAddCardbolsa();
	}

	public void acessarCarrinho() {
		clickCarrinho();
	}

	public void selecionarMenorpreco() {
		validandoAcesso();
		String precomenor = "Price (low to high)";
		Select select = new Select(filtroselect);
		select.selectByVisibleText(precomenor);
	}

	public void addProdutoPrecoMenor() throws IOException {
		addPrimeiroPorduto();
		addSegundoPorduto();
	}

}
