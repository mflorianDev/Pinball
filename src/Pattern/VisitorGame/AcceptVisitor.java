package Pattern.VisitorGame;

public interface AcceptVisitor {

    public void accept(StateVisit stateVisit);
    public int getPointsOrCredit();
}
