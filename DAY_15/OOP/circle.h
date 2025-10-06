#ifndef CIRCLE_H
#define CIRCLE_H

#include "Shape.h"
#include <cmath>

class Circle : public Shape {
private:
    double radius;

public:
    Circle(double r) : Shape("Circle"), radius(r) {}
    double area() override {
        return M_PI * radius * radius;
    }
    void display() override {
        cout << "Shape: " << name
             << "Radius: " << radius
             << "Area: " << area() << endl;
    }
};

#endif
