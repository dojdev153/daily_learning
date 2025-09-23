#include <iostream>
#include <array>
using namespace std;

int main(){
   int arr[] = {10,20,30,40,50};
   for(int i=0;i<5;i++){
    cout<<arr[i]<<" ";
   }
   cout<<endl;
   cout<<"The first element is "<<arr[0]<<endl;
   cout<<"The first element using pointer"<<*arr<<endl;
   for(int i=0;i<5;i++){
    cout<<*(arr + i)<<" ";
   }
   cout<<endl;
   return 0;
}
