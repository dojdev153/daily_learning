#ifndef SQUARE_H
#define SQUARE_H

#include "Shape.h"

class Square : public Shape{
    private:
           double side;
    public:
           Square(double s) : Shape("Square"), side(s){}
           double area() override{
            return side * side;
           }
           void display() override{
            cout<<"Shape: "<<name<<" Side: "<<" Area: "<<area()<<endl;
           }
};

#endif