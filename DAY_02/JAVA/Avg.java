public class Avg{
    public static void main(String[] a){
        int arr[] = {1,2,3,4,5,6,7,8,9,11};
        int sum = 0; 
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
        }
        float avg = (float)sum/arr.length;
        System.out.println("avg is " + avg);
    }
}