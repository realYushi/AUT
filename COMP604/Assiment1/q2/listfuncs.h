// Name : Yushi Cui
// Student ID : 23196152
#ifndef LISTFUNCS_H
#define LISTFUNCS_H
typedef struct Pcb
{
    int pid;
    char *process_name;
} Pcb;
typedef struct List_item
{
    Pcb *pcb;
    struct List_item *next;
} List_item;

int insert(struct List_item *listHead, struct List_item *insertItem);
int delete(struct List_item *listHead, int pid);
void printList(struct List_item *listHead);

#endif