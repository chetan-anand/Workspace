#include<stdio.h>
#include<string.h>

void index()
{
    char a[20],ch;
    int i,now,nol;
    FILE *ptr=fopen("text.txt","r");
    now=0;
    while(ch!=EOF)
    {
        now=fscanf(ptr,"%s",a);
        puts(a);
        ch=fgetc(ptr);
    }
    printf("%d",now);
    printf("%d",nol);

}

int main()
{
    index();
    return 0;
}
