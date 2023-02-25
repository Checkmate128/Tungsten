package ui;

import java.awt.*;

public class UIRectangle extends UIComponent {

    private Color color;

    public UIRectangle(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    @Override
    protected void onClick() {

    }

    @Override
    protected void onHover() {

    }

    @Override
    protected void onUnHover() {

    }

    @Override
    protected void render(Graphics2D g, Shape containerShape, int offsetX, int offsetY) {
        int x = this.x + (int) containerShape.getBounds().getX() + offsetX;
        int y = this.y + (int) containerShape.getBounds().getY() + offsetY;
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    @Override
    protected void tick(Shape containerShape, int offsetX, int offsetY) {
        baseTick(containerShape, offsetX, offsetY);
    }
}
