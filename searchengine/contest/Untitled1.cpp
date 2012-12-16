#include<stdio.h>
#include<string.h>
#include<stdlib.h>

int main()
{
    int i,j,n,temp,flag,flag1,flag2;
    char ch='-';
    int *a=10000*malloc(sizeof(int));

    for(i=0;ch!='\n';i++)
    {
        scanf("%d%c",&a[i],&ch);
    }
    //printf("%d\n",i);
    n=i;
    int *b=n*malloc(sizeof(int));
    for(i=0;i<n;i++)
    {
        b[i]=a[i];
    }
    free(a);

///////////////////////////////////////////////////////////////////////////////////
while(1)
 {
     i=0;
    while(i<=n)
    {
        flag1=0;
        if(i==0)
        {
            temp=(rand())%n+1;
            b[0]=temp;i++;
            continue;
        }
        temp=(rand())%n+1;
        for(j=0;j<i;j++)
        {
            if(temp==b[j]){flag1=1;break;}
        }
        if(flag1==0)
        {
            b[i]=temp;i++;
        }
    }

    for(i=0;i<n-1;i++)
    {
        if(b[i]>b[i+1]){break;}
    }
    if(i==n-2)
    {
        for(j=0;j<n;j++)
        {
            printf("%d ",b[i]);break;
        }
        printf("\n");
        break;
    }
}
free(b);
    return 0;
}
