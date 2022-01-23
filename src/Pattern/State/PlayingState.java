package Pattern.State;

public class PlayingState implements PinballState {

    @Override
    public void writeState(final PinballContext STATE_CONTEXT) {
        System.out.println("The pinball machine is in the playing state.");
    }
}