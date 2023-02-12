package test;

import main.MainRender;
import ui.Screen;
import ui.UIButton;
import ui.UIHorizontalSlider;
import ui.UIRectangle;

import java.awt.*;

public class OtherScreen extends Screen {
    public OtherScreen() {
        this.addComponent(new UIRectangle(0, 0, 800, 800, Color.YELLOW));
        this.addComponent(new UIButton(40, 440, 400, 100, "Button", new Color(160, 160, 160), new Color(10, 240, 240), (button) -> {
            MainRender.switchScreen(new MainScreen());
        }));
        this.addComponent(new UIButton(600, 440, 400, 100, "Button", new Color(160, 160, 160), new Color(10, 240, 240), false, (button) -> {
            MainRender.switchScreen(new MainScreen());
        }));
        this.addComponent(new UIHorizontalSlider(300, 100, 500, 10, new Color(100, 0, 120), new Color(150, 90, 190), (slider) -> {

        }));
    }
}
