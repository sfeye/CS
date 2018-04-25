//
//  Character.cpp
//  Homework6
//
//  Created by Sam Feye on 3/1/18.
//  Copyright © 2018 Sam Feye. All rights reserved.
//

#include<iostream>
#include<string>
#include "Character.hpp"
using namespace std;

Character::Character()
{
    name = "John";
    money = 0;
    health = 10;
}

Character::Character(string startName)
{
    name = startName;
    money = 0;
    health = 10;
}

Character::Character(string startName, int startMoney, int startHealth)
{
    name = startName;
    money = ((startMoney < 0) ? 0 : startMoney);
    health = ((startHealth < 0) ? 0 : startHealth);
}

void Character::walk()
{
    cout << name << " walked." << endl;
}
string Character::talk()
{
    return "Character " + name + " talked.";
}
string Character::getName() const
{
    return name;
}
void Character::setName(string newName)
{
    name = newName;
}

int Character::getMoney() const
{
    return money;
}
bool Character::setMoney(int amount)
{
    if (amount >= 0)
    {
        money = amount;
        return true;
    }
    return false;
}
bool Character::addMoney(int toAdd)
{
    if (toAdd >= 0)
    {
        money += toAdd;
        return true;
    }
    return false;
}
bool Character::removeMoney(int toRemove)
{
    if (toRemove >= 0)
    {
        money -= toRemove;
        if (money < 0)
            money = 0;
        return true;
    }
    return false;
}

int Character::getHealth() const
{
    return health;
}
bool Character::setHealth(int amount)
{
    if (amount >= 0)
    {
        health = amount;
        return true;
    }
    return false;
}
bool Character::addHealth(int toAdd)
{
    if (toAdd >= 0)
    {
        health += toAdd;
        return true;
    }
    return false;
}
bool Character::removeHealth(int toRemove)
{
    if (toRemove >= 0)
    {
        health -= toRemove;
        if (health < 0)
            health = 0;
        return true;
    }
    return false;
}
