//  Bomber.h
//  Homework6
//  CS240 Klein
//  Created by Sam Feye on 3/1/18.
//  Copyright © 2018 Sam Feye. All rights reserved.

#pragma once
#include <iostream>
#include <string>
#include "Character.h"
using namespace std;

class Bomber : public Character
{
protected:
    int bombs;
    double bombSize;
public:
    Bomber();
    Bomber(string startName, int numBombs);
    int getBombs() const;
    bool setBombs(int amount);
    double getBombSize() const;
    bool setBombSize(int amount);
    bool blowUp(Character &c);
    //overridden methods
    string talk();
    void walk();
};
