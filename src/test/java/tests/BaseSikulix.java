package tests;

import org.sikuli.basics.Settings;
import org.sikuli.script.Match;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import sikulix.BaseScreen;
import utils.DateUtils;

public abstract class BaseSikulix extends BaseScreen {

    @BeforeClass
    public synchronized void preCondicao() {
        Settings.MinSimilarity = 0.85;
    }

    @AfterClass
    public synchronized void endTest() {
//        for (int i = 0; i< 10; i++) {
//            Match isRunning = ;
//            if (null == isRunning) {
//                break;
//            }
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
    }

    static {
        System.setProperty("extend.report.html.out", "target/test-output/Automated_Report" + DateUtils.getTimeStamp() + ".html");
    }
}
