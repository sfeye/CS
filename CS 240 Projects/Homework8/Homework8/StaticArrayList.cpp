//Samuel Feye
//03-20-2018
//Professor Klein CS240
//Homework 8
//StaticArrayList.cpp
//  Copyright © 2018 Sam Feye. All rights reserved.

#include<iostream>
#include "StaticArrayList.hpp"
using namespace std;

StaticArrayList::StaticArrayList()
{
    size = 0;
}

int StaticArrayList::getSize() const
{
    return size;
}

bool StaticArrayList::insertAt(ElementType elt, int position)
{
    if ((position < 0) || (position > size) || (size >= MAX_SIZE))
        return false;
    for (int i = size; i > position; i--)
        list[i] = list[i - 1];
    list[position] = elt;
    size++;
    return true;
}
bool StaticArrayList::removeAt(ElementType &elt, int position)
{
    if ((position < 0) || (position > size - 1))
        return false;
    elt = list[position];
    for (int i = position; i < size; i++)
        list[i] = list[i + 1];
    size--;
    return true;
}
void StaticArrayList::deleteList()
{
    size = 0;
}
bool StaticArrayList::insertSorted(ElementType elt)
{
    if (size >= MAX_SIZE)
        return false;
    if(list[0] > elt)
    {
        for (int i = 0; i < size; i++)
            list[i] = list[i+1];
        list[0] = elt;
        size++;
        return true;
    }
    if(list[size-1] < elt)
    {
        list[size] = elt;
        size++;
        return true;
    }
    for (int i = 0; i < size; i++)
    {
        if (list[i] < elt && list[i+1] > elt)
        {
            for(int j = (i+1); j < size; j++)
                list[j] = list[j+1];
            list[i+1] = elt;
        }
    }
    size++;
    return true;
}
bool StaticArrayList::remove(ElementType elt)
{
    bool exists = false;
    for (int i = 0; i < size; i++)
    {
        if (elt == list[i])
        {
            for(int j = i; j < (size - 1); j++)
            {
                list[j] = list[j+1];
            }
            size--;
             return true;
        }
        else
            exists = false;
    }
    return exists;
}












