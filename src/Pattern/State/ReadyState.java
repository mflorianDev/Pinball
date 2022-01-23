package Pattern.State;

public class ReadyState implements PinballState {
    /** State counter */
    private int count = 0;

    @Override
    public void writeState(final PinballContext STATE_CONTEXT) {
        System.out.println("The pinball machine is in the ready state!");
        /** Change state after StateB's writeName() gets invoked twice
        if(++count > 1) {
            STATE_CONTEXT.setState(new NoCreditState());
        }
         */
    }
}
