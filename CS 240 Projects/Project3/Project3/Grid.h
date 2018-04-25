// Program 3
// Samuel Feye
// Professor Klein CS240
// 03-25-2018
// Grid.h
// Copyright © 2018 Sam Feye. All rights reserved.

#pragma once
#include<iostream>
using namespace std;

typedef char GridElementType;

class Grid
{
protected:
    static const char BLANK_SPACE = ' ';
    static const char SOLID_SPACE = '-';
    static const int MAX_HEIGHT = 50;
    static const int MAX_WIDTH = 50;
    int height;
    int width;
    GridElementType grid[MAX_HEIGHT][MAX_WIDTH];
    
public:
    //Default Ctor
    Grid();
    //Accessor Methods
    int getHeight();
    int getWidth();
    //Overloaded functions
    friend ostream& operator << (ostream& os, Grid& g);
    friend istream& operator >> (istream& is, Grid& g);
    //at function
    GridElementType& at(int row, int col);
    //clearNum function
    void clearNumbers();
    //Utility functions
    void insertAt(int row, int col, GridElementType y);
    void printSolution();
};
