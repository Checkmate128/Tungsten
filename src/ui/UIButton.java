package ui;

import input.MouseInput;
import input.TextRenderer;

import java.awt.*;

public class UIButton extends UIComponent implements Clickable{
    private String text;
    private Color normalColor;
    private Color hoverColor;
    private Color color;

    private ClickAction onClick;

    public UIButton(int x, int y, int width, int height, String text, Color normalColor, Color hoverColor, ClickAction onClick) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
        this.normalColor = normalColor;
        this.hoverColor = hoverColor;
        this.onClick = onClick;
        this.color = normalColor;
    }

    public UIButton(int x, int y, int width, int height, String text, Color normalColor, Color hoverColor, boolean isClickable, ClickAction onClick) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
        this.normalColor = normalColor;
        this.hoverColor = hoverColor;
        this.isClickable = isClickable;
        this.onClick = onClick;
        this.color = normalColor;
    }

    public UIButton(int x, int y, int width, int height, String text, ClickAction onClick) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
        this.normalColor = (Color) StyleGuide.BUTTON_STYLE.get(0);
        this.hoverColor = (Color) StyleGuide.BUTTON_STYLE.get(1);
        this.onClick = onClick;
        this.color = normalColor;
    }

    public UIButton(int x, int y, int width, int height, String text, boolean isClickable, ClickAction onClick) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
        this.normalColor = (Color) StyleGuide.BUTTON_STYLE.get(0);
        this.hoverColor = (Color) StyleGuide.BUTTON_STYLE.get(1);
        this.isClickable = isClickable;
        this.onClick = onClick;
        this.color = normalColor;
    }

    @Override
    public void onClick() {

    }

    @Override
    public void onUnClick() {
        this.onClick.onClick(this);
    }

    @Override
    public void onHover() {
        this.color = hoverColor;
    }

    @Override
    public void onUnHover() {
        this.color = normalColor;
    }

    @Override
    protected void render(Graphics2D g, Shape containerShape, int offsetX, int offsetY) {
        int x = this.x + (int) containerShape.getBounds().getX() + offsetX;
        int y = this.y + (int) containerShape.getBounds().getY() + offsetY;
        g.setColor(color);
        g.fillRect(x, y, width, height);
        g.setColor(Color.BLACK);
        TextRenderer.drawCenteredString(g, x, y, width, height, text, new Font("Arial", 0, 50));
        if(!isClickable) {
            g.setColor(new Color(0, 0, 0, 160));
            g.fillRect(x, y, width, height);
        }
    }

    @Override
    protected void tick(Shape containerShape, int offsetX, int offsetY) {
        baseTick(containerShape, offsetX, offsetY);
    }

    public interface ClickAction {
        void onClick(UIButton button);
    }
}
