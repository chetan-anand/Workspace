#include<stdio.h>
#include<stdlib.h>
#include<time.h>
int main()
{
    int i,j,k,n;char ch,flag,temp1,temp2,temp3;
    int a[10000];
    printf("Enter the integers:\n");
    for(i=0;ch!='\n';i++)
    {
        scanf("%d%c",&a[i],&ch);
    }
    n=i;
    while(1)
    {
        srand(time(NULL));
        temp1=rand()%n;

        temp2=a[temp1];
        a[temp1]=a[n-1];
        a[n-1]=temp2;
        temp3=rand()%(n-1);
        temp2=a[n-1];
        a[n-1]=a[temp3];
        a[temp3]=temp2;
        /*printf("%d\n",temp1);
        printf("%d\n",temp2);*/

        for(i=0;i<n;i++)
        {
            if(a[i]>a[i+1]){break;}
        }
        if(i==(n-1)){break;}
    }
    for(i=0;i<n;i++)
    {
        printf("%d ",a[i]);
    }
    printf("\n");

    return 0;
}
