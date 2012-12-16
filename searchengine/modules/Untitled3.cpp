#include<iostream>
#include<stdio.h>
using namespace std;

int main()
{
    char word[100],ch='?';
    while(ch!='\n')
    {
        scanf("%s",word);
        ch=getchar();
        cout<<word<<endl;
    }
    return 0;
}
