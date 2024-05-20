package menu;

import core.Size;
import state.State;
import ui.Alignment;
import ui.UIText;
import ui.VerticalContainer;
import ui.clickable.UIButton;

public class UIMainMenu extends VerticalContainer {
    public UIMainMenu(Size windowSize) {
        super(windowSize);
        alignment = new Alignment(Alignment.Position.CENTER, Alignment.Position.CENTER);

        addUIComponent(new UIText("ISOBUBBLER"));
        addUIComponent(new UIButton("PLAY", (State state) -> System.out.print("Play button clicked")));
        addUIComponent(new UIButton("OPTIONS", (State state) -> System.out.print("Option  button")));
        addUIComponent(new UIButton("EXIT", (State state) -> System.out.print("Exit button")));
    }
}
