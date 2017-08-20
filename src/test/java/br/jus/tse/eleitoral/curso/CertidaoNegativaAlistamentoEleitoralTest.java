package br.jus.tse.eleitoral.curso;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CertidaoNegativaAlistamentoEleitoralTest {

	private CertidaoNegativaAlistamentoEleitoralPage page;
	private WebDriver driver;

	@Before
	public void inicializa() {
		driver = new ChromeDriver();
		page = new CertidaoNegativaAlistamentoEleitoralPage(driver);
	}

	@Test
	public void naoEmiteEleitorExistente() {
		page.visita();
		page.preencheDadosCertidao("Luciano Soares Bohnert", "17/02/1978", "Elizabeth Soares Bohnert",
				"Alcino José Bohnert");
		String retorno = page.submeteEmissaoCertidao();
		Assert.assertEquals(CertidaoNegativaAlistamentoEleitoralPage.MSG_ELEITOR_CADASTRADO, retorno);
	}
	
	@Test
	public void emiteEleitorInexistente() {
		page.visita();
		page.preencheDadosCertidao("Luciano Soares Bohnert Wayne", "17/02/1928", "Elizabeth Soares Bohnert Wayne",
				"Alcino José Bohnert Wayne");
		String retorno = page.submeteEmissaoCertidao();
		Assert.assertNull(retorno);
	}

	@After
	public void finaliza() {
		driver.close();
	}
}
