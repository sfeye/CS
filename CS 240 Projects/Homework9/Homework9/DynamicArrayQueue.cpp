//  Samuel Feye
//  DynamicArrayQueue.cpp
//  Homework9
//  Professor Klein
//  CS240
//  Created by Sam Feye on 3/29/18.
//  Copyright © 2018 Sam Feye. All rights reserved.
//

#include "DynamicArrayQueue.hpp"
#include <iostream>
#include <iomanip>
using namespace std;

DynamicArrayQueue::DynamicArrayQueue()
{
    listSize = 0;
    front = 0;
    rear = -1;  // Inserting the first element will move rear up to 0
    // and it will be even with front, as it should be when
    // there is only 1 element in the queue.
    arraySize = DEFAULT_PARTITION_SIZE;
    list = new DynamicArrayQueueElementType[arraySize];
}

DynamicArrayQueue::DynamicArrayQueue(const DynamicArrayQueue &l)
{
    listSize = l.listSize;
    arraySize = l.arraySize;
    front = l.front;
    rear = l.rear;
    list = new DynamicArrayQueueElementType[arraySize];
    if (listSize > 0)
    {
        for (int i = front; i != rear; i = (i + 1) % arraySize)
        {
            list[i] = l.list[i];
        }
        list[rear] = l.list[rear];
    }
}

DynamicArrayQueue::~DynamicArrayQueue()
{
    delete[] list;
}


DynamicArrayQueue& DynamicArrayQueue::operator = (const DynamicArrayQueue &l)
{
    if (this == &l)
        return *this;
    delete[] list;
    listSize = l.listSize;
    arraySize = l.arraySize;
    front = l.front;
    rear = l.rear;
    list = new DynamicArrayQueueElementType[arraySize];
    if (listSize > 0)
    {
        for (int i = front; i != rear; i = (i + 1) % arraySize)
        {
            list[i] = l.list[i];
        }
        list[rear] = l.list[rear];
    }
    return *this;
}

void DynamicArrayQueue::displayQueue(ostream &outStream) const
{
    outStream << "List Size = " << listSize << endl;
    outStream << "Array Size = " << arraySize << endl;
    outStream << "List Index:   Array Index:   Value:\n-------------------------------------\n";
    if (listSize > 0)
    {
        int i, j;
        for (i = front, j = 0; i != rear; i = (i + 1) % arraySize, j++)
        {
            outStream <<setw(5) << j << setw(15) << i << setw(12) << list[i] << endl;
        }
        outStream << setw(5) << j << setw(15) << i << setw(12) << list[i] << endl;
    }
}

void DynamicArrayQueue::enqueue(DynamicArrayQueueElementType elt)
{
    if(listSize >= arraySize)//(listSize+1)
    {
        DynamicArrayQueueElementType* newArray = new DynamicArrayQueueElementType[listSize + DEFAULT_PARTITION_SIZE];
        arraySize += DEFAULT_PARTITION_SIZE;
        for (int i = front; i < rear; i++)
            newArray[i] = list[i];
        delete[] list;
        list = newArray;
    }
    rear = (rear + 1) % arraySize;
    list[rear] = elt;
    listSize++;
}

bool DynamicArrayQueue::dequeue(DynamicArrayQueueElementType &elt)
{
    if(listSize == 0)
        return false;
    elt = list[front]; //(front+1)
    front = (front + 1) % arraySize;
    listSize--;
    return true;
}



