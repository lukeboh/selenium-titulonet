package br.jus.tse.eleitoral.curso;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteAutomatizado {
	public static void main(String[] args) {
		//System.setProperty("webdriver.firefox.bin", "/Applications/Firefox");

		WebDriver driver = 
				//new FirefoxDriver();
				//new SafariDriver();
				new ChromeDriver();
		
		String paginaInicial = "http://apps.tse.jus.br/titulonet2/paginas/requerimentoTitulo/mensagemInicial.faces";
		System.out.println("Página 1 [" + paginaInicial + "]");
		driver.get(paginaInicial);
		WebElement element = driver
				.findElement(By.id("RequerimentoAtualizacaoConfirmacaoRequerimentoForm:j_idt26"));
		element.click();
		
		System.out.println("Página 2 [" + driver.getCurrentUrl() + "]");
		Select tituloInput = new Select(driver.findElement(By.id("form:titulo_input")));
		tituloInput.selectByValue("TENHO_E_SEI");
		driver.findElement(By.id("form:numero")).sendKeys("011983892020");
		driver.findElement(By.id("form:nome")).sendKeys("Luciano Soares Bohnert");
		driver.findElement(By.id("form:dataNascimento")).sendKeys("//////////17/02/1978");
		driver.findElement(By.id("form:nomeMae")).sendKeys("Elizabeth Soares Bohnert");
		driver.findElement(By.id("form:nomePai")).sendKeys("Alcino José Bohnert");
		driver.findElement(By.id("form:confirmar")).click();

		//driver.close();
	}
}
