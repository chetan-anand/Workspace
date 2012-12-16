#include<stdio.h>
#include<string.h>

/*struct *node
{
    int

}*/

void index()
{
    char ch;
    int i,j,k,now=0,nol=1,flag;
    FILE *ptr=fopen("text.txt","r");
    ch=fgetc(ptr);
    while(ch!=EOF)
    {
        //ch=fgetc(ptr);
        if(ch=='\n'){nol++;now=0;ch=fgetc(ptr);}
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
            puts(word);
            printf("word size is %d\n",i);
            printf("its word position is %d ",now);
            printf("its line position is %d",nol);
            printf("\n");
            //printf("b\n");
        }
        else{ch=fgetc(ptr);/*printf("c\n");*/}
    }
}
int main()
{
    index();
    return 0;
}
