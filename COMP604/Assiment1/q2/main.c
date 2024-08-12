// Name : Yushi Cui
// Student ID : 23196152
#include "listfuncs.h"
#include <stdio.h>
void checkResult(int result);
int main(int argc, char const *argv[])

{
    // inital pcb and list_item
    Pcb pcbA = {0, "Process 0"};
    List_item itemA = {&pcbA, NULL};
    Pcb pcbB = {1, "Process 1"};
    List_item itemB = {&pcbB, NULL};
    Pcb pcbC = {2, "Process 2"};
    List_item itemC = {&pcbC, NULL};
    Pcb pcbD = {3, "Process 3"};
    List_item itemD = {&pcbD, NULL};
    Pcb pcbE = {4, "Process 4"};
    List_item itemE = {&pcbE, NULL};
    // incorrect one, with same pip
    Pcb pcbF = {4, "Process 5"};
    List_item itemF = {&pcbF, NULL};
    // set header
    List_item *header = &itemA;
    // insert
    printf("test insert\n");
    printList(header);
    checkResult(insert(header, &itemB));
    printList(header);
    checkResult(insert(header, &itemC));
    printList(header);
    checkResult(insert(header, &itemD));
    printList(header);
    checkResult(insert(header, &itemE));
    printList(header);
    checkResult(insert(header, &itemF));
    printList(header);
    // delete
    printf("test delete\n");
    checkResult(delete (header, itemB.pcb->pid));
    printList(header);
    checkResult(delete (header, itemC.pcb->pid));
    printList(header);
    checkResult(delete (header, itemD.pcb->pid));
    printList(header);
    checkResult(delete (header, itemE.pcb->pid));
    printList(header);
    checkResult(delete (header, itemF.pcb->pid));
    printList(header);
}
void checkResult(int result)
{
    if (result == 0)
    {
        printf("!!!!!Operation failed!!!!!\n");
    }
    else
    {
        printf("Operation Success\n");
    }
}
