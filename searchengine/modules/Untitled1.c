#include<stdio.h>
int main()
{
    int t,n,x,i,j,cnt,div,min;
    int a;
    scanf("%d",&t);
    while(t--)
    {
        cnt=0;
        scanf("%d %d",&n,&x);
        for(i=0;i<n;i++)
        {
            scanf("%d",&a);
            if(i==0){min=a;}
            if(a<min){min=a;}
            cnt=cnt+a;
        }
        div=cnt/x;
        if((cnt-min)>=(div*x)){printf("-1\n");}
        else{printf("%d\n",cnt/x);}
    }
    return 0;
}
