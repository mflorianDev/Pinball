package Pattern.Visitor;

public class VisitorPatternDemo {
    public static void main(String[] args) {

        // https://www.tutorialspoint.com/design_pattern/visitor_pattern.htm
        ComputerPart computer = new Computer();
        computer.accept(new ComputerPartDisplayVisitor());

        Mouse mymouse = new Mouse();
        mymouse.accept(new ComputerPartDisplayVisitor());
    }
}
