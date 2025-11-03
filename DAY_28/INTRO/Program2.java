package DAY_28.INTRO;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        int arr[] = {10,2,30,43,61,50};
        int max = arr[0];
        int min = arr[1];
        int oddCount = 0;
        int evenCount = 0;

        Scanner sc = new Scanner(System.in);

        for(int i=0;i < arr.length;i++){
            if(arr[i] > max){
                max = arr[i];
            }
            if(arr[i] < min){
                min = arr[i];
            }
            if(arr[i]%2 == 0){
                evenCount++;
            }else{
                oddCount++;
            }
        }
        System.out.println("max: " + max);
        System.out.println("min: " + min);
        System.out.println("Even: " + evenCount);
        System.out.println("Odd: " + oddCount);

        System.out.println("enter an element to be searched: ");
        int key = sc.nextInt();
        int index = -1;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == key){
                index = i;
                break;
            }
        }
        if(index == -1){
            System.out.println("Element not found");
        }else{
            System.out.println("Element found at index: " + index);
        }
        
        System.out.println("Table of 5");
        int prod = 1;
        for(int i=1;i<=10; i++){
            prod = i * 5;
            System.out.println(i + " * 5 = " + prod);
        }
        System.out.println();
        System.out.println("factorial of a number: ");
        int num = sc.nextInt();
        int fact = 1;
        for(int i =1;i <= num;i++){
            fact *=i;
        }
        System.out.println("factorial of " + num + " is " + fact);
    }
}
