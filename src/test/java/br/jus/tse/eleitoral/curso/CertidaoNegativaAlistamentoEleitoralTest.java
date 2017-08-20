package br.jus.tse.eleitoral.curso;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CertidaoNegativaAlistamentoEleitoralTest {

	private static final String MSG_ELEITOR_CADASTRADO = "CONSTA registro de inscrição perante a Justiça Eleitoral para os dados informados.";
	private WebDriver driver;

	@Test
	public void caminhoFeliz() {
		driver = new ChromeDriver();
		visita();
		preencheDadosCertidao("Luciano Soares Bohnert", "17/02/1978", "Elizabeth Soares Bohnert",
				"Alcino José Bohnert");
		String retorno = submeteEmissaoCertidao();
		Assert.assertNotNull("Está emitindo certidão negativa de alistamento para eleitor cadastrado", retorno);
		Assert.assertTrue("Mensagem incorreta", retorno.contains(MSG_ELEITOR_CADASTRADO));
		// driver.close();
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
		WebElement element;
		element = driver.findElement(By.name("mensagens_anchor"));
		if (!"".equals(element.getText())) {
			return element.getText();
		}
		return null;
	}
}
