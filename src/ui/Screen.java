package ui;

import java.awt.*;
import java.util.ArrayList;

public abstract class Screen {
    private ArrayList<UIComponent> components = new ArrayList<>();

    public void addComponent(UIComponent uic) {
        components.add(uic);
    }

    public void render(Graphics2D g) {
        for(int i = components.size() - 1; i > -1; i--) {
            components.get(i).tick();
        }

        for(int i = 0; i < components.size(); i++) {
            components.get(i).render(g);
        }
    }
}
