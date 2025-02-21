package tests;

import org.sikuli.script.Screen;
import org.testng.annotations.Test;

public class JavaTest extends BaseSikulix {

    @Test
    public static void aaa(){
        Screen screen = new Screen();
        screen.type("12");
    }
}
