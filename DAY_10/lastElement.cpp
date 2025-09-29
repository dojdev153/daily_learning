#include <iostream>
using namespace std;

int lastElement(int arr[], int n){
   if(n == 1)
        return arr[0];
   else
       return lastElement(arr+1, n-1);
}
int firstElement(int arr[], int n){
         return arr[0];
}

int main(){
       char playagain;
    do{
   int n;
   cout<<"Enter the number of elements that array will hold: ";
   cin>>n;
   int arr[n];
   cout<<"Enter "<<n<<" elements in you array"<<endl;
   for(int i=0;i<n;i++){
    cin>>arr[i];
   }

   int option;
   cout<<"Choose among these options what you want to get:"<<endl;
   cout<<"  1.Find Last element"<<endl;
   cout<<"  2.Find first element"<<endl;
   cin>>option;

   switch(option){
     case 1:
        cout<<"The last element is: "<<lastElement(arr,n)<<endl;
        break;
     case 2:
        cout<<"The first element is: "<<firstElement(arr,n)<<endl;
        break;
     default:
        cout<<"invalid choice!"<<endl;
   }
   cout<<"Do you want to restart(y/n)";
   cin>>playagain;
    }while(playagain == 'y' || playagain == 'Y');
   return 0;

}
