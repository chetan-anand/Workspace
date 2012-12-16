#include<stdio.h>
int index()
{
    int i;
    printf("Wait for indexing.............\n");
    for(i=0;i<1000000000;i++)
    {
        i=i*i+1;
    }
    return 1;
}
int main()
{
    int i,j,k;
    char ch='/';
    printf("/////////////////////////////////////////////////\n");
    printf("Welcome to the search engine based on hash table\n");
    printf("press y to index the whole data\n");
    scanf("%c",&ch);
    if(ch=='y')
    {
        if(index())
        {
            printf("Index process complete...............\n");
        }
        else{printf("Some error occured while indexing\n");}
    }

    printf("Now you can continue with the search.......\n");
    printf("Type the word for searching");


    return 0;
}
