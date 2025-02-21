package reports;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.service.ExtentService;
import com.aventstack.extentreports.service.ExtentTestManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sikuli.script.Pattern;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import javax.imageio.IIOException;

import java.awt.*;
import java.io.IOException;

import static utils.ScreenshotUtils.*;

public class ReportListener implements ITestListener{

    public synchronized void onStart(ITestContext context) {
        ExtentService.getInstance().setAnalysisStrategy(AnalysisStrategy.CLASS);
        ExtentService.getInstance().setSystemInfo("OS", System.getProperty("os.name"));
    }

    public synchronized void onFinish(ITestResult context) {
        ExtentService.getInstance().flush();
    }

    public synchronized void onTestStart(ITestResult result) {
        ExtentTestManager.createMethod(result, true);
    }

    public synchronized void onTestSuccess(ITestResult result) {
        ExtentTestManager.log(result, true);
    }

    public synchronized void onTestFailure(ITestResult result) {
        ExtentTestManager.log(result, true);
        try{
            ExtentTestManager.getTest().log(Status.INFO, " | Click for open Screenshot Attach: ====>" , MediaEntityBuilder.createScreenCaptureFromBase64String(addScreenshotBase64(createTestName(result))).build());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void onTestSkipped(ITestResult result) {
        ExtentTestManager.log(result, true);
    }

    public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ExtentTestManager.log(result, true);
    }

    public static synchronized void log(String txt) {
        ExtentTestManager.getTest().log(Status.INFO, txt);
    }

    public static String createTestName(ITestResult iTestResult) {
        StringBuilder completeFileName = new StringBuilder();

        completeFileName.append(iTestResult.getTestClass().getRealClass().getSimpleName());
        completeFileName.append("_");
        completeFileName.append(iTestResult.getName());

        Object[] parameters = iTestResult.getParameters();

        for (Object parameter : parameters) {
            completeFileName.append("_");
            completeFileName.append(parameter);
        }

        return completeFileName.toString();
    }

    public static synchronized void logScreenshot(String comment) throws IOException {
        ExtentTestManager.getTest().log(Status.INFO, comment + "<br>" + " | Click for open Screenshot Attach: ====>",
                MediaEntityBuilder.createScreenCaptureFromBase64String(addScreenshotBase64("logScreenshot")).build());
    }

    public static synchronized void logScreenshotHighlightSikulix(String comment, Pattern... pattern) throws AWTException, IOException {
        ExtentTestManager.getTest().log(Status.INFO, comment + "<br>" + " | Click for open Screenshot Attach: ====>",
                MediaEntityBuilder.createScreenCaptureFromBase64String(addSikulixScreenshotHighlight("logScreenshotSikulix", pattern)).build());
    }

    public static synchronized void logScreenshotHighlightSikulix(String comment, Integer xStart, Integer xEnd, Pattern... pattern) throws AWTException, IOException {
        ExtentTestManager.getTest().log(Status.INFO, comment + "<br>" + " | Click for open Screenshot Attach: ====>",
                MediaEntityBuilder.createScreenCaptureFromBase64String(addSikulixScreenshotHighlight("logScreenshotSikulix", xStart, xEnd, pattern)).build());
    }

    public static synchronized void logScreenshotHighlightSikulix(String comment, Integer xStart, Integer xEnd, Integer yStart, Integer yEnd, Pattern... pattern) {
        ExtentTestManager.getTest().log(Status.INFO, comment + "<br>" + " | Click for open Screenshot Attach: ====>",
                MediaEntityBuilder.createScreenCaptureFromBase64String(addSikulixScreenshotHighlight("logScreenshotSikulix", xStart, xEnd, yStart, yEnd, pattern)).build());
    }

    public static synchronized void logScreenshotHighlightSelenium(String comment, WebDriver driver, WebElement element) throws IOException {
        ExtentTestManager.getTest().log(Status.INFO, comment + "<br>" + " | Click for open Screenshot Attach: ====>",
                MediaEntityBuilder.createScreenCaptureFromBase64String(addWebScreenshotBase64Highlight("logScreenshotSikulix", driver, element)).build());
    }



}
