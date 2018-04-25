#pragma once
#include<iostream>
using namespace std;

typedef int ElementType;

class StaticArrayList
{
protected:
    int size;
    static const int MAX_SIZE = 100;
    ElementType list[MAX_SIZE];
public:
    StaticArrayList();
    int getSize() const;
    bool insertAt(StaticArrayElementType elt, int position);
    bool removeAt(StaticArrayElementType &elt, int position);
    void deleteList();
    bool insertSorted(StaticArrayElementType elt);
    bool remove(StaticArrayElementType elt);
};
