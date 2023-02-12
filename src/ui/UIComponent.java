package ui;

import input.MouseInput;

import java.awt.*;

public abstract class UIComponent {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected boolean isClickable = true;
    protected boolean isHovered = false;
    protected boolean lastMouseClickState = false;

    protected void onClick() {

    }

    protected void onUnClick() {

    }
    protected void onHover() {

    }
    protected void onUnHover() {

    }
    protected abstract void render(Graphics2D g);
    protected abstract void tick();
    protected void baseTick() {
        if(this instanceof Clickable && isClickable && MouseInput.x >= x && MouseInput.x <= x + width && MouseInput.y - 26 >= y && MouseInput.y - 26 <= y + height && !isHovered) {
            isHovered = true;
            onHover();
        }

        if(this instanceof Clickable && !(MouseInput.x >= x && MouseInput.x <= x + width && MouseInput.y - 26 >= y && MouseInput.y - 26 <= y + height) && isHovered) {
            isHovered = false;
            onUnHover();
        }

        if(this instanceof Clickable && isClickable && MouseInput.x >= x && MouseInput.x <= x + width && MouseInput.y - 26 >= y && MouseInput.y - 26 <= y + height && MouseInput.leftClick) {
            onClick();
        }

        if(this instanceof Clickable && isClickable && MouseInput.x >= x && MouseInput.x <= x + width && MouseInput.y - 26 >= y && MouseInput.y - 26 <= y + height && lastMouseClickState && !MouseInput.leftClick) {
            onUnClick();
        }

        lastMouseClickState = MouseInput.leftClick;
    }
}
