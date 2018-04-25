#pragma once
#include<iostream>
using namespace std;

typedef int DynamixArraListElementType;

class DynamicArrayList
{
protected:
    int size, front, rear;
    static const int MAX_SIZE = 100;
    DynamixArraListElementType list[MAX_SIZE];
public:
    DynamicArrayList();
    DynamicArrayList(const DynamicArrayList& l);
    ~DynamicArrayList();
};

