#include <stdio.h>
extern int c;

void main() 
{
    int a, b;
   a = 4;
   b = 2;
   c = a + b;
   printf("Result of addition is %d\n", c);
}
