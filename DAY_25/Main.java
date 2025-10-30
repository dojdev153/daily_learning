package DAY_25;

public class Main {
    public static void main(String[] args) {
        PrinterMain<Integer> printer = new PrinterMain<>(10);
        printer.Printx(); 

        PrinterMain<String> printer2 = new PrinterMain<>("hello");
        printer2.Printx(); 

        System.out.println(PrinterMain.returnFirst(10, "cable"));
        System.out.println(PrinterMain.returnFirst("glow", 100));

    }
}
