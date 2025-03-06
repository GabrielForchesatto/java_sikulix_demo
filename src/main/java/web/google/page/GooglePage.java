package web.google.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.PageFactory.initElements;

public class GooglePage {

    final WebDriver driver;
    protected WebDriverWait wait;

    public GooglePage(WebDriver driver) {
        this.driver = driver;
        initElements(this.driver, this);
        initElements(new AjaxElementLocatorFactory(driver, 40), this);
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(20));
    }


    public WebElement pesquisaTextfield() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("gLFyf")));
    }

    public WebElement pesquisaButton() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("gNO89b")));
    }

}
