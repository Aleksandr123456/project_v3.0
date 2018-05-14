import java.awt.*;

public abstract class State {
    protected Game game;

    private static State currentState = null;

    public State(Game game){
        this.game = game;
    }

    public static void setState(State state){
        currentState = state;
    }

    public static State getCurrentState() {
        return currentState;
    }

    public abstract void update();

    public abstract void draw(Graphics g);
}
