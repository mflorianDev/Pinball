import Pattern.Composite.Component;
import Pattern.VisitorGame.ElementVisitor;


public class VisitorTest {
    int totalPoints;
    int newPoints;

    Board board = new Board();
    ElementVisitor visitor = new ElementVisitor();

    public void init(){
        System.out.println("in it");

        board.createMainBoard();

        Component bumper = board.mainBoard.getComponentList().get(0);
        Component ramp = board.mainBoard.getComponentList().get(2);
        Component target = board.mainBoard.getComponentList().get(4);

        System.out.println(totalPoints);
        newPoints = visitor.getPointsFromElement(bumper);
        totalPoints += newPoints;
        newPoints = visitor.getPointsFromElement(ramp);
        totalPoints += newPoints;
        System.out.println(totalPoints);



    }

}
