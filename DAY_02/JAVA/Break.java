public class Break{
    public static void main(String[] args){
        for(int i=1;i<=10;i++){
            if(i==5){
                System.out.println("breaking at i = " + i );
                break;
            }
            System.out.println(i);
        }
        System.out.println("loop ended");
    }
}