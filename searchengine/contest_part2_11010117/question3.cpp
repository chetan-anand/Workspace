#include<stdio.h>
#include<stdlib.h>
/*int main()
{
    long long int n;
    long long int ans;
    printf("Enter the value of n:=");
    scanf("%lld",&n);
    ans=2<<(n-1);
    printf("%lld",ans);
    return 0;
}*/
long double power(int n)
{
    long double temp1;
    long double temp2;
    if(n==1){return 2;}
    if(n==0){return 1;}
    if(n%2==0)
    {
        temp1=power(n/2);
        return temp1*temp1;
    }
    else
    {
        temp1=power(n/2);
        temp2=power((n/2)+1);
        return temp1*temp2;
    }
}

int main()
{
    int n;
    long double ans;
    printf("Enter the value of n:=");
    scanf("%d",&n);
    ans=power(n);
    //ans=2<<(n-1);
    printf("%0.0f",ans);
    return 0;
}
