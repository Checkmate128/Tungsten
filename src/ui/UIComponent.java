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
    protected int lastMouseX = 0;
    protected int lastMouseY = 0;

    protected void onClick() {

    }

    protected void onUnClick() {

    }
    protected void onHover() {

    }
    protected void onUnHover() {

    }

    protected void onDrag(int dx, int dy) {

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

        if(this instanceof Clickable && ScreenManager.getClickedComponent() == null && isClickable && MouseInput.x >= x && MouseInput.x <= x + width && MouseInput.y - 26 >= y && MouseInput.y - 26 <= y + height && !lastMouseClickState && MouseInput.leftClick) {
            ScreenManager.setClickedComponent(this);
            onClick();
        }

        if(this instanceof Clickable && ScreenManager.getClickedComponent() == this && isClickable && MouseInput.x >= x && MouseInput.x <= x + width && MouseInput.y - 26 >= y && MouseInput.y - 26 <= y + height && lastMouseClickState && !MouseInput.leftClick) {
            onUnClick();
        }

        if(this instanceof Draggable && ScreenManager.getClickedComponent() == this && isClickable) {
            onDrag(MouseInput.x - lastMouseX, MouseInput.y - lastMouseY);
        }

        lastMouseClickState = MouseInput.leftClick;
        lastMouseX = MouseInput.x;
        lastMouseY = MouseInput.y;

        if(ScreenManager.getClickedComponent() == this && !MouseInput.leftClick) {
            ScreenManager.setClickedComponent(null);
        }
    }
}
