#include <iostream>
#include <string>
using namespace std;

class Animal {
protected:
    string name;

public:
    Animal(string n) : name(n) {}
    virtual void makeSound() {
        cout << name << " makes a sound." << endl;
    }
    virtual ~Animal() {}
};

class Person : public Animal {
public:
    Person(string n) : Animal(n) {}
    void makeSound() override {
        cout << name << " says: Hello!" << endl;
    }
};

class Dog : public Animal {
public:
    Dog(string n) : Animal(n) {}
    void bark() {
        cout << name << " barks: Woof! Woof!" << endl;
    }
    void makeSound() override {
        bark();
    }
};

class Cow : public Animal {
public:
    Cow(string n) : Animal(n) {}
    void makeSound() override {
        cout << name << " moos:Moo" << endl;
    }
};

class Cat : public Animal {
public:
    Cat(string n) : Animal(n) {}
    void makeSound() override {
        cout << name << " meows: Meow~" << endl;
    }
};

int main() {
    Person p("Frank");
    Dog d("Buddy");
    Cow c("Bella");
    Cat cat("Mimi");

    p.makeSound();
    d.makeSound();
    c.makeSound();
    cat.makeSound();

    cout << endl << "🐾 All animals made their sounds successfully!" << endl;
    return 0;
}
