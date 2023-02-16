package ui;

import input.MouseInput;

import java.awt.*;

public class UIVerticalScrollBar extends UIComponent implements Draggable, Clickable{
    private int barFillLength = 0;
    private double value = 0;
    private Color backgroundColor;
    private Color fillColor;

    public UIVerticalScrollBar(int x, int y, int width, int height, Color backgroundColor, Color fillColor, int barFillLength) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.backgroundColor = backgroundColor;
        this.fillColor = fillColor;
        this.barFillLength = barFillLength;
    }

    @Override
    protected void render(Graphics2D g) {
        g.setColor(backgroundColor);
        g.fillRect(x, y, width, height);
        g.setColor(fillColor);
        g.fillRect(x + 1, (int) (y + value * (height - barFillLength - 2) + 1), width - 2, barFillLength);

    }

    @Override
    protected void tick() {
        baseTick();

        if(value > 1) {
            value = 1;
        }

        if(value < 0) {
            value = 0;
        }
    }

    @Override
    public void onDrag(int dx, int dy) {
        if(MouseInput.y - 24 > y + value * (height - barFillLength - 2) + 1 && MouseInput.y - 24 < y + value * (height - barFillLength - 2) + 1 + barFillLength) {
            value += (double)dy / (double)((height - barFillLength - 2) + 1);
        } else {
            value = (double)(MouseInput.y - 24 - y - barFillLength / 2) / (double)((height - barFillLength - 2) + 1);
        }
    }

    @Override
    public void onClick() {

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
}
