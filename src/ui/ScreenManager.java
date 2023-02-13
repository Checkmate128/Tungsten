package ui;

public class ScreenManager {
    private static UIComponent clickedComponent;

    public static void setClickedComponent(UIComponent uic) {
        clickedComponent = uic;
    }

    public static UIComponent getClickedComponent() {
        return clickedComponent;
    }
}
