//  Sniper.h
//  Homework6
//  CS240 Klein
//  Created by Sam Feye on 3/1/18.
//  Copyright © 2018 Sam Feye. All rights reserved.

#pragma once
#include <iostream>
#include <string>
#include "Character.h"
using namespace std;

class Sniper : public Character
{
protected:
    int ammo;
    int scopeZoom;
public:
    Sniper();
    Sniper(string startName, int newAmmo);
    int getAmmo() const;
    bool setAmmo(int amount);
    int getZoom() const;
    bool setZoom(int amount);
    bool snipe(Character &c);
    //overridden functions
    string talk();
    void walk();
};


