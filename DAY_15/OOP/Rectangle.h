#ifndef RECTANGLE_H
#define RECTANGLE_H

#include "Shape.h"

class Rectangle : public Shape{
    private:
           double length;
           double width;
    public:
          Rectangle(double l, double w) : Shape("Rectangle"), length(l),width(w)
          double area() override{
            return length * width;
          }
          void display() override{
            cout<<"Shape: "<<name
                <<"Length: "<<length
                <<"Width: "<<width
                <<"Area: "<<area()<<endl;
          }
};

#endif