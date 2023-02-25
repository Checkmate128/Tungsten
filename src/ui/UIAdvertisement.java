package ui;

import input.TextRenderer;

import java.awt.*;

public class UIAdvertisement extends UIComponent implements Clickable{

    public UIAdvertisement(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
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

    @Override
    protected void render(Graphics2D g, Shape containerShape, int offsetX, int offsetY) {
        g.setColor(new Color(120, 120, 120));
        g.fillRect(x, y, width, height);
        TextRenderer.drawCenteredString(g, x, y, width, height, "Ad", new Font("Arial", 0, 40));
    }

    @Override
    protected void tick(Shape containerShape, int offsetX, int offsetY) {

    }
}
