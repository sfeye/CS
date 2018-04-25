//  Homework 4
//  Granary.cpp
//  CS240 Klein
//  Created by Sam Feye on 2/5/18.
//  Copyright © 2018 Sam Feye. All rights reserved.

#include <iostream>
#include <string>
#include "Granary.hpp"
using namespace std;

//default constructor
Granary::Granary()
{
    capacity = DEFAULT_CAPACITY;
    amount = DEFAULT_AMOUNT;
}
//constructors
Granary::Granary(int startCapacity)
{
    if(startCapacity < MINIMUM_CAPACITY)
        capacity = MINIMUM_CAPACITY;
    else
        capacity = startCapacity;
}
Granary::Granary(int startCapacity, int startAmount)
{
    if (startCapacity < MINIMUM_CAPACITY)
        capacity = MINIMUM_CAPACITY;
    else if (startAmount < MINIMUM_CAPACITY)
        amount = MINIMUM_CAPACITY;
    else if (startAmount > startCapacity)
    {
        amount = startCapacity;
        capacity = startCapacity;
    }
    else
    {
        amount = startAmount;
        capacity = startCapacity;
    }
}
//getters_________________________________________
int Granary::getCapacity() const
{
    return capacity;
}

int Granary::getAmount() const
{
    return amount;
}
//end getters______________________________________
//setters__________________________________________
bool Granary::setCapacity(int newCapacity)
{
    if(newCapacity < amount && newCapacity >= MINIMUM_CAPACITY)
    {
        amount = newCapacity;
        capacity = newCapacity;
        return true;
    }
    else if (newCapacity >= MINIMUM_CAPACITY && newCapacity >= amount)
    {
        capacity = newCapacity;
        return true;
    }
    else
    {
        cerr << "Value was set out of range." << endl;
        exit(1);
        return false;
    }
}
bool Granary::setAmount(int newAmount)
{
    if(newAmount < MINIMUM_CAPACITY || newAmount > capacity)
    {
        cerr << "Value was set out of range." << endl;
        exit(1);
        return false;
    }
    else
    {
        amount = newAmount;
        return true;
    }
}
//end setters_____________________________________________
//utility functions_______________________________________
int Granary::addGrain(int amountToAdd)
{
    int total = amountToAdd + amount;
    if(total > capacity)
    {
        amount = capacity;
        return (total - capacity);
    }
    else if (amountToAdd < 0)
    {
        cerr << "Value was set out of range." << endl;
        exit(1);
    }
    else
    {
        amount += amountToAdd;
        return 0;
    }
}
int Granary::removeGrain(int amountToRemove)
{
    int total = amount - amountToRemove;
    if (amountToRemove < MINIMUM_CAPACITY)
    {
        cerr << "Value was set out of range." << endl;
        exit(1);
    }
    else if(total < MINIMUM_CAPACITY)
    {
        amount = 0;
        return (total);
    }
    else
    {
        amount = (amount - amountToRemove);
        return 0;
    }
}
double Granary::percentFull() const
{
    return (amount/capacity);
}
int Granary::spaceAvailable() const
{
    return (capacity - amount);
}
//end utility functions___________________________________






