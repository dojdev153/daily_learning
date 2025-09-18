public class Continue {
    public static void main(String[] a){
        for(int i=1;i<=5;i++){
            if(i==5){
                System.out.println("skipping at i = "+i);
                continue;
            }
          System.out.println(i);
        }
    }
}