package sikulix.calculadora.actions;

import org.sikuli.script.FindFailed;
import sikulix.calculadora.pages.CalculadoraPage;

import java.io.IOException;

public class CalculadoraAction extends CalculadoraPage {

    private static Process process;

    public static void abrirCalculadora() throws FindFailed {
        try {
            process = Runtime.getRuntime().exec("C:\\Windows\\SysWOW64\\calc.exe\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void maximizarCalculadora() throws FindFailed {
        calculadoraLabelWait();
        if (appMinimizadoExists() != null) {
            screen.doubleClick(calculadoraLabel());
        }
    }

    public static void fecharCalculadora() {
        try {
            Runtime.getRuntime().exec("taskkill /F /IM CalculatorApp.exe");
            System.out.println("Processo da calculadora encerrado.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void somarValores(String... valores) throws FindFailed {
        maisButtonWait();
        for (String valor : valores) {
            numerosSendKeys(valor);
            screen.click(maisButton());
        }
    }

    public static void limparValores() throws FindFailed {
        screen.click(limparValoresButton());
    }

}
