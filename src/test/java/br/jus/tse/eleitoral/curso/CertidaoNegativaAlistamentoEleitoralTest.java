package br.jus.tse.eleitoral.curso;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CertidaoNegativaAlistamentoEleitoralTest {

	@Test
	public void caminhoFeliz() {

		WebDriver driver = new ChromeDriver();

		String paginaInicial = "http://apps.tse.jus.br/saae/indexCertidaoNegativa.do";
		System.out.println("Página 1 [" + paginaInicial + "]");
		driver.get(paginaInicial);
		WebElement element = driver.findElement(By.name("eulicheckbox"));
		element.click();
		driver.findElement(By.name("Emissão de certidão")).click();

		System.out.println("Página 2 [" + driver.getCurrentUrl() + "]");
		driver.findElement(By.name("nomeEleitor")).sendKeys("Luciano Soares Bohnert");
		element = driver.findElement(By.name("dataNascimento"));
		element.sendKeys("17/02/1978");
		element.sendKeys(Keys.TAB);
		driver.findElement(By.name("nomeMae")).sendKeys("Elizabeth Soares Bohnert");
		driver.findElement(By.name("nomePai")).sendKeys("Alcino José Bohnert");
		driver.findElement(By.id("consultar")).submit();

		driver.close();
	}
}
