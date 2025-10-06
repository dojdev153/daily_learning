#ifndef SHAPE_H
#define SHAPE_H


#include <iostream>
#include <string>
using namespace std;

class Shape{
    protected:
           string name;
    public:
          Shape(string n) : name(n){}
          virtual double area() = 0;
          virtual void display(){
            cout<<"Shape: "<<name<<endl;
          }
};