#include <iostream>
#include <string>
#include <sstream>

using namespace std;
int main()
{
char st1[50]="chetan";
char ext[8] = ".txt";
  filename[20];
int i;
for(int i = 1; i < 10; i++)
{
stringstream ss;
ss << i;
        filename = st1 + ss.str() + ext;
        cout << filename << "\n";
    }
    return 0;
}

    cout<<st1<<endl;
return 0;
}
