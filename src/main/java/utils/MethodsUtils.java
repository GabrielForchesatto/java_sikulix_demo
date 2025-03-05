package utils;

import org.sikuli.script.*;
import sikulix.BaseScreen;

public class MethodsUtils extends BaseScreen {

    public String getTextWithDragDrop(Pattern imgStart, Integer pixels) throws FindFailed {
        screen.click(imgStart);
        screen.dragDrop(screen.find(imgStart).right(10), screen.find(imgStart).right(pixels));
        screen.type("c", Key.CTRL);
        return App.getClipboard().strip();
    }

    public void deleteText(Pattern imgStart, Integer pixels) throws FindFailed {
        screen.click(imgStart);
        screen.type(Key.TAB);
        screen.dragDrop(screen.find(imgStart).right(10), screen.find(imgStart).right(pixels));
        screen.type(Key.DELETE);
    }

    public static void scrollDown(Pattern reference, Integer steps) throws FindFailed {
        screen.click(reference);
        screen.wheel(Button.WHEEL_DOWN, steps);
    }
}
