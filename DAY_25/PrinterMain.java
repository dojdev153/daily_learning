package DAY_25;

public class PrinterMain<T> {
    private final T value;

    public PrinterMain(T value) {
        this.value = value;
    }

    public void Printx() {
        System.out.println(value);
    }
    public static <A, B> A returnFirst(A first, B second) {
        return first;
    }
}
