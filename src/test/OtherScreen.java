package test;

import main.MainRender;
import ui.*;

import java.awt.*;

public class OtherScreen extends Screen {
    public OtherScreen() {
        this.addComponent(new UIRectangle(0, 0, 800, 800, Color.YELLOW));
        this.addComponent(new UIButton(40, 440, 400, 100, "Button", new ButtonStyle(), (button) -> {
            MainRender.switchScreen(new MainScreen());
        }));
        this.addComponent(new UIButton(600, 40, 400, 100, "Button", false, new ButtonStyle(), (button) -> {
            MainRender.switchScreen(new MainScreen());
        }));
        this.addComponent(new UIHorizontalSlider(300, 100, 500, 10, new Color(100, 0, 120), new Color(150, 90, 190), (slider) -> {

        }));
        this.addComponent(new UIVerticalScrollBar(400, 160, 10, 400, new ScrollBarStyle(), 40));

        UIScrollArea scrollTest = new UIScrollArea(600, 300, 400, 400, 800, 10, new ScrollBarStyle());
        scrollTest.addComponent(new UIImageButton(4, 1080, 120, 120, "/test/test_image.png", new Color(20, 20, 20, 50), (imageButton) -> {

        }));
        this.addComponent(scrollTest);
    }
}
