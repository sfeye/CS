//  Homework 5
//  GranaryList.cpp
//  CS240 Klein
//  Created by Sam Feye on 2/8/18.
//  Copyright © 2018 Sam Feye. All rights reserved.

// Implementation file for class GranaryList
#include<iostream>
#include<string>
#include<cassert>
#include "GranaryList.h"

using namespace std;

GranaryList::GranaryList()
{
    capacity = 0;
    amount = 0;
    transactions = new string[NUMBER_OF_TRANSACTIONS];
    for (int i = 0; i < NUMBER_OF_TRANSACTIONS; i++)
    {
        transactions[i] = "";
    }
}

GranaryList::GranaryList(int startCapacity)
{
    if (startCapacity > 0)
        capacity = startCapacity;
    else
        capacity = 0;
    amount = 0;
    transactions = new string[NUMBER_OF_TRANSACTIONS];
    for (int i = 0; i < NUMBER_OF_TRANSACTIONS; i++)
    {
        transactions[i] = "";
    }
}
GranaryList::GranaryList(int startCapacity, int startAmount)
{
    if (startCapacity > 0)
        capacity = startCapacity;
    else
        capacity = 0;
    if (startAmount > capacity)
        amount = capacity;
    else
        amount = startAmount;
    transactions = new string[NUMBER_OF_TRANSACTIONS];
    for (int i = 0; i < NUMBER_OF_TRANSACTIONS; i++)
    {
        transactions[i] = "";
    }
}
GranaryList::GranaryList(const GranaryList& gran)
{
    capacity = gran.capacity;
    amount = gran.amount;
    transactions = new string[NUMBER_OF_TRANSACTIONS];
    *transactions = *gran.transactions;
}
//Destructor
GranaryList::~GranaryList()
{
    delete[] transactions;
    transactions = NULL;
}
//Overloaded Operator
GranaryList& GranaryList::operator = (const GranaryList& gran)
{
    capacity = gran.capacity;
    amount = gran.amount;
    if(transactions != NULL)
        delete transactions; //preventing a memory leak
    transactions = new string;
    *transactions = *gran.transactions;
    return *this; //return the left and operand (the curr obj)
}
// Getters:
int GranaryList::getCapacity() const
{
    return capacity;
}
int GranaryList::getAmount() const
{
    return amount;
}

// Setters:
bool GranaryList::setCapacity(int newCapacity)
{
    if (newCapacity < 0)
        return false;
    capacity = newCapacity;
    if (amount > capacity)
        amount = capacity;
    return true;
}
bool GranaryList::setAmount(int newAmount)
{
    if (newAmount < 0)
        return false;
    if (amount > capacity)
        amount = capacity;
    else
        amount = newAmount;
    return true;
}
// Add and Remove Grain:
int GranaryList::addGrain(int amountToAdd)
{
    assert(amountToAdd >= 0);
    int diff = 0;
    amount += amountToAdd;
    if (amount > capacity)
    {
        diff = amount - capacity;
        amount = capacity;
    }
    string temp = to_string(amountToAdd);
    addTransaction(temp + " added.");
    return diff;
}
int GranaryList::removeGrain(int amountToRemove)
{
    assert(amountToRemove >= 0);
    int diff = 0;
    amount -= amountToRemove;
    if (amount < 0)
    {
        diff = -amount;
        amount = 0;
    }
    string temp = to_string(amountToRemove);
    addTransaction(temp + " removed.");
    return diff;
}
// Stats functions:
double GranaryList::percentFull() const
{
    return double(amount) / double(capacity);
}
int GranaryList::spaceAvailable() const
{
    return capacity - amount;
}


void GranaryList::printTransactions() const
{
    cout << endl;
    for (int i = 0; i < NUMBER_OF_TRANSACTIONS; i++)
    {
        cout << transactions[i] << endl;
    }
}

void GranaryList::addTransaction(string t)
{
    for (int i = 0; i < NUMBER_OF_TRANSACTIONS - 1; i++)
    {
        transactions[i] = transactions[i + 1];
    }
    transactions[NUMBER_OF_TRANSACTIONS-1] = t;
}
