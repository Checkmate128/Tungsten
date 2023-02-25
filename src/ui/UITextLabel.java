package ui;

import input.TextRenderer;

import java.awt.*;

public class UITextLabel extends UIComponent{
    private String text;
    private Color color;
    private int fontSize;

    public UITextLabel(int x, int y, int width, int height, String text, Color color, int fontSize) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
        this.color = color;
        this.fontSize = fontSize;
    }

    public UITextLabel(int x, int y, int width, int height, String text) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
        this.color = (Color) StyleGuide.TEXT_LABEL_STYLE.get(0);
        this.fontSize = (int) StyleGuide.TEXT_LABEL_STYLE.get(1);
    }

    @Override
    protected void render(Graphics2D g, Shape containerShape, int offsetX, int offsetY) {
        int x = this.x + (int) containerShape.getBounds().getX() + offsetX;
        int y = this.y + (int) containerShape.getBounds().getY() + offsetY;
        g.setColor(color);
        TextRenderer.drawCenteredString(g, x, y, width, height, text, new Font("Arial", 0, fontSize));
    }

    @Override
    protected void tick(Shape containerShape, int offsetX, int offsetY) {
        baseTick(containerShape, offsetX, offsetY);
    }
}
