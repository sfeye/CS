//
//  DynamicArrayQueue.hpp
//  Homework9
//
//  Created by Sam Feye on 3/29/18.
//  Copyright © 2018 Sam Feye. All rights reserved.
//

#pragma once
#include <iostream>
using namespace std;

typedef int DynamicArrayQueueElementType;

const int DEFAULT_PARTITION_SIZE = 10;

class DynamicArrayQueue
{
protected:
    int listSize;
    int arraySize;
    int front;
    int rear;
    DynamicArrayQueueElementType* list;
public:
    DynamicArrayQueue();
    DynamicArrayQueue(const DynamicArrayQueue &l);
    ~DynamicArrayQueue();
    DynamicArrayQueue& operator = (const DynamicArrayQueue &l);
    void enqueue(DynamicArrayQueueElementType elt);
    bool dequeue(DynamicArrayQueueElementType &elt);
    void displayQueue(ostream &outStream) const;
};

