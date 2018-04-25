//  Homework 4
//  Granary.cpp
//  CS240 Klein
//  Created by Sam Feye on 2/5/18.
//  Copyright © 2018 Sam Feye. All rights reserved.


#ifndef Granary_hpp
#define Granary_hpp

#include <iostream>
#include <string>
using namespace std;

const int MINIMUM_CAPACITY = 0;
const int DEFAULT_CAPACITY = 0;
const int DEFAULT_AMOUNT = 0;

class Granary
{
private:
    int capacity;
    int amount;
    
public:
    //constructors
    Granary();
    Granary(int startCapacity);
    Granary(int startCapacity, int startAmount);
    
    //getters
    int getCapacity() const;
    int getAmount() const;
    
    //setters
    bool setCapacity(int newCapacity);
    bool setAmount(int newAmount);
    
    //utility functions
    int addGrain(int amountToAdd);
    int removeGrain(int amountToRemove);
    double percentFull() const;
    int spaceAvailable() const;
};
    
#endif /* Granary_hpp */
