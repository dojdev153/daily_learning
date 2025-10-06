#include "Shape.h"
#include "Rectangle.h"
#include "Square.h"


int main() {
    Shape* shapes[3];

    shapes[0] = new Rectangle(4.5, 2.0);
    shapes[1] = new Square(3.0);
    shapes[2] = new Circle(2.5);

    cout << "=== Displaying Shape Information ===\n";
    for (int i = 0; i < 3; i++) {
        shapes[i]->display();
        cout << endl;
    }


    for (int i = 0; i < 3; i++) {
        delete shapes[i];
    }

    return 0;
}
