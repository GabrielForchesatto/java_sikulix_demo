package web.calculadora.actions;

import org.openqa.selenium.WebDriver;
import web.calculadora.page.CalculadoraWebPage;

public class CalculadoraWebAction {

    private static CalculadoraWebPage calculadoraPage;

    public CalculadoraWebAction(WebDriver driver) {
        calculadoraPage = new CalculadoraWebPage(driver);
    }

    public void somarNumeros(String... valores) throws InterruptedException {
        for (int i = 0; i < valores.length; i++) {
            calculadoraPage.numerosTextfield().sendKeys(valores[i]);

            if (i < valores.length - 1) {
                calculadoraPage.maisButton().click();
            }
            calculadoraPage.igualdadeButton().click();
        }
    }

}