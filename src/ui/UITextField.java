package ui;

import input.KeyboardInput;
import input.TextRenderer;

import java.awt.*;
import java.awt.event.KeyEvent;

public class UITextField extends UIComponent implements Typeable, Clickable{
    private Font font;
    private Color bodyColor;
    private Color borderColor;
    private Color textColor;
    private String text = "";
    private String hintText;
    protected int characterTypeTimer = 0;
    protected char lastCharacter = ' ';
    protected int textCursorPosition = 0;

    public UITextField(int x, int y, int width, int height, Font font, Color bodyColor, Color borderColor, Color textColor) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.font = font;
        this.bodyColor = bodyColor;
        this.borderColor = borderColor;
        this.textColor = textColor;
    }

    @Override
    protected void render(Graphics2D g, Shape containerShape, int offsetX, int offsetY) {
        FontMetrics metrics = g.getFontMetrics(font);
        int x = this.x + containerShape.getBounds().x + offsetX;
        int y = this.y + containerShape.getBounds().y + offsetY;
        int textX = x + (width - metrics.stringWidth(text)) / 2;
        int textY = y + ((height - metrics.getHeight()) / 2) + metrics.getAscent();
        g.setColor(borderColor);
        g.drawRect(x, y, width, height);
        g.setColor(bodyColor);
        g.fillRect(x, y, width, height);
        g.setColor(textColor);
        TextRenderer.drawCenteredString(g, x, y, width, height, text, font);
        if(ScreenManager.getTypingComponent() == this) {
            int dx = 0;
            for(int i = 0; i < textCursorPosition; i++) {
                dx += metrics.charWidth(text.charAt(i));
            }
            g.fillRect(textX + dx, textY - metrics.getHeight(), 1, metrics.getHeight());
        }
    }

    @Override
    protected void tick(Shape containerShape, int offsetX, int offsetY) {
        baseTick(containerShape, offsetX, offsetY);

        if((ScreenManager.getTypingComponent() == this) && KeyboardInput.typing && KeyboardInput.canBeTyped(KeyboardInput.currentCode)) {
            if ((characterTypeTimer < 0 || KeyboardInput.currentKey != lastCharacter)) {
                if (KeyboardInput.canBeTyped(KeyboardInput.currentCode)) {
                    if(!KeyboardInput.isActionKey) {
                        text += KeyboardInput.currentKey;
                        textCursorPosition++;
                    } else {
                        if(KeyboardInput.currentCode == KeyEvent.VK_RIGHT && textCursorPosition < text.length()) {
                            textCursorPosition++;
                        } else if(KeyboardInput.currentCode == KeyEvent.VK_LEFT && textCursorPosition > 0) {
                            textCursorPosition--;
                        }
                    }
                }

                if (KeyboardInput.currentCode == KeyEvent.VK_BACK_SPACE) {
                    if(text.length() == 0) {
                        text = "";
                    } else if(text.length() == 1) {
                        text = "";
                        textCursorPosition = 0;
                    } else {
                        text = text.substring(0, text.length() - 2);
                        textCursorPosition = textCursorPosition - 2;
                    }
                }

                if(KeyboardInput.currentKey != lastCharacter || !KeyboardInput.typing) {
                    lastCharacter = KeyboardInput.currentKey;
                    characterTypeTimer = 30;
                } else {
                    characterTypeTimer = 3;
                }
            } else {
                if(characterTypeTimer > -1) {
                    characterTypeTimer--;
                }
            }
        } else {
            characterTypeTimer = 0;
            lastCharacter = 0;
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
