// Program 3
// Samuel Feye
// Professor Klein CS240
// 03-25-2018
// Grid.cpp
// Copyright © 2018 Sam Feye. All rights reserved.

#include "Grid.h"
#include <istream>
#include <cassert>

//Default Ctor
Grid::Grid()
{
    height = 0;
    width = 0;
}
//Accessor methods
int Grid::getHeight()
{ return height;}
int Grid::getWidth()
{ return width;}

//Overloaded funtions
istream& operator >> (istream& is, Grid& g)
{
    is >> g.height;
    is >> g.width;
    //check to see if height and width are between 0 & 50
    assert((g.height >= 0) && (g.height <= g.MAX_HEIGHT) && (g.width >= 0) && (g.width <= g.MAX_WIDTH));
    for (int i = 0; i < g.height; i ++)
    {
        for (int j = 0; j < g.width; j++)
        {
            GridElementType x;
            is >> x;
            if(x == '.')
                g.grid[i][j] = g.BLANK_SPACE;
            else
                g.grid[i][j] = g.SOLID_SPACE;
        }
    }
    return is;
}
ostream& operator << (ostream& os, Grid& g)
{
    bool firstNum = true;
    string border = "+";
    os << "Today's puzzle:" << endl;
    for (int i = 0; i < g.width; i++)
    {
        border += "-+";
    }
    os << border << endl;
    for (int i = 0; i < g.height; i ++)
    {
        for (int j = 0; j < g.width; j++)
        {
            os << "|";
            if(g.grid[i][j] != g.SOLID_SPACE && firstNum == true)
                os << g.grid[i][j];
            else if(g.grid[i][j] != g.SOLID_SPACE)
                os << g.BLANK_SPACE;
            else
            {
                os << g.SOLID_SPACE;
                firstNum = false;
            }
        }
        os << "|" << endl;
    }
    os << border << endl;
    return os;
}

//at function
GridElementType& Grid::at(int row, int col)
{
    // checks to see if rows and cols are in bounds
    assert((row >= 0) && (row < height) && (col >= 0) && (col < width));
    return grid[row][col];
}
//clearNum function
void Grid::clearNumbers()
{
    for (int i = 0; i < height; i ++)
    {
        for (int j = 0; j < width; j++)
        {
            if(grid[i][j] != SOLID_SPACE)
                grid[i][j] = BLANK_SPACE;
        }
    }
}

//used to insert a random number into a specific place on the grid, condensed version of at =
//used this to make sure it was inserting to a spot on the grid
void Grid::insertAt(int row, int col, GridElementType y)
{
    assert((row >= 0) && (row < height) && (col >= 0) && (col < width));
    grid[row][col] = y;
}
//print the entire grid with correct random numbers in place
void Grid::printSolution()
{
    string border = "+";
    cout << "Solution:" << endl;
    for (int i = 0; i < width; i++)
    {
        border += "-+";
    }
    cout << border << endl;
    for (int i = 0; i < height; i ++)
    {
        for (int j = 0; j < width; j++)
        {
            cout << "|" << grid[i][j];
        }
        cout << "|" << endl;
    }
    cout << border << endl;
}
