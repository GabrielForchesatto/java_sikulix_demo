package tests.sikulix;

import org.sikuli.script.FindFailed;
import org.testng.Assert;
import org.testng.annotations.Test;
import reports.ReportListener;
import sikulix.calculadora.actions.CalculadoraAction;
import sikulix.calculadora.pages.CalculadoraPage;
import tests.BaseSikulix;

import java.io.IOException;

public class CalculadoraTest extends BaseSikulix {

    protected static final String VALOR_1 = "1";
    protected static final String VALOR_2 = "2";

    @Test
    public static void deveraSomarDoisValoresCorretamente() throws FindFailed, IOException {
        CalculadoraAction.abrirCalculadora();
        CalculadoraAction.maximizarCalculadora();
        CalculadoraAction.somarValores(VALOR_1, VALOR_2);

        Assert.assertEquals(CalculadoraAction.resultadoGetText(), "3");
        ReportListener.logScreenshotHighlightSikulix("Resultado da soma", -40, 30, -1550, -270, CalculadoraPage.padraoLabel());

        CalculadoraAction.fecharCalculadora();
    }
}
