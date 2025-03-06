package web.google.actions;

import org.openqa.selenium.WebDriver;
import web.google.page.GooglePage;

public class GoogleAction {

    private static GooglePage googlePage;

    public GoogleAction(WebDriver driver) {
        googlePage = new GooglePage(driver);
    }

    public static void realizarPesquisa(String pesquisa) {
        googlePage.pesquisaTextfield().sendKeys(pesquisa);
        googlePage.pesquisaButton().click();
    }

}
