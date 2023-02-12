package ui;

import java.awt.*;

public class UICheckBox extends UIComponent implements Clickable{
    private boolean isChecked = false;
    private ClickAction clickAction;
    private Color color;

    public UICheckBox(int x, int y, int width, int height, Color color, ClickAction clickAction) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.clickAction = clickAction;
    }

    public UICheckBox(int x, int y, int width, int height, Color color, boolean isChecked, ClickAction clickAction) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.isChecked = isChecked;
        this.clickAction = clickAction;
    }

    public UICheckBox(int x, int y, int width, int height, ClickAction clickAction) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = (Color) StyleGuide.CHECK_BOX_STYLE.get(0);
        this.clickAction = clickAction;
    }

    public UICheckBox(int x, int y, int width, int height, boolean isChecked, ClickAction clickAction) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = (Color) StyleGuide.CHECK_BOX_STYLE.get(0);
        this.isChecked = isChecked;
        this.clickAction = clickAction;
    }

    @Override
    public void onClick() {

    }

    @Override
    public void onUnClick() {
        isChecked = !isChecked;
        clickAction.onClick(this);
    }

    @Override
    public void onHover() {

    }

    @Override
    public void onUnHover() {

    }

    @Override
    protected void render(Graphics2D g) {
        g.setColor(color);
        g.drawRect(x, y, width, height);
        if(isChecked) {
            g.drawLine(x + 5, y + 5, x + width - 5, y + height - 5);
            g.drawLine(x + width - 5, y + 5, x + 5, y + height - 5);
        }
    }

    @Override
    protected void tick() {
        baseTick();
    }

    public interface ClickAction {
        void onClick(UICheckBox checkBox);
    }
}
