package br.jus.tse.eleitoral.curso;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CertidaoNegativaAlistamentoEleitoralPage {

	public static final String MSG_ELEITOR_CADASTRADO = "CONSTA registro de inscrição perante a Justiça Eleitoral para os dados informados.";

	private WebDriver driver;

	public CertidaoNegativaAlistamentoEleitoralPage(WebDriver driver) {
		this.driver = driver;
	}

	public void visita() {
		String paginaInicial = "http://apps.tse.jus.br/saae/indexCertidaoNegativa.do";
		System.out.println("Página 1 [" + paginaInicial + "]");
		driver.get(paginaInicial);
		WebElement element = driver.findElement(By.name("eulicheckbox"));
		element.click();
		driver.findElement(By.name("Emissão de certidão")).click();

		System.out.println("Página 2 [" + driver.getCurrentUrl() + "]");
	}

	public void preencheDadosCertidao(String nomeEleitor, String dataNascimentoEleitor, String nomeMaeEleitor,
			String nomePaiEleitor) {
		WebElement element;
		driver.findElement(By.name("nomeEleitor")).sendKeys(nomeEleitor);
		element = driver.findElement(By.name("dataNascimento"));
		element.sendKeys(dataNascimentoEleitor);
		element.sendKeys(Keys.TAB);
		driver.findElement(By.name("nomeMae")).sendKeys(nomeMaeEleitor);
		driver.findElement(By.name("nomePai")).sendKeys(nomePaiEleitor);
	}

	/**
	 * @return <code>null</code> se emitiu certidão com sucesso, ou a mensagem
	 *         de erro exibida.
	 */
	public String submeteEmissaoCertidao() {
		driver.findElement(By.id("consultar")).submit();
		if (!driver.findElements(By.name("mensagens_anchor")).isEmpty()) {
			WebElement element = driver.findElement(By.name("mensagens_anchor"));
			if (!"".equals(element.getText())) {
				return element.getText();
			}
		}
		return null;
	}

}