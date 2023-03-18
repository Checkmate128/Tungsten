package test;

import main.MainRender;
import ui.*;

import java.awt.*;

public class MainScreen extends Screen {
    public MainScreen() {
        this.addComponent(new UIRectangle(0, 0, 800, 800, Color.RED));
        this.addComponent(new UIButton(40, 40, 400, 100, "Button", new ButtonStyle(), (button) -> {
            MainRender.switchScreen(new OtherScreen());
        }));
        this.addComponent(new UICheckBox(300, 200, 50, 50, Color.BLACK, (checkBox) -> {

        }));
        this.addComponent(new UITextField(500,500, 200, 50, new Font("Arial", 0, 20), Color.WHITE, Color.BLACK, Color.BLACK));
    }
}
