// Program 3
// Samuel Feye
// Professor Klein CS240
// 03-25-2018
// SortedArrayList.h
// Copyright © 2018 Sam Feye. All rights reserved.

#pragma once
#include<iostream>
using namespace std;

typedef string SortedArrayListElementType;

class SortedArrayList
{
protected:
    int size;
    int numSizes[10];
    int myCount = -1;
    static const int MAX_SIZE = 50;
    SortedArrayListElementType list[MAX_SIZE];
public:
    SortedArrayList();
    int getMyCount();
    int getNumSize(int pos);
    int getSize() const;
    //overloaded stream operators
    friend istream& operator >> (istream& is, SortedArrayList& l);
    friend ostream& operator << (ostream& os, SortedArrayList& l);
    //Utility functions
    bool insertAt(SortedArrayListElementType elt, int position);
    bool removeAt(SortedArrayListElementType &elt, int position);
    void insertSorted(SortedArrayListElementType elt);
    void sortArrayLengths();
    void sortArrayValues();
    void deleteList();
    bool push(SortedArrayListElementType elt);
    bool pop(SortedArrayListElementType& elt);
};

