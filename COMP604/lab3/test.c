// A simple linked list
#include <stdio.h>
#define null 0
struct List_item
{
    int item_num;
    struct List_item *next;
};
int insert_last(struct List_item *head, struct List_item *item);
int main()
{
    // Create five individual items
    // 0 - 3 - 2 - 4 - 1
    struct List_item head = {0, null};
    struct List_item i1 = {1, null};
    struct List_item i2 = {2, null};
    struct List_item i3 = {3, null};

    struct List_item i4 = {4, null};
    struct List_item i5 = {5, null};
    // Now link them up in the order 0-1-2-3-4
    head.next = &i3;
    i3.next = &i2;
    i2.next = &i4;
    i4.next = &i1;
    // Go through the list and print the numbers in the order of the list
    struct List_item *current = &head;
    while (current != null)
    {
        printf("%d-", current->item_num);
        current = current->next;
    }
    printf("\n");
    return 0;
}

int insert_last(struct List_item *head, struct List_item *item)
{
    if (head == null || item == null)
    {
        return 0;
    }

    struct List_item *current = head;

    while (current->next != null)
    {
        current = current->next;
    }
    current->next = item;
    return 1;
}
