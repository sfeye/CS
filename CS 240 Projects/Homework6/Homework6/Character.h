//
//  Character.hpp
//  Homework6
//
//  Created by Sam Feye on 3/1/18.
//  Copyright © 2018 Sam Feye. All rights reserved.
//

#pragma once
#include<iostream>
#include<string>

using namespace std;

class Character
{
protected:
    string name;
    int money;
    int health;
public:
    Character();
    Character(string startName);
    Character(string startName, int startMoney, int startHealth);
    virtual void walk();
    virtual string talk();
    string getName() const;
    void setName(string newName);
    int getMoney() const;
    bool setMoney(int amount);
    bool addMoney(int toAdd);
    bool removeMoney(int toRemove);
    int getHealth() const;
    bool setHealth(int amount);
    bool addHealth(int toAdd);
    bool removeHealth(int toRemove);
    
};
