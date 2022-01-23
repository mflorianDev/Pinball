package Pattern.State;

public class PinballContext {
    private PinballState pinballState;

    public PinballContext() {
        setState(new NoCreditState());
    }

    public void setState(final PinballState newPinballState) {
        pinballState = newPinballState;
    }

    public void writeName() {
        pinballState.writeState(this);
    }
}
