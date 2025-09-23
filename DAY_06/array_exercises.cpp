#include <iostream>
using namespace std;

void printArr(char str[]){
    if(str[0] == '\0'){
        return;
    }
    cout<<str[0];
    printArr(str + 1);
}

void printReverse(char str[]){
    if(str[0] == '\0'){
        return;
    }
    printReverse(str + 1);
    cout<<str[0];
}
void removeChar(char str[], char ch){
    if(str[0] == '\0')
        return;
    if(str[0] != ch)
        cout<<str[0];
    removeChar(str + 1, ch);
}
void replaceChar( char str[], char oldChar, char newChar){
        if(str[0] == '\0'){
        return;
        }
        if(str[0]==oldChar){
            cout<<newChar;
        }else{
            cout<<str[0];
        }
         replaceChar(str + 1, oldChar, newChar);
}

int arrLength(char str[]){
   if(str[0]=='\0'){
    return 0;
   }
   return 1 + arrLength(str + 1);
}

int main(){
   char str[100];
   int choice;
   char repeat;

   do{
   cout<<" Enter a string: ";
   cin>>str;

   cout<<"choose an operation"<<endl;
   cout<<"  1.print string"<<endl;
   cout<<"  2.print reversed array"<<endl;
   cout<<"  3.remove a character"<<endl;
   cout<<"  4.replace a character"<<endl;
   cout<<"  5.find length"<<endl;
   cout<<"  Enter a choice: ";
   cin>>choice;

   switch(choice){
     case 1:
        printArr(str);
        break;
     case 2:
        printReverse(str);
        break;
     case 3: {
         char ch;
         cout<<"enter a character to be removed: ";
         cin>>ch;
         removeChar(str, ch);
         break;
     }
     case 4:{
         char oldChar, newChar;
         cout<<"enter the character to be replaced: ";
         cin>>oldChar;
         cout<<"enter the new character: ";
         cin>>newChar;
         replaceChar(str,oldChar,newChar);
         break;
     }
     case 5:
        cout<<"length = "<<arrLength(str);
        break;
     default:
        cout<<"invalid choice";
   }
   cout<<"\nDo you want to continue(y/n)";
   cin>>repeat;
   }while(repeat == 'y' || repeat == 'Y');

   return 0;
}
