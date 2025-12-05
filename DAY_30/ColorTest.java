enum Color { RED, GREEN, BLUE }

public class ColorTest {
    public static void main(String[] args) {
        for (Color c : Color.values()) {
            System.out.println(c);
        }
    }
}
