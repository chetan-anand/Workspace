#include<stdio.h>
#include<iostream>
#include<string.h>
#include<fstream>

using namespace std;

void index()
{
    char a[20],ch;
    int i,now,nol;
    now=0;nol=0;
    ifstream in ( "text.txt" );
    char word[200];
    while(in)
    {
        in>>word;
        //ch=in.peek();
        if(ch=='\0'){nol++;}
        now++;
        puts(word);
        cout<<strlen(word)<<endl;
    }
    cout<<"the no of word is "<<now<<endl;
    cout<<"the no of line is "<<nol<<endl;
}

int main()
{
    index();
    return 0;
}

