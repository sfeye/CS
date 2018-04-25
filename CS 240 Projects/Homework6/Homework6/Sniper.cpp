//  Sniper.cpp
//  Homework6
//  CS240 Klein
//  Created by Sam Feye on 3/1/18.
//  Copyright © 2018 Sam Feye. All rights reserved.

#include <iostream>
#include <string>
#include "Character.h"
#include "Sniper.h"
using namespace std;


Sniper::Sniper() : Character()
{
    ammo = 3;
    scopeZoom = 5;
}

Sniper::Sniper(string startName, int newAmmo) : Character(startName)
{
    name = startName;
    ammo = newAmmo;
    scopeZoom = 5;
}
int Sniper::getAmmo() const
{
    return ammo;
}
bool Sniper::setAmmo(int amount)
{
    if (amount < 0)
        return false;
    ammo = amount;
    return true;
}
int Sniper::getZoom() const
{
    return scopeZoom;
}
bool Sniper::setZoom(int amount)
{
    if (amount < 0)
        return false;
    scopeZoom = amount;
    return true;
}
bool Sniper::snipe(Character &c)
{
    if (ammo <= 0)
    {
        cout << "Out of ammo!" << endl;
        return false;
    }
    c.setHealth(0);
    cout << c.getName() << "Was killed!" << endl;
    setAmmo(ammo - 1);
    return true;
}
string Sniper::talk()
{
    return name + " nods and continues to watch through his scope.";
}
void Sniper::walk()
{
    cout << name << " is in overwatching position..." << endl;
}

