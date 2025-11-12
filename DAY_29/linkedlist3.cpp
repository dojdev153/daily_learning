#include <iostream>
#include <string>
using namespace std;

template <typename T>
class Node {
public:
    T data;
    Node<T>* next;

    Node(T d) {
        data = d;
        next = NULL;
    }

    void display(Node<T>* head) {
        while (head != NULL) {
            cout << head->data << "->";
            head = head->next;
        }
        cout << "NULL" << endl;
    }
};

int main() {
    Node<int>* n1 = new Node<int>(10);
    Node<int>* n2 = new Node<int>(20);
    Node<int>* n3 = new Node<int>(30);
    n1->next = n2;
    n2->next = n3;

    n1->display(n1);

    return 0;
}
