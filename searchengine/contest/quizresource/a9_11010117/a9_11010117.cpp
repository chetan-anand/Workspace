#include <stdlib.h>
#include <fstream>
#include <string>
#include <iostream>
using namespace std;

class Record
{
	protected:
		struct Node
		{
			char letter;
			Node *Top, *Bottom, *RightSide;
			string rollno,webmail_id;
		};
	public:
		Node *first,*next,*prev,*temp,*temp1;
		int buildList();
		int searching(string);
		void delRecord( );
		void delNode(Node *);
};

int Record::buildList()
{
	string name,line,rollno,webmail_id;
	ifstream myfile;
	myfile.open ("Record.txt");
	int a,b=0,c=0;
	if(!myfile)
	{
		cout<<"FILE NOT FOUND!\n\n";
		return 1;
	}
	first=new Node();
	first->Bottom=NULL;
	first->Top=NULL;
	first->RightSide=NULL;
	for(int i=0;i<83;i++)
	{
		getline(myfile,line);
		b=0;c=0;
		int b=line.find('\t');
		rollno=line.substr(0,b);
		b++;
		c=line.find('\t',b);
		name=line.substr(b,c-b);
		c++;
		webmail_id=line.substr(c,line.length()-1);
		for(int j=0;j<name.length();j++)
		{
			if(i==0&&j==0)
			{
				next=new Node();
				next->Bottom=NULL;
				next->RightSide=NULL;
				next->Top=first;
				next->letter=name[j];
				first->Bottom=next;
				prev=next;
			}
			else
			{
				if(j==0)
				{
					prev=first;
				}
				if(prev->Bottom !=NULL)
				{
					for(temp=prev->Bottom;(temp!=NULL);temp=temp->RightSide)
					{
						if(temp->letter==name[j])
						{
							next=temp;
							prev=next;
							a=1;break;
						}
					}
				}
				if(a!=1)
				{
					if(prev->Bottom==NULL)
					{
						Node *next=new Node();
						next->Bottom=NULL;
						next->RightSide=NULL;
						next->Top=prev;
						next->letter=name[j];
						prev->Bottom=next;
						prev=next;
					}
					else
					{
						for(temp1=prev->Bottom;temp1!=NULL;temp1=temp1->RightSide)
						{
							if(temp1->RightSide==NULL)
							{
								Node *next=new Node();
								next->Bottom=NULL;
								next->RightSide=NULL;
								next->Top=prev;
								next->letter=name[j];
								temp1->RightSide=next;
								prev=next;
								break;
							}
						}
					}
				}
				a=0;
			}
		}
		Node *A=new Node();
		A->RightSide=NULL;
		A->Bottom=NULL;
		A->letter='$';
		A->Top=prev;
		prev->Bottom=A;
		prev->Bottom->rollno=rollno;
		prev->Bottom->webmail_id=webmail_id;
	}
	myfile.close();
	return 0;
}

int Record::searching(string s)
{
	prev=first;
	int notfound=0,x=0;
	for(int j=0;j<s.length();j++)
	{
		notfound=0;
		for(temp=prev->Bottom;temp!=NULL;temp=temp->RightSide)
		{
			if(s[j]==(temp->letter))
			{
				prev=temp;
				notfound=1;
				break;
			}
		}
		if(notfound != 1 )
		{
			cout<<"------------------------------------------------------\n";
			cout<<"There is no student with such name.................\n";
			return 2;
		}
	}
	if((prev->Bottom)->letter=='$')
	{
		cout<<"------------------------------------------------------\n";
		cout << s <<endl;
		cout << "The rollno number of the student is:\t" << prev->Bottom->rollno<<"\n";
		cout << "The webmail_id id of the student is:\t" << prev->Bottom->webmail_id<<"\n";
        return 1;
	}
	cout<<"There is no student with such name.................\n\n";
}

void Record::delRecord()
{
	prev=first;
	temp=prev->Bottom;
	temp1=temp;
	do
	{
		do
		{
			temp=temp1;
			temp1=temp->Bottom;
		}while(temp1!=NULL);
		temp1=temp->RightSide;
		if(temp1==NULL)
		{
			temp1=temp->Top;
		}
		delNode(temp);
		temp=temp1;
		if(temp1==first)
		{
			break;
		}
	}while(temp!=NULL);
}

void Record::delNode(Node* box)
{
	if(box->Top->Bottom==box)
	{
		box->Top->Bottom=box->RightSide;
		delete(box);
	}
	else
	{
		temp=box->Top->Bottom;
		temp1=temp;
		do
		{
			temp=temp1;
			temp1=temp->RightSide;
		}while(temp1==box);
		temp->RightSide=temp1->RightSide;
		delete(box);
	}
}

int main()
{
	Record Record;
	int u,i,j;
	string input;
	u=Record.buildList();
	if(u==1)
	{
		return 0;
	}
	cout<<"Enter the full name of the student in capital letters\n";
	    getline(cin,input);
        for(i=0;i<input.length();i++)
        {
            if(input[i]>=97&&input[i]<=122)
            {
                input[i]=input[i]-32;
            }
        }
        Record.searching(input);
        if(u==2)
        {
            cout<<"There is no student with such name.................\n";
        }

	Record.delRecord();
	return 0;
}
