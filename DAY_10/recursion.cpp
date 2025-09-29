#include <iostream>
using namespace std;

string removeConsecutive(string str) {
    if (str.length() <= 1) {
        return str;
    }
    if (str[0] == str[1]) {
        return removeConsecutive(str.substr(1));
    } else {
        return str[0] + removeConsecutive(str.substr(1));
    }
}

int main() {
    string s;
    cout << "Enter a string: ";
    cin >> s;

    cout << "After removing consecutive duplicates: "
         << removeConsecutive(s) << endl;

    return 0;
}
