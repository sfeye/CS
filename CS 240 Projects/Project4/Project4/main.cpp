


#include<iostream>
#include<string>
#include"BinaryTreeLinked.h"
using namespace std;

int main()
{
    int counts[10];
    BinaryTreeLinked<int> intBT;
    intBT.printInorder();
    intBT.countNodesPerLevel(counts, intBT.levels, 0);
    intBT.countParentTypes(counts);
    return 0;
}
