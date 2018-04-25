// Program 3
// Samuel Feye
// Professor Klein CS240
// 03-25-2018
// SortedArrayList.cpp
// Copyright © 2018 Sam Feye. All rights reserved.

#include<iostream>
#include<string>
#include <cassert>
#include "SortedArrayList.h"
using namespace std;

SortedArrayList::SortedArrayList()
{ size = 0; }
int SortedArrayList::getMyCount()
{ return myCount; }
int SortedArrayList::getNumSize(int pos)
{
    assert((pos >= 0) && (pos <= myCount));
    return numSizes[pos];
}
int SortedArrayList::getSize() const
{ return size; }
istream& operator >> (istream& is, SortedArrayList& l)
{
    l.myCount++;
    is >> l.numSizes[l.myCount];
    return is;
}
//prints out the sorted array neatly
ostream& operator << (ostream& os, SortedArrayList& l)
{
    l.sortArrayValues();
    l.sortArrayLengths();
    for(int i = 0; i < l.size; i++)
    {
        //add an extra enter space if the length of the number increases
        if(l.list[i+1].length() > l.list[i].length() && (i+1) < l.size)
            os << l.list[i] << endl << endl;
        else
            os << l.list[i] << endl;
    }
    return os;
}
void SortedArrayList::deleteList()
{ size = 0; }

bool SortedArrayList::insertAt(SortedArrayListElementType elt, int position)
{
    if ((position < 0) || (position > size) || (size >= MAX_SIZE))
        return false;
    for (int i = size; i > position; i--)
        list[i] = list[i - 1];
    list[position] = elt;
    size++;
    return true;
}

bool SortedArrayList::removeAt(SortedArrayListElementType &elt, int position)
{
    if ((position < 0) || (position > size - 1))
        return false;
    elt = list[position];
    for (int i = position; i < size; i++)
        list[i] = list[i + 1];
    size--;
    return true;
}
//used to get the number array in order of length of string
void SortedArrayList::sortArrayLengths()
{
    for (int i = 0 ; i < size; i++)
    {
        SortedArrayListElementType temp = list[i];
        int j = i - 1;
        while (j >= 0 && temp.length() < list[j].length())
        {
            list[j+1] = list[j];
            j--;
        }
        list[j+1] = temp;
    }
}
//used to get the number array in order of value of integer
void SortedArrayList::sortArrayValues()
{
    for (int i = 0 ; i < size; i++)
    {
        SortedArrayListElementType temp = list[i];
        int j = i - 1;
        while (j >= 0 && stoi(temp) < stoi(list[j]))
        {
            list[j+1] = list[j];
            j--;
        }
        list[j+1] = temp;
    }
}
//used to add the numbers to the list
bool SortedArrayList::push(SortedArrayListElementType elt)
{
    assert(elt.length() <= MAX_SIZE);
    return insertAt(elt, size);

}

bool SortedArrayList::pop(SortedArrayListElementType& elt)
{ return removeAt(elt, size - 1); }

