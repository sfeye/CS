// Program 3
// Samuel Feye
// Professor Klein CS240
// 03-25-2018
// Program3.cpp
// Copyright © 2018 Sam Feye. All rights reserved.

#include <iostream>
#include <fstream>
#include <string>
#include <ctime>
#include "Grid.h"
#include "SortedArrayList.h"

void loadGrid (Grid& g, SortedArrayList& l);
void copyHNums(Grid& g, SortedArrayList& l);
void copyVNums(Grid& g, SortedArrayList& l);

int main()
{
    srand(unsigned (time(NULL)));
    Grid myGrid;
    SortedArrayList copyList;
    loadGrid(myGrid, copyList);
    copyHNums(myGrid, copyList);
    copyVNums(myGrid, copyList);
    cout << myGrid;
    
    cout << endl << copyList << endl;
    myGrid.printSolution();
}
//loads the grid dimensions into the grid class and
//a local variable that holds the min and max num sizes
void loadGrid (Grid& g, SortedArrayList& l)
{
    ifstream myFile;
    myFile.open("BlankCrossNumber.txt");
    if (myFile.fail())
        cout << "fail";
    myFile >> g;
    while(!myFile.eof())
    {
        myFile >> l;
    }
    myFile.close();
}
//Creates a copy of all the horizontal numbers
void copyHNums(Grid& g, SortedArrayList& l)
{
    string fullString;
    char x;
    for(int i = 0; i < g.getHeight(); i++)
    {
        for(int j = 0; j < g.getWidth(); j++)
        {
            //if there is a blankspace then a random number is inserted into the grid element
            if(g.at(i, j) != '-')
            {
                g.insertAt(i, j, rand()%10 + '0');
                //if to push numbers before they run over into next row
                if(j == 0)
                {
                    x = g.at(i, j);
                    if (fullString.length() >= l.getNumSize(0) && fullString.length() <= l.getNumSize(l.getMyCount()))
                        l.push(fullString);
                    fullString = "";
                    fullString += x;
                }
                //else if is to copy the last string if there is one
                //since to push you need to hit a solid space
                else if (i == (g.getHeight()-1) && j == (g.getWidth()-1))
                {
                    x = g.at(i, j);
                    fullString += x;
                    if (fullString.length() >= l.getNumSize(0) && fullString.length() <= l.getNumSize(l.getMyCount()))
                        l.push(fullString);
                }
                else
                {
                    x = g.at(i, j);
                    fullString += x;
                }
            }
            //after you hit a solid space you add the fullstring
            //to the list and reset the fullstring
            else
            {
                if (fullString.length() >= l.getNumSize(0) && fullString.length() <= l.getNumSize(l.getMyCount()))
                    l.push(fullString);
                fullString = "";
            }
        }
    }
}
//this copies all of the vertical numbers
void copyVNums(Grid& g, SortedArrayList& l)
{
    string fullString;
    char x;
    for(int i = 0; i < g.getWidth(); i++)
    {
        for(int j = 0; j < g.getHeight(); j++)
        {
            //if there is a blankspace then a random number is inserted into the grid element
            if(g.at(j, i) != '-')
            {
                //if to push numbers before they run over into next col
                if(j == 0)
                {
                    x = g.at(j, i);
                    if (fullString.length() >= l.getNumSize(0) && fullString.length() <= l.getNumSize(l.getMyCount()))
                        l.push(fullString);
                    fullString = "";
                    fullString += x;
                }
                //else if is to copy the last string if there is one
                //since to push you need to hit a solid space
                else if (j == (g.getHeight()-1) && i == (g.getWidth()-1))
                {
                    x = g.at(j, i);
                    fullString += x;
                    if (fullString.length() >= l.getNumSize(0) && fullString.length() <= l.getNumSize(l.getMyCount()))
                        l.push(fullString);
                }
                else
                {
                    x = g.at(j, i);
                    fullString += x;
                }
            }
            //after you hit a solid space you add the fullstring
            //to the list and reset the fullstring
            else
            {
                if (fullString.length() >= l.getNumSize(0) && fullString.length() <= l.getNumSize(l.getMyCount()))
                    l.push(fullString);
                fullString = "";
            }
        }
    }
}

