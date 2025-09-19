#include <iostream>
using namespace std;

int isNumPalindrome(int n){
    int original = n;
    int rev = 0;

    while(n > 0){
        int digit = n % 10;
         rev = rev * 10 + digit;
        n/=10;
    }
    return rev;
}

int main(){
    int n;
    cout<<"enter the number to be reversed"<<endl;
    cin>>n;
    int reversed = isNumPalindrome(n);
    cout<<"when "<<n<<"is reversed it's"<<reversed<<endl;
}