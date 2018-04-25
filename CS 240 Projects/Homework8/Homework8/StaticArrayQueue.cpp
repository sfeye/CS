//
//  StaticArrayQueue.cpp
//  Homework8
//
//  Created by Sam Feye on 3/20/18.
//  Copyright © 2018 Sam Feye. All rights reserved.
//

#include "StaticArrayQueue.hpp"

StaticArrayQueue::StaticArrayQueue()
{
    size = front = 0;
    rear = -1;
}
bool StaticArrayQueue::enqueue(StaticArrayQueueElementType elt)
{
    if(size >= MAX_SIZE)
        return false;
    rear = (rear +1) % MAX_SIZE;
    list[rear] = elt;
    size++;
    return true;
}
bool StaticArrayQueue::dequeue(StaticArrayQueueElementType &elt)
{
    if(size <= 0)
        return false;
    elt = list[front];
    front = (front + 1) % MAX_SIZE;
    size--;
    return true;
}
