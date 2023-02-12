package ui;

public interface Clickable {
    /**
     * Called whenever the UI element is clicked. Clicking occurs whenever the mouse button is pressed.
     */
    void onClick();

    /**
     * Called whenever the UI element is un-clicked. Un-clicking occurs when the mouse button is unpressed.
     */
    void onUnClick();

    /**
     * Called whenever the UI element is hovered on by the mouse cursor.
     */
    void onHover();

    /**
     * Called whenever the UI element is un-hovered on by the mouse cursor.
     */
    void onUnHover();
}
