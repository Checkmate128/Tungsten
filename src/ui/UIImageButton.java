package ui;

import input.ImageLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UIImageButton extends UIComponent implements Clickable{
    private BufferedImage image;
    private ImageLoader loader = new ImageLoader();
    private Color hoverOverlay;
    private ClickAction action;

    public UIImageButton(int x, int y, int width, int height, String fileName, Color hoverOverlay, ClickAction action) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        image = loader.loadImage(fileName);
        this.hoverOverlay = hoverOverlay;
        this.action = action;
    }

    @Override
    protected void render(Graphics2D g, Shape containerShape, int offsetX, int offsetY) {
        int x = this.x + containerShape.getBounds().x + offsetX;
        int y = this.y + containerShape.getBounds().y + offsetY;
        g.drawImage(image, x, y, width, height, null);
        if(isHovered) {
            g.setColor(hoverOverlay);
            g.fillRect(x, y, width, height);
        }
    }

    @Override
    protected void tick(Shape containerShape, int offsetX, int offsetY) {
        baseTick(containerShape, offsetX, offsetY);
    }

    @Override
    public void onClick() {

    }

    @Override
    public void onUnClick() {
        action.onClick(this);
    }

    @Override
    public void onHover() {

    }

    @Override
    public void onUnHover() {

    }

    public interface ClickAction {
        void onClick(UIImageButton button);
    }
}
