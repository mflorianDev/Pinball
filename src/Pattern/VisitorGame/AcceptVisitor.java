package Pattern.VisitorGame;

public interface AcceptVisitor {

    void accept(Visitor visitor);
    int getElementPoints();

}
