package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class ScreenshotUtils {
    protected static final Screen screen = new Screen();

    public static String addScreenshotBase64(String name) {
        String imgPath = System.getProperty("user.dir") + "\\target\\" + name + DateUtils.getTimeStamp() + ".png";

        try {
            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage capture = new Robot().createScreenCapture(screenRect);

            File imageFile = new File(imgPath);
            ImageIO.write(capture, "png", imageFile);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(capture, "png", baos);
            byte[] imageBytes = baos.toByteArray();

            imageFile.delete();

            return Base64.getEncoder().encodeToString(imageBytes);


        } catch (AWTException | IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static String addWebScreenshotBase64Highlight(String name, WebDriver driver, WebElement element) {
        String imgPath = System.getProperty("user.dir") + "\\target\\" + name + DateUtils.getTimeStamp() + ".png";

        try {

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].style.border='3px solid red'", element);

            Thread.sleep(500);

            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage capture = new Robot().createScreenCapture(screenRect);

            js.executeScript("arguments[0].style.border=''", element);

            File imageFile = new File(imgPath);
            ImageIO.write(capture, "png", imageFile);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(capture, "png", baos);
            byte[] imageBytes = baos.toByteArray();

            return Base64.getEncoder().encodeToString(imageBytes);


        } catch (AWTException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static String addSikulixScreenshotHighlight(String name, Pattern... patterns) {
        String imgPath = System.getProperty("user.dir") + "\\target\\" + name + DateUtils.getTimeStamp() + ".png";


        try {
            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage capture = new Robot().createScreenCapture(screenRect);

            for (Pattern pattern : patterns) {
                Region region = screen.find(pattern);
                Graphics2D g2d = capture.createGraphics();
                g2d.setColor(Color.red);
                g2d.setStroke(new BasicStroke(3));
                g2d.drawRect(region.getX(), region.getY(), region.getW(), region.getH());
                g2d.dispose();
            }

            File imageFile = new File(imgPath);
            ImageIO.write(capture, "png", imageFile);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(capture, "png", baos);
            byte[] imageBytes = baos.toByteArray();

            return Base64.getEncoder().encodeToString(imageBytes);


        } catch (AWTException | IOException | FindFailed e) {
            throw new RuntimeException(e);
        }


    }

    public static String addSikulixScreenshotHighlight(String name, Integer x, Integer w, Pattern... patterns) {
        String imgPath = System.getProperty("user.dir") + "\\target\\" + name + DateUtils.getTimeStamp() + ".png";


        try {
            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage capture = new Robot().createScreenCapture(screenRect);

            for (Pattern pattern : patterns) {
                Region region = screen.find(pattern);
                Graphics2D g2d = capture.createGraphics();
                g2d.setColor(Color.red);
                g2d.setStroke(new BasicStroke(3));
                g2d.drawRect(region.getX() + x, region.getY(), region.getW() - w, region.getH());
                g2d.dispose();
            }

            File imageFile = new File(imgPath);
            ImageIO.write(capture, "png", imageFile);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(capture, "png", baos);
            byte[] imageBytes = baos.toByteArray();

            imageFile.delete();

            return Base64.getEncoder().encodeToString(imageBytes);


        } catch (AWTException | IOException | FindFailed e) {
            throw new RuntimeException(e);
        }
    }

    public static String addSikulixScreenshotHighlight(String name, Integer x, Integer y, Integer w, Integer h, Pattern... patterns) {
        String imgPath = System.getProperty("user.dir") + "\\target\\" + name + DateUtils.getTimeStamp() + ".png";


        try {
            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage capture = new Robot().createScreenCapture(screenRect);

            for (Pattern pattern : patterns) {
                Region region = screen.find(pattern);
                Graphics2D g2d = capture.createGraphics();
                g2d.setColor(Color.red);
                g2d.setStroke(new BasicStroke(3));
                g2d.drawRect(region.getX() + x, region.getY() + y, region.getW() - w, region.getH() - h);
                g2d.dispose();
            }

            File imageFile = new File(imgPath);
            ImageIO.write(capture, "png", imageFile);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(capture, "png", baos);
            byte[] imageBytes = baos.toByteArray();

            imageFile.delete();

            return Base64.getEncoder().encodeToString(imageBytes);


        } catch (AWTException | IOException | FindFailed e) {
            throw new RuntimeException(e);
        }

    }

}