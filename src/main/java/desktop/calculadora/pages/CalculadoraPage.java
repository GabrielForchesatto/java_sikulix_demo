package desktop.calculadora.pages;

import desktop.BaseScreen;
import org.sikuli.script.*;

public class CalculadoraPage extends BaseScreen {


    public static Pattern calculadoraLabel() {
        return new Pattern(BASE_PATH_CALCULADORA + "calculadora_label.png");
    }

    public static Pattern maisButton() {
        return new Pattern(BASE_PATH_CALCULADORA + "mais_button.png");
    }

    public static Pattern padraoLabel() {
        return new Pattern(BASE_PATH_CALCULADORA + "padrao_label.png");
    }

    public static Pattern appMinimizadoLabel() {
        return new Pattern(BASE_PATH_CALCULADORA + "app_minimizado_label.png");
    }

    public static Pattern limparValoresButton() {
        return new Pattern(BASE_PATH_CALCULADORA + "limpar_valores_button.png");
    }

    public static void calculadoraLabelWait() throws FindFailed {
        screen.wait(calculadoraLabel(), TIME_OUT_SCREEN);
    }

    public static void maisButtonWait() throws FindFailed {
        screen.wait(maisButton(), TIME_OUT_SCREEN);
    }

    public static Match appMinimizadoExists() throws FindFailed {
        return screen.exists(appMinimizadoLabel(), 2);
    }

    public static void numerosSendKeys(String valor) throws FindFailed {
        screen.click(screen.find(padraoLabel()).below(100));
        screen.type(valor);
    }

    public static String resultadoGetText() throws FindFailed {
        screen.click(screen.find(padraoLabel()).below(100));
        screen.type("c", Key.CTRL);
        return App.getClipboard().strip();
    }

}
