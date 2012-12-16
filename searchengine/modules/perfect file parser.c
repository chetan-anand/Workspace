#include<iostream.h>
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
using namespace std;
#define MAX 10000

struct node *ht[MAX];

////////////////////////////////////////////////////////
struct node
{
    char hword[200];
    //int fileno;
    int lineno;
    int wordno;  //type of data in the node
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
//////////////////////////////////////////////////////

int hashfunc(char *a,int size)
{
    int i,count=0,ascii;
    for(i=0;i<size;i++)
    {
        ascii=a[i];
        count=count+ascii;
    }
    return count;
}
///////////////////////////////////////////////////////////




///////////////////////////////////////
void insert(int hvalue,struct node *temp)
{
    struct node *temp1;
    if(ht[hvalue]==NULL){ht[hvalue]=temp;}
    else
    {
        temp1=ht[hvalue];
        while((temp1->ptr)!=NULL)
        {
            temp1=temp1->ptr;
        }
        temp1->ptr=temp;
    }
}

////////////////////////////////////////////

int index()
{
    char ch;
    int i,j,now=0,nol=1,tow=0,hvalue;
    FILE *ptr=fopen("text.txt","r");
    ch=fgetc(ptr);
    while(ch!=EOF)
    {
        //ch=fgetc(ptr);
        if(ch=='\n'){nol++;tow=tow+now;now=0;ch=fgetc(ptr);}
        else if((ch<='z' && ch>='a')||(ch<='Z' && ch>='A'))
        {
            char word[200]={};
            now++;
            for(i=0;(ch<='z' && ch>='a')||(ch<='Z' && ch>='A');i++)
            {
                word[i]=ch;
                ch=fgetc(ptr);
                //if(ch=='\n'){nol++;now=0;}
            }
            //////////////////////////////////////////////////
            struct node *temp1;
            temp1=createnode();
            temp1->lineno=nol;
            temp1->wordno=now;
            for(j=0;j<i;j++)
            {
                temp1->hword[j]=word[j];
            }
            hvalue=hashfunc(word,i);
            void insert(hvalue,temp1);
            //////////////////////////////////////////////////
            puts(word);
            printf("its hash value is %d\n",hvalue);
            printf("word size is %d\n",i);
            printf("its word position is %d ",now);
            printf("its line position is %d",nol);
            printf("\n");
            //printf("b\n");
        }
        else{ch=fgetc(ptr);/*printf("c\n");*/}
    }
    tow=tow+now;
    printf("Total no of words in the file = %d\n",tow);
    printf("Total no of lines in the file = %d\n",nol);
    return 1;
}

void display(int hvalue)
{
    int i;
    struct node *temp;
    temp=ht[hvalue];
    printf("%d",temp);
        while(temp!=NULL)
        {
             puts((temp->hword));
            printf("%d",temp->lineno);
            temp=temp->ptr;
        }

}
int main()
{
    /*index();
    display(830);*/
    int i,j,k;
    for(i=0;i<100;i++)
    {
        cout<<ht[i]<<endl;
    }
    return 0;
}
