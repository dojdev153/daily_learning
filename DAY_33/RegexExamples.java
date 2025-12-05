package DAY_33;
import java.util.regex.*;

public class RegexExamples {
    static void demoPatternAndMatcherBasics() {
        String text = "I have a cat, another cat, and one more cat.";
        String regex = "cat";

        // FIX 1: Capital P for Pattern.compile
        Pattern pattern = Pattern.compile(regex); 
        Matcher matcher = pattern.matcher(text);

        while(matcher.find()){
            // FIX 2: Capital S for System.out
            System.out.println("Found: " + matcher.group() + " at [" + matcher.start() + ", " + matcher.end() + "]");
        }
    }

    static void demoPatternSyntaxException() {
        String badRegex = "*cat";

        try{
            Pattern pattern = Pattern.compile(badRegex);
            System.out.println("This will not be printed if regex is invalid: " + pattern);
        }catch(PatternSyntaxException e){
            System.out.println("Invalid regex: " + e.getDescription());
            System.out.println("Pattern: " + e.getPattern());
            System.out.println("Index: " + e.getIndex());
        }
    }

    static void demoDotMetaCharacter() {
        String text = "cat, cot, cut, cxt, ctt";
        String regex = "c.t";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println("Found: " + matcher.group() + "at " + "[" + matcher.start() + ", " + matcher.end() + ")");
        }
    }

    static void demoOrOperator() {
        String text = "I have a cat and a dog and a fish";
        String regex = "cat|dog";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        
        while(matcher.find()){
            System.out.println("Found: " + matcher.group() + " at " + "[" + matcher.start() + ", " + matcher.end() + ")");
        }
    }

    static void demoCharacterClasses() {
        String text = "cat, cot, cut, cit, c9t, c_t";
        String regex1 = "c[aeiou]t";
        String regex2 = "c[^aeiou]t";

        System.out.println("vowel in the middle: ");
        Matcher m1 = Pattern.compile(regex1).matcher(text);
        while (m1.find()) {
            System.out.println("Matched: " + m1.group());
        }
        System.out.println();
        System.out.println("non-vowel in the middle: ");
        Matcher m2 = Pattern.compile(regex2).matcher(text);
        while (m2.find()) {
            System.out.println("Matched: " + m2.group());
        }
    }

    static void demoEscapingMetaCharacter() {
        String text = "File name: report.txt, data.csv, notes.doc, file.name";
        String dotAsWildCardRegex = "file.name";
        String literalDotRegex = "file\\.name";

        System.out.println("Using dot as ANY character: ");
        Matcher m1 = Pattern.compile(dotAsWildCardRegex).matcher(text);
        while (m1.find()) {
            System.out.println("Matched: " + m1.group());
        }
        System.out.println();
        System.out.println("Using literal dot: ");
        Matcher m2 = Pattern.compile(literalDotRegex).matcher(text);
        while (m2.find()) {
            System.out.println("Matched: " +  m2.group());
        }
    }

    static void demoAdvancedCharClass() {
        String digits = "01234556789";
        String unionRegex = "[0-2[6-9]]";
        String intersectionRegex = "[0-6&&[3-9]]";
        String SubRegex = "[0-9&&[^3-5]]";

        Matcher m1 = Pattern.compile(unionRegex).matcher(digits);
        Matcher m2 = Pattern.compile(intersectionRegex).matcher(digits);
        Matcher m3 = Pattern.compile(SubRegex).matcher(digits);

        System.out.println("Union: ");
        while (m1.find()) {
            System.out.println("Matched: " + m1.group());
        }
        System.out.println();
                System.out.println("Intersection: ");
        while (m2.find()) {
            System.out.println("Matched: " + m2.group());
        }
        System.out.println();
        System.out.println("Substraction: ");
        while (m3.find()) {
            System.out.println("Matched: " + m3.group());
        }
        System.out.println();

    }

    static void demoPredefinedCharClass() {
        String text = "User1, User_2, User-3, User 4";
        String digitregex = "\\d";
        String wordregex = "\\w";
        String whitespaceregex = "\\s";
        String union = "[\w\s]";
        String sub = "\w&&[^_]";
        String inter = "[\w&&[a-f]]";

        Matcher m1 = Pattern.compile(digitregex).matcher(text);
        Matcher m2 = Pattern.compile(wordregex).matcher(text);
        Matcher m3 = Pattern.compile(whitespaceregex).matcher(text);
        Matcher m4 = Pattern.compile(union).matcher(text);
        Matcher m5 = Pattern.compile(inter).matcher(text);
        Matcher m6 = Pattern.compile(sub).matcher(text);
    }

    public static void main(String[] args) {
        demoPatternAndMatcherBasics();
        System.out.println("\n");
        demoPatternSyntaxException();
        System.out.println("\n");
        demoOrOperator();
        System.out.println("\n");
        demoDotMetaCharacter();
        System.out.println("\n");
        demoEscapingMetaCharacter();
        System.out.println("\n");
        demoCharacterClasses();
        System.out.println("\n");
        demoAdvancedCharClass();
    }
}