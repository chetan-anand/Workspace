#include<iostream>
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include <string>
#include <sstream>
using namespace std;
#define MAX 100000

struct node *ht[MAX]={NULL};

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
    int i,count=0;
    for(i=0;i<size;i++)
    {
        count=count+a[i]*(i+1);
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

//////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////It is the most important function of this programme. It read all the words (neglecting the special charatcters) and extracting the important information like  1.No of lines 2.No of words. 3.Word and line loaction of a particular word.

int index(const char *fname)
{
    char ch;
    int i,j,now=0,nol=1,tow=0,hvalue;
    struct node *temp1;
    FILE *ptr=fopen(fname,"r");
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
            temp1=createnode();
            temp1->lineno=nol;
            temp1->wordno=now;
            for(j=0;j<i;j++)
            {
                temp1->hword[j]=word[j];
            }
            hvalue=hashfunc(word,i);
            insert(hvalue,temp1);
            //////////////////////////////////////////////////
            puts(word);
            printf("its hash value is %d\n",hvalue);
            printf("word size is %d\n",i);
            printf("its word position is %d ",now);
            printf("its line position is %d",nol);
            printf("\n");
        }
        else{ch=fgetc(ptr);/*printf("c\n");*/}
    }
    tow=tow+now;
    printf("Total no of words in the file = %d\n",tow);
    printf("Total no of lines in the file = %d\n",nol);
    return 1;
}
//////////////////////////////////////////////////////////////
//////////////display all the content in the given bucket of a particular hash value
void display(int hv alue)
{
    struct node *temp;
    temp=ht[hvalue];
    cout<<temp<<endl;
    if(temp!=NULL)
        while(temp!=NULL)
        {
            puts(temp->hword);
            printf("%d ",temp->lineno);
            printf("%d\n",temp->wordno);
            temp=temp->ptr;
        }
    else
    {
        printf("Sorry there is no word in the file which you have typed\n");
    }
}

//////////////////////////////////////////////////
void dispword(int hvalue,char *sword)
{
    struct node *temp;
    temp=ht[hvalue];
    if(temp!=NULL)
    {
        while(temp!=NULL)
        {
            if(strncmp(temp->hword,sword,strlen(sword))==0)
            {
                puts(temp->hword);
                printf("%d ",temp->lineno);
                printf("%d\n",temp->wordno);
            }
            temp=temp->ptr;
        }
    }

}

//////////////////reading string from input///////////
void searching()
{
    int hvalue;
    char sword[100];
    scanf("%s",sword);
    puts(sword);
    //printf("the word lenth is %d\n",strlen(sword));
    hvalue=hashfunc(sword,strlen(sword));
    //display(hvalue);
    dispword(hvalue,sword);
}
///////////////////////////////////////////////////////////////

void filename()
{



}

////////////////////////////////////////////////////////////


int main()
{
    //index();
    //display(3810);


    int i;
    char ch='/';
    const char fname[53]="text.txt";
    printf("/////////////////////////////////////////////////\n");
    printf("Welcome to the search engine based on hash table\n");
    printf("press y to index the whole data\n");
    scanf("%c",&ch);
    if(ch=='y')
    {
        if(index(fname))
        {
            printf("Index process complete...............\n");
        }
        else{printf("Some error occured while indexing\n");}
    }
    //display(3810);
    printf("Now you can continue with the search.......\n");
    printf("Type the word for searching\n");
    while(ch=='y')
    {
        searching();
        printf("do you want to continue searching (y/n)? ");
        getchar();
        scanf("%c",&ch);
        //scanf("%c")
    }

    return 0;
    /*struct node *temp;
    temp=createnode();
    ht[2]=temp;
    temp->lineno=12;
    temp->ptr=createnode();
    temp=temp->ptr;
    temp->lineno=15;
    for(i=0;i<10;i++)
    {
        cout<<ht[i]<<endl;
        if(ht[i]!=NULL)
        {
            struct node *temp1;
            temp1=ht[i];
            //printf("%d",temp1);
            while(temp1!=NULL)
            {
                //puts((temp->hword));
                printf("%d ",temp1->lineno);
                temp1=temp1->ptr;
            }
            printf("\n");
        }
    }*/

    //return 0;
}
