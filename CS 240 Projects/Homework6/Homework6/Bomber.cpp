//  Bomber.cpp
//  Homework6
//  CS240 Klein
//  Created by Sam Feye on 3/1/18.
//  Copyright © 2018 Sam Feye. All rights reserved.
#include <iostream>
#include <string>
#include "Character.h"
#include "Bomber.h"
using namespace std;

Bomber::Bomber() : Character()
{
    bombs = 10;
    bombSize = 1.0;
}
Bomber::Bomber(string startName, int numBombs) : Character(startName)
{
    name = startName;
    bombs = numBombs;
    bombSize = 1.0;
}
int Bomber::getBombs() const
{
    return bombs;
}
bool Bomber::setBombs(int amount)
{
    if (amount < 0)
        return false;
    bombs = amount;
    return true;
}
double Bomber::getBombSize() const
{
    return bombSize;
}
bool Bomber::setBombSize(int amount)
{
    if (amount < 0 || amount > 3)
    {
        cout << "Bomb size is out of range..." << endl;
        return false;
    }
    else
    {
        bombSize = amount;
        return true;
    }
}
bool Bomber::blowUp(Character &c)
{
    if (bombs <= 0)
    {
        cout << "Out of bombs!";
        return false;
    }
    else if (bombSize < c.getHealth())
    {
        c.setHealth(c.getHealth() - bombSize);
        cout << c.getName() << " was damaged!" << endl;
        setBombs(bombs - 1);
        return true;
    }
    else
    {
        c.setHealth(0);
        cout << c.getName() << " was blown up!" << endl;
        setBombs(bombs - 1);
        return true;
    }
}
string Bomber::talk()
{
    return "Bombs away!";
}
void Bomber::walk()
{
    cout << name <<" is in position to drop the bomb!" << endl;
}




