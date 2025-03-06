package tests;

import desktop.BaseScreen;
import org.sikuli.basics.Settings;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import reports.ReportListener;
import utils.DateUtils;

@Listeners({ReportListener.class})
public abstract class BaseDesktop extends BaseScreen {

    @BeforeClass
    public synchronized void preCondicao() {
        Settings.MinSimilarity = 0.80;
    }


    static {
        System.setProperty("extent.reporter.html.out", "target/test-output/Automated_Report" + DateUtils.getTimeStamp() + ".html");
    }
}
