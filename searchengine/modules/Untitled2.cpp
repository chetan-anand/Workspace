#include<stdio.h>
#include<string.h>
void index()
{
    char word[200],ch;
    int i,j,k,now,nol,flag;
    FILE *ptr=fopen("text.txt","r");
    while(ptr)
    {
        ch=fgetc(ptr);
        if(ch=='\n'){nol++;continue;}
        if(ch!=' ')
        {
            for(i=0;;i++)
            {
                now++;
                word[i]=ch;
                ch=fgetc(ptr);
                if(ch==' '){puts(word);break;}
                if(ch=='\n'){nol++;break;}
            }
        }
    }
}
int main()
{
    index();
    return 0;
}
