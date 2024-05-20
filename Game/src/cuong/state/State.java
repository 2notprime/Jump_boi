package state;

import core.Position;
import core.Size;
import ui.UIContainer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public abstract class State {


    protected List<UIContainer> uiContainers;
    protected Size windowSize;

    private State nextState;

    public State(Size windowSize) {
        this.windowSize = windowSize;
    }

    public void update() {
    }

    private void handleMouseInput() {

    }

    private void updateGameObjects() {
    }

    private void sortObjectsByPosition() {
    }

    public void print(){
        System.out.print("Button clicked");
    }


    public Position getRandomPosition() {
        //Có thể dùng hay không, làm theo project trên mạng
        return new Position(1,2);
    }


    public List<UIContainer> getUiContainers() {
        return uiContainers;
    }

    public void setNextState(State nextState) {
        this.nextState = nextState;
    }
}
