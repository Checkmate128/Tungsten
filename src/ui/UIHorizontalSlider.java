package ui;

import input.MouseInput;

import java.awt.*;

public class UIHorizontalSlider extends UIComponent implements Clickable{

    private Color mainColor;
    private Color filledAreaColor;
    private double value = 0.0;
    private ClickAction action;
    private int thickness;

    public UIHorizontalSlider(int x, int y, int width, int thickness, Color mainColor, Color filledAreaColor, ClickAction action) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.thickness = thickness;
        this.height = thickness * 2;
        this.mainColor = mainColor;
        this.filledAreaColor = filledAreaColor;
        this.action = action;
    }

    public UIHorizontalSlider(int x, int y, int width, int thickness, Color mainColor, Color filledAreaColor, double value, ClickAction action) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.thickness = thickness;
        this.height = thickness * 2;
        this.mainColor = mainColor;
        this.filledAreaColor = filledAreaColor;
        this.value = value;
        this.action = action;
    }

    @Override
    public void onClick() {
        value = ((double)(MouseInput.x - x)) / width;
        action.onClick(this);
    }

    @Override
    public void onUnClick() {

    }

    @Override
    public void onHover() {

    }

    @Override
    public void onUnHover() {

    }

    @Override
    protected void render(Graphics2D g) {
        g.setColor(mainColor);
        g.fillRect(x, y + thickness / 2, width, thickness);
        g.setColor(filledAreaColor);
        g.fillRect(x, y + thickness / 2, (int) (value * width + thickness / 2), thickness);
        g.fillOval((int) (x + value * width - thickness), y, 2 * thickness, 2 * thickness);
    }

    @Override
    protected void tick() {
        baseTick();
        if(value > 1.0) {
            value = 1.0;
        }

        if(value < 0.0) {
            value = 0.0;
        }
    }

    public interface ClickAction {
        void onClick(UIHorizontalSlider button);
    }
}
