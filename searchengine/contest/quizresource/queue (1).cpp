#include<iostream>
#include<stdio.h>
#include<stdlib.h>



// declaring queue class

class Queue
{
	public:
	int a[1000];
	int front;
	int end;
	Queue()
	{
		front=-1;
		end=0;
	}
	void push(int n)
	{
		//position++;
		a[++front]=n;		
	}

	int pop()
	{
		/*int temp;
		temp=position;
		position--;*/
		return a[end++];     //post decreament decreament after assigning the value
	}

	void display()
	{
		int i;
		printf("the queue is:");
		for(i=end;i<=front;i++)
		{
			printf(" %d",a[i]);
		}
		printf("\n");
	}
};	




int main()
{
	int i,n,size;
	printf("Enter the size of Queue=");
	scanf("%d",&size);
	Queue o1;
	while(1)
	{
		printf("Chose a option\n");
		printf("1.Insert\n2.Delete\n3.Display\n4.Not want to continue\n");
		scanf("%d",&i);
		if(i==1)
		{
			printf("Insert the number=");
			scanf("%d",&n);
			if(o1.front<=size-1)
			{o1.push(n);}
			else{printf("the queue is overflowed\n");}
		}
		if(i==2)
		{
			if(o1.front>=o1.end)
			{
				i=o1.pop();
				printf("%d is deleted from Queue.\n",i);
			}
			else{printf("Queue is empty\n");}
		}
		if(i==3)
		{
			if(o1.front>=o1.end)
			{
				o1.display();
			}
			else{printf("Queue is empty\n");} 			
		}	
		if(i==4)
		{
			break;
		}
	}
		
	return 0;
}
