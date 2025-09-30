#include <iostream>
using namespace std;

class persona {
    public :
    string fname;
    string lname;
    int age;
    persona() {}
    persona(string firstname, string lastname, int a) {
        fname = firstname;
        lname = lastname;
        age = a;
    }
    void printme() {
        cout << fname << " " << lname << " " << age << endl;
    }
};

int main() {
    persona p1("ange","mugisha",15);
    persona p2("peter","NEZA",18);
    persona p3("mary","KEZA",20);
    persona *p4 = new persona("Arlene","ISHWIME",14);
    persona p5;
    p5.fname = "Samuel";
    p5.lname = "BYIRINGIRO";
    p5.age = 15;

    p1.printme();
    p2.printme();
    p3.printme();
    p4->printme();
    p5.printme();

    return 0;
}


