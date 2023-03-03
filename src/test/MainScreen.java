package test;

import main.MainRender;
import ui.Screen;
import ui.UIButton;
import ui.UICheckBox;
import ui.UIRectangle;

import java.awt.*;

public class MainScreen extends Screen {
    public MainScreen() {
        this.addComponent(new UIRectangle(0, 0, 800, 800, Color.RED));
        this.addComponent(new UIButton(40, 40, 400, 100, "Button", new Color(160, 160, 160), new Color(10, 240, 240), (button) -> {
            MainRender.switchScreen(new OtherScreen());
        }));
        this.addComponent(new UICheckBox(300, 200, 50, 50, Color.BLACK, (checkBox) -> {

        }));
    }
}
