//
//  Rectangle.cpp
//  Project2
//  Project 2
//  Rectangle.cpp
//  CS240 Klein
//  Created by Sam Feye on 2/23/18.
//  Copyright © 2018 Sam Feye. All rights reserved.
#include <iostream>
#include <string>
#include <math.h>
#include "Rectangle.h"

//Constructors--------------------------------
//Default
Rectangle::Rectangle()
{
    x = MINIMUM_VALUE;
    y = MINIMUM_VALUE;
    height = 5;
    width = 5;
    border = '#';
    fill = '*';
}
//Initializing
Rectangle::Rectangle(int newX, int newY, int newHeight, int newWidth, char newBorder, char newFill)
{
    setXCoord(newX);
    setYCoord(newY);
    setHeight(newHeight);
    setWidth(newWidth);
    setBorder(newBorder);
    setFill(newFill);
}
//copy constructor
Rectangle::Rectangle(const Rectangle &rect)
{
    x = rect.x;
    y = rect.y;
    height = rect.height;
    width = rect.width;
    border = rect.border;
    fill = rect.fill;
}
//end constructors-------------------------------
//overloaded stream operators--------------------
ostream& operator << (ostream& os, const Rectangle& rect)
{
    os << "Height: " <<rect.height << " Width: "<< rect.width
    << " Border: " << rect.border << " Fill: " << rect.fill << endl
    << "X Coord: " << rect.x << " Y Coord: " << rect.y << endl
    << "Area: " << rect.getArea(rect) << " Perimeter: " << rect.perimeter(rect) << endl
    << "Is this a Square? ";
    rect.isSquare(rect.width, rect.height);
    os << endl;
    return os;
}
istream& operator >> (istream& is, Rectangle& rect)
{
    int tempX, tempY, tempHeight, tempWidth;
    char tempB, tempF;
    is >> tempX >> tempY >> tempHeight >> tempWidth >> tempB >> tempF;
    rect.setXCoord(tempX);
    rect.setYCoord(tempY);
    rect.setHeight(tempHeight);
    rect.setWidth(tempWidth);
    rect.setBorder(tempB);
    rect.setFill(tempF);
    return is;
}
//end overloaded stream operators----------------
//overloaded operators---------------------------
//+ operator
Rectangle Rectangle::operator + (const Rectangle& rect) const
{
    Rectangle addedRect;
    //floor function rounds down the averaged x and y values
    addedRect.x = (floor)((x + rect.x)/2);
    addedRect.y = (floor)((y + rect.y)/2);
    addedRect.height = (height + rect.height);
    addedRect.width = (width + rect.width);
    addedRect.fill = (fill);
    addedRect.border = (border);
    return addedRect;
}
// == operator
bool Rectangle::operator == (const Rectangle& rect) const
{
    return ((getArea(*this)) == (getArea(rect)));
}
// < operator
bool Rectangle::operator < (const Rectangle& rect) const
{
    return ((getArea(*this)) < (getArea(rect)));
}
// > operator
bool Rectangle::operator > (const Rectangle& rect) const
{
    return ((getArea(*this)) > (getArea(rect)));
}
// != operator
bool Rectangle::operator != (const Rectangle& rect) const
{
    return ((getArea(*this)) != (getArea(rect)));
}
// >= operator
bool Rectangle::operator >= (const Rectangle& rect) const
{
    return ((getArea(*this)) >= (getArea(rect)));
}
// <= operator
bool Rectangle::operator <= (const Rectangle& rect) const
{
    return ((getArea(*this)) <= (getArea(rect)));
}
//end overloaded operators-----------------------
//getters----------------------------------------
int Rectangle::getHeight() const
{
    return height;
}
int Rectangle::getWidth() const
{
    return width;
}
int Rectangle::getXCoordinate() const
{
    return x;
}
int Rectangle::getYCoordinate() const
{
    return y;
}
char Rectangle::getFill() const
{
    return fill;
}
char Rectangle::getBorder() const
{
    return border;
}
//end getters----------------------------------
//setters--------------------------------------
//setters check to make sure height, width,----
//x coord, and y coord aren't set to neg values
bool Rectangle::setHeight(int newHeight)
{
    if(newHeight < MINIMUM_VALUE)
    {
        cerr << "Value was set out of range." << endl;
        exit(1);
        return false;
    }
    else
    {
        height = newHeight;
        return true;
    }
}
bool Rectangle::setWidth(int newWidth)
{
    if(newWidth < MINIMUM_VALUE)
    {
        cerr << "Value was set out of range." << endl;
        exit(1);
        return false;
    }
    else
    {
        width = newWidth;
        return true;
    }
}
bool Rectangle::setXCoord(int newX)
{
    if(newX < MINIMUM_VALUE)
    {
        cerr << "Value was set out of range." << endl;
        exit(1);
        return false;
    }
    else
    {
        x = newX;
        return true;
    }
}
bool Rectangle::setYCoord(int newY)
{
    if(newY < MINIMUM_VALUE)
    {
        cerr << "Value was set out of range." << endl;
        exit(1);
        return false;
    }
    else
    {
        y = newY;
        return true;
    }
}
bool Rectangle::setFill(char newFill)
{
        fill = newFill;
        return true;
}
bool Rectangle::setBorder(char newBorder)
{
        border = newBorder;
        return true;
}
//end setters--------------------------------------
//utility functions--------------------------------
int Rectangle::getArea(const Rectangle rect) const
{
    return (rect.getHeight() * rect.getWidth());
}
int Rectangle::perimeter(const Rectangle rect) const
{
    return ((rect.height * 2) + (rect.width * 2));
}
void Rectangle::isSquare(int myWidth, int myHeight) const
{
    cout << ((myWidth == myHeight)? "Yes":"No...");
}
//Display fucntions, take in an ostream as a parameter
void Rectangle::displayRectangle (ostream& os)
{
    for (int i = 0; i < y; i++)
        os << endl;
    for (int i = 0; i < x; i++)
        os << " ";
    // width plus two to account for the border characters around the fill
    for (int i = 0; i < width + 2; i++)
    {
        os << border;
    }
    os << endl;
    for (int i = 0; i < (height/2) + 1; i++)
    {
        for (int i = 0; i < x; i++)
        {
            os << " ";
        }
        os << border;
        for (int j = 0; j < width; j++)
        {
            os << fill;
        }
        os << border << endl;
    }
    for (int i = 0; i < x; i++)
        os << " ";
    for (int i = 0; i < width + 2; i++)
    {
        os << border;
    }
    os << endl;
    
}
void Rectangle::displayStats (ostream& os)
{
    os << "Height: " <<height << "   " << "Width: " << width << endl
    << "Border: " << border << "    " << "Fill: " << fill << endl
    << "     X: "<< x << "       " << "Y: " << y << endl
    << "  Area: " << (width * height) << "  " << "Perim: " << ((2*width)+(2*height)) << endl
    << "Is a Square? ";
    isSquare(width,height);
    cout << endl;
}
//end utility functions----------------------------



