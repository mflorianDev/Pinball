package Pattern.Singelton;

public class Multiball {

    private static Multiball instance = null;

    private Multiball() {
    }

    public static Multiball Instance() {
        if (instance == null) {
            instance = new Multiball();
        }
        return instance;
    }

    //TODO: Do something!
    public void write() {
        System.out.println("I am a Multiball!");
    }

}
