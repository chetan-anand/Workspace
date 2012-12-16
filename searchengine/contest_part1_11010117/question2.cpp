#include<stdio.h>
#include<string.h>
#include<math.h>
int main()
{
    int i,n,temp,flag,j;
    printf("Give the input=");
    scanf("%d",&n);
    temp=2;
    for(i=0;temp<=n;i++)
    {
        flag=0;
        for(j=2;j<=(sqrt(temp))+1;j++)
        {
            if((temp%j)==0){flag=1;break;}
        }
        if(flag==0)
        {
            printf("%d ",temp);
        }
        temp=(2<<i)+1;
        //printf("a\n");
    }
    printf("\n");
}
