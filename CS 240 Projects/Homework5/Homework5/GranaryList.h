//  Homework 5
//  GranaryList.hpp
//  CS240 Klein
//  Created by Sam Feye on 2/8/18.
//  Copyright © 2018 Sam Feye. All rights reserved.


#pragma once

// Definition file for class GranaryList
#include<iostream>
#include<string>
using namespace std;

const int NUMBER_OF_TRANSACTIONS = 5;

class GranaryList
{
private:
    int capacity;
    int amount;
    string *transactions;
public:
    GranaryList();
    GranaryList(int startCapacity);
    GranaryList(int startCapacity, int startAmount);
    GranaryList(const GranaryList& gran);
    ~GranaryList();
    // Getters:
    int getCapacity() const;
    int getAmount() const;
    // Setters:
    bool setCapacity(int newCapacity);
    bool setAmount(int newAmount);
    // Add and Remove Grain:
    int addGrain(int amountToAdd);
    int removeGrain(int amountToRemove);
    // Stats functions:
    double percentFull() const;
    int spaceAvailable() const;
    void printTransactions() const;
    void addTransaction(string t);
    GranaryList& operator = (const GranaryList& gran);
};

