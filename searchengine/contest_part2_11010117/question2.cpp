#include<stdio.h>
#include<math.h>
int main()
{
    int i,n,temp,flag,j,a[10000],temp1,p;
    printf("Give the input=");
    scanf("%d",&n);
    temp=2;
    FILE *ptr=fopen("temp.txt","w");
    for(i=0;temp<=n;i++)
    {
        flag=0;
        for(j=2;j<=(sqrt(temp))+1;j++)
        {
            if((temp%j)==0){flag=1;break;}
        }
        if(flag==0)
        {
            //printf("%d ",temp);
            fprintf(ptr,"%d\n",temp);
        }
        temp=(2<<i)+1;
        //printf("a\n");
    }
    fclose(ptr);
    ptr=fopen("temp.txt","r");
    for(i=0;(fscanf(ptr,"%d",&a[i]))==true;i++)
    {

    }
    //printf("i=%d",i);
    p=i;
    for(i=0;i<p;i++)
    {
        //printf("a0\n");
        temp=a[i];
        //temp1=2<<0;
        //temp1=(2<<(temp1-1))+1;
        for(j=1;;j++)
        {
            temp1=2<<(j-1);
            temp1=(2<<(temp1-1))+1;
            //printf("%d",temp1);
            if(temp1==temp)
            {
                printf("%d ",temp);
                break;
            }
            if(temp1>temp){break;}
        }
        //printf("%d \n",temp1);
    }
   printf("\n");
}

