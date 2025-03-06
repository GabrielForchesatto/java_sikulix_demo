package tests.desktop;

import desktop.calculadora.actions.CalculadoraAction;
import desktop.calculadora.pages.CalculadoraPage;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import reports.ReportListener;
import tests.BaseDesktop;

import java.io.IOException;

public class CalculadoraWindowsTest extends BaseDesktop {

    protected static final String VALOR_1 = "1";
    protected static final String VALOR_2 = "2";
    protected static final String VALOR_3 = "3";
    protected static final String VALOR_4 = "4";

    @BeforeClass
    public static void abrirAplicacao() throws FindFailed {
        CalculadoraAction.abrirCalculadora();
        CalculadoraAction.maximizarCalculadora();
    }

    @AfterClass
    public static void fecharAplicacao() {
        CalculadoraAction.fecharCalculadora();
    }

    @AfterMethod
    public static void limparValores() throws FindFailed {
        CalculadoraAction.limparValores();
    }

    @Test
    public static void deveraSomarDoisValoresCorretamente() throws FindFailed, IOException {
        CalculadoraAction.somarValores(VALOR_1, VALOR_2);

        Assert.assertEquals(CalculadoraAction.resultadoGetText(), "3");
        ReportListener.logScreenshotHighlightDesktop("Resultado da soma", -40, 30, -1550, -270, CalculadoraPage.padraoLabel());
    }

    @Test
    public static void deveraSomarQuatroValoresCorretamente() throws FindFailed, IOException {
        CalculadoraAction.somarValores(VALOR_1, VALOR_2, VALOR_3, VALOR_4);

        Assert.assertEquals(CalculadoraAction.resultadoGetText(), "10");
        ReportListener.logScreenshotHighlightDesktop("Resultado da soma", -40, 30, -1550, -270, CalculadoraPage.padraoLabel());
    }

}