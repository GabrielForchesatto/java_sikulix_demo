package web.calculadora.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.PageFactory.initElements;

public class CalculadoraWebPage {

    final WebDriver driver;
    protected WebDriverWait wait;

    public CalculadoraWebPage(WebDriver driver) {
        this.driver = driver;
        initElements(this.driver, this);
        initElements(new AjaxElementLocatorFactory(driver, 40), this);
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(20));
    }


    public WebElement igualdadeButton() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div[aria-label='igual a']")));
    }

    public WebElement maisButton() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div[aria-label='mais']")));
    }

    public WebElement limparTudoButton() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div[aria-label='limpar tudo']")));
    }

    public WebElement numerosTextfield() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("jlkklc")));
    }

    public WebElement resultadoTextfield() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("TIGsTb")));
    }
}