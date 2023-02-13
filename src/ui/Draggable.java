package ui;

public interface Draggable {
    /**
     * Called whenever the element is dragged. dx and dy represent the change in x and y position respectively.
     * @param dx
     * @param dy
     */
    void onDrag(int dx, int dy);
}
