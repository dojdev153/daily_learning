package DAY_28.INTRO;

public class Program1 {
    public static void main(String[] args) {
        for(int i=0;i<=10;i++){
            System.out.print(i + " ");
        }
        System.out.println();
        int i = 0;
        while (i <= 20) {
            if(i % 2 == 0){
                System.out.print(i + " ");
            }
            i++;
        }
        System.out.println();
        double sum = 0.0;
        for(int j = 0; j< 10; j++){
            sum +=j;
        }
        System.out.println("sum is " + sum);
    }
}
