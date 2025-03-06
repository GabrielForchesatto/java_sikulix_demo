package tests.web;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import reports.ReportListener;
import tests.BaseWeb;
import utils.PropertiesUtils;
import web.DriverManager;
import web.calculadora.actions.CalculadoraWebAction;
import web.calculadora.page.CalculadoraWebPage;
import web.google.actions.GoogleAction;

import java.io.IOException;

public class CalculadoraGoogleTest extends BaseWeb {

    protected static CalculadoraWebAction calculadoraWebAction;
    protected static CalculadoraWebPage calculadoraWebPage;
    protected static GoogleAction googleAction;

    protected static final String VALOR_1 = "1";
    protected static final String VALOR_2 = "2";
    protected static final String VALOR_3 = "3";
    protected static final String VALOR_4 = "4";


    @BeforeClass
    public static void acessarCalculadoraWeb() throws IOException, InterruptedException {
        driver = DriverManager.getChromeDriver();
        driver.get(PropertiesUtils.getProperty("google.url"));
        googleAction = new GoogleAction(driver);
        calculadoraWebAction = new CalculadoraWebAction(driver);
        calculadoraWebPage = new CalculadoraWebPage(driver);

        googleAction.realizarPesquisa("Calculadora");

    }

    @AfterMethod
    public static void limparValores() {
        calculadoraWebPage.limparTudoButton().click();
    }

    @Test
    public static void deveraSomarDoisValoresCorretamente() throws InterruptedException, IOException {
        calculadoraWebAction.somarNumeros(VALOR_1, VALOR_2);

        Assert.assertEquals(calculadoraWebPage.numerosTextfield().getText(), "3");
        ReportListener.logScreenshotHighlightWeb("Resultado Operação", driver, calculadoraWebPage.resultadoTextfield());
    }

    @Test
    public static void deveraSomarQuatroValoresCorretamente() throws InterruptedException, IOException {
        calculadoraWebAction.somarNumeros(VALOR_1, VALOR_2, VALOR_3, VALOR_4);

        Assert.assertEquals(calculadoraWebPage.numerosTextfield().getText(), "10");
        ReportListener.logScreenshotHighlightWeb("Resultado Operação", driver, calculadoraWebPage.resultadoTextfield());
    }

}
