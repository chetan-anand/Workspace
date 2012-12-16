#include<iostream>
#include<stdio.h>
#include<stdlib.h>

// declaring stack class
class Stack
{
	public:
	int a[1000];
	int position;
	Stack()
	{
		position=-1;
	}
	int push(int n)
	{
		position++;
		a[position]=n;
		return position;		
	}

	int pop()
	{
		/*int temp;
		temp=position;
		position--;*/
		return a[position--];     //post decreament decreament after assigning the value
	}

	void display()
	{
		int i;
		printf("the stack is:");
		for(i=0;i<=position;i++)
		{
			
			printf(" %d",a[i]);
		}
		printf("\n");
	}
};	




int main()
{
	int i,n,size;
	printf("Enter the size of Stack=");
	scanf("%d",&size);
	Stack o1;
	while(1)
	{
		printf("Chose a option\n");
		printf("1.Insert\n2.Delete\n3.Display\n4.Not want to continue\n");
		scanf("%d",&i);
		if(i==1)
		{
			printf("Insert the number=");
			scanf("%d",&n);
			o1.push(n);
		}
		if(i==2)
		{
			i=o1.pop();
			printf("%d is deleted from stack.",i);
		}
		if(i==3)
		{
			o1.display(); 			
		}	
		if(i==4)
		{
			break;
		}
	}
		
	return 0;
}
