package br.jus.tse.eleitoral.curso;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteAutomatizado {
	public static void main(String[] args) {
		//System.setProperty("webdriver.firefox.bin", "/Applications/Firefox");

		WebDriver driver = 
				//new FirefoxDriver();
				//new SafariDriver();
				new ChromeDriver();

		driver.get("http://apps.tse.jus.br/titulonet2/paginas/requerimentoTitulo/mensagemInicial.faces");

		WebElement botaoProximo = driver
				.findElement(By.id("RequerimentoAtualizacaoConfirmacaoRequerimentoForm:j_idt26"));

		botaoProximo.click();
	}
}
