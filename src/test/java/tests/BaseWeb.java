package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import reports.ReportListener;
import utils.DateUtils;

@Listeners({ReportListener.class})
public class BaseWeb {

    protected static WebDriver driver;
    protected static final String GOOGLE_URL = "";

    @AfterClass
    public synchronized void fecharBrowser() {
        driver.quit();
    }


    static {
        System.setProperty("extent.reporter.html.out", "target/test-output/Automated_Report" + DateUtils.getTimeStamp() + ".html");
    }

}
