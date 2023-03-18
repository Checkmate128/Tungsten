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
        this.addComponent(new UIButton(600, 440, 400, 100, "Button", false, new ButtonStyle(), (button) -> {
            MainRender.switchScreen(new MainScreen());
        }));
        this.addComponent(new UIHorizontalSlider(300, 100, 500, 10, new Color(100, 0, 120), new Color(150, 90, 190), (slider) -> {

        }));
        this.addComponent(new UIVerticalScrollBar(400, 160, 10, 400, new Color(220, 220, 220), new Color(140, 140, 140), 40));

        UICompoundComponent compoundTest = new UICompoundComponent(600, 600, 40, 40);
        compoundTest.addComponent(new UIImageButton(4, 4, 120, 120, "/test/test_image.png", new Color(20, 20, 20, 50), (imageButton) -> {

        }));
        this.addComponent(compoundTest);
    }
}
