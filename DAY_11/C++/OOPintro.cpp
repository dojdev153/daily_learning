#include <iostream>
using namespace std;

struct person {
    string fname;
    string lname;
    int age;
    person() {}
    person(string firstname, string lastname, int a) {
       this.fname = firstname;
        this.lname = lastname;
        this.age = a;
    }
    void printme() {
        cout << fname << " " << lname << " " << age << endl;
    }
};

int main() {
    person p1("ange","mugisha",15);
    person p2("peter","NEZA",18);
    person p3("mary","KEZA",20);
    person *p4 = new person("Arlene","ISHWIME",14);
    person p5;
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
