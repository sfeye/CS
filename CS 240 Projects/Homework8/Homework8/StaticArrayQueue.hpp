#pragma once
#include<iostream>
using namespace std;

typedef int StaticArrayQueueElementType;

class StaticArrayQueue
{
protected:
    int size, front, rear;
    static const int MAX_SIZE = 100;
    StaticArrayQueueElementType list[MAX_SIZE];
public:
    StaticArrayQueue();
    bool enqueue(StaticArrayQueueElementType elt);
    bool dequeue(StaticArrayQueueElementType &elt);
};
