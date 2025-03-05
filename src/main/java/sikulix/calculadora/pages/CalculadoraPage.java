package sikulix.calculadora.pages;

import org.sikuli.script.App;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import sikulix.BaseScreen;

public class CalculadoraPage extends BaseScreen {


    public static Pattern calculadoraLabel() {
        return new Pattern(BASE_PATH_CALCULADORA + "calculadora_label.png");
    }

    public static Pattern maisButton() {
        return new Pattern(BASE_PATH_CALCULADORA + "mais_button.png");
    }

    public static Pattern igualdadeButton() {
        return new Pattern(BASE_PATH_CALCULADORA + "igualdade_button.png");
    }

    public static Pattern padraoLabel() {
        return new Pattern(BASE_PATH_CALCULADORA + "padrao_label.png");
    }

    public static void calculadoraLabelWait() throws FindFailed {
        screen.wait(calculadoraLabel(), TIME_OUT_SCREEN);
    }

    public static void maisButtonWait() throws FindFailed {
        screen.wait(maisButton(), TIME_OUT_SCREEN);
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
