// main.cpp
#include <iostream>
#include "./operationsHeader.h" // include your custom header

using namespace std;

int main() {
    int a = 10, b = 5;

    cout << "Sum: " << add(a, b) << endl;
    cout << "Difference: " << subtract(a, b) << endl;
    cout << "Product: " << multiply(a, b) << endl;
    cout << "Quotient: " << divide(a, b) << endl;

    return 0;
}
