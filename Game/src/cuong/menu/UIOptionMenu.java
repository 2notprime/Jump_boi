package menu;

import core.Size;
import state.State;
//import state.menu.MenuState;
import ui.Alignment;
import ui.UIText;
import ui.VerticalContainer;
import ui.clickable.UIButton;

public class UIOptionMenu extends VerticalContainer {
    public UIOptionMenu(Size windowSize) {
        super(windowSize);
        alignment = new Alignment(Alignment.Position.CENTER, Alignment.Position.CENTER);

        addUIComponent(new UIText("OPTIONS"));
        addUIComponent(new UIButton("BACK", (State state)->System.out.print("Back button clicked")));
    }
}
