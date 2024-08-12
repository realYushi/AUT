// Name : Yushi Cui
// Student ID : 23196152
#include <stdio.h>
#include <stdlib.h>
#include "listfuncs.h"

int insert(struct List_item *listHead, struct List_item *insertItem)
{

    // invalid input
    if (insertItem == NULL || listHead == NULL)
    {
        return 0;
    }
    List_item *current = listHead;
    List_item *previous = NULL;

    // can't inserted before listHead
    if (current->pcb->pid > insertItem->pcb->pid)
    {
        return 0;
    }
    // Handle insertion at the beginning of the list
    if (current->next == NULL)
    {
        current->next = insertItem;
        return 1;
    }

    while (current != NULL)
    {
        // duplicate pid
        if (insertItem->pcb->pid == current->pcb->pid)
        {
            return 0;
        }
        if ((insertItem->pcb->pid) < (current->pcb->pid))
        {
            break;
        }
        previous = current;
        current = current->next;
    }
    previous->next = insertItem;
    insertItem->next = current; // NULL if insert at the end

    return 1;
}
int delete(struct List_item *listHead, int pid)
{

    // invalided input
    if (listHead == NULL)
    {
        return 0;
    }
    // can't remove the head
    if (listHead->pcb->pid == pid)
    {
        return 0;
    }
    List_item *current = listHead;
    List_item *previous = NULL;
    while (current != NULL)
    {
        if (current->pcb->pid == pid)
        {
            break;
        }
        previous = current;
        current = current->next;
    }
    // don't find the pid
    if (current == NULL)
    {
        return 0;
    }
    previous->next = current->next;
    return 1;
}
void printList(struct List_item *listHead)
{
    List_item *current = listHead;
    while (current != NULL)
    {
        printf("%d - %s\n", current->pcb->pid, current->pcb->process_name);
        current = current->next;
    }
    printf("\n");
}