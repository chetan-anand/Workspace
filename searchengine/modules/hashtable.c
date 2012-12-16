#include<stdio.h>
#include<stdlib.h>
#define MAX 10000
struct node *ht[MAX]={NULL};
int *a[100];
////////////////////////////////////////////////////////
struct node
{
    char word[20];
    int fileno;
    int lineno;
    int data;  //type of data in the node
    struct node *ptr;   //pointer data in the node
};


//  defining the createnode function which returns the node type adress
struct node *createnode()
{
    struct node *temp;
    temp=(struct node*)malloc(sizeof(struct node));
    temp->ptr=NULL;
    return temp;
};
////////////////////////////////////////////////
int main()
{
    int i;
    printf("kahsbd\n");
    for(i=0;i<20;i++)
    {
        printf("%c\n",a[i]);
    }
    return 0;
}
