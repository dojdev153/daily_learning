#include <stdio.h>

int main() {
    int a, c;
    int x = 7;
    int y = 9;

    printf("x=%d and y=%d\n", x, y);

    a = ++x;
    c = y++;
    printf("x=%d and y=%d\n", x, y);
    printf("a=%d and c=%d\n", a, c);

    a = --x;
    c = y--;
    printf("x=%d and y=%d\n", x, y);
    printf("a=%d and c=%d\n", a, c);

    return 0;
}
