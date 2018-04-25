//  Project 2
//  Rectangle.h
//  CS240 Klein
//  Created by Sam Feye on 2/23/18.
//  Copyright © 2018 Sam Feye. All rights reserved.
#pragma once

#include <fstream>
#include <iostream>
#include <string>
using namespace std;
const int MINIMUM_VALUE = 0;
class Rectangle
{
private:
    int x;
    int y;
    int height;
    int width;
    char border;
    char fill;
public:
    //Constructors
    Rectangle();
    Rectangle(int x, int y, int height, int width, char border, char fill);
    Rectangle(const Rectangle &rect);
    //overloaded stream operators
    friend ostream& operator << (ostream& os, const Rectangle& rect);
    friend istream& operator >> (istream& is, Rectangle& rect);
    Rectangle operator + (const Rectangle& rect) const;
    //overloaded bool operators
    bool operator == (const Rectangle& rect) const;
    bool operator > (const Rectangle& rect) const;
    bool operator < (const Rectangle& rect) const;
    bool operator != (const Rectangle& rect) const;
    bool operator >= (const Rectangle& rect) const;
    bool operator <= (const Rectangle& rect) const;
    //getters
    int getHeight() const;
    int getWidth() const;
    int getXCoordinate() const;
    int getYCoordinate() const;
    char getFill() const;
    char getBorder() const;
    //setters
    bool setHeight(int newHeight);
    bool setWidth(int newWidth);
    bool setXCoord(int newX);
    bool setYCoord(int newY);
    bool setFill(char newFill);
    bool setBorder(char newBorder);
    //utility functions
    int getArea(const Rectangle rect) const;
    int perimeter(const Rectangle rect) const;
    void isSquare(int myWidth, int myHeight) const;
    void displayRectangle(ostream& os);
    void displayStats(ostream& os);
};
