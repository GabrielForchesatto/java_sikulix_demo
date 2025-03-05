package sikulix;

import org.sikuli.script.Screen;

public abstract class BaseScreen {

    protected static final Screen screen = new Screen();
    protected static final String BASE_PATH_CALCULADORA = System.getProperty("user.dir") + "\\src\\main\\resources\\calculadora\\screens\\";
    protected static final int TIME_OUT_SCREEN = 30;

}