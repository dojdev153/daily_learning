import java.util.regex.*;
public class RegexYear2A {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("[^ca]");
        Matcher m = p.matcher("r");
        boolean result = m.matches();
        System.out.println(result);
    }
}
