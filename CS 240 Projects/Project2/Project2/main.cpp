#include<iostream>
#include<fstream>
#include<cctype>
#include"Rectangle.h"
using namespace std;

const int NUM_RECTANGLES = 5;

void loadArray(Rectangle myRectangles[]);
char getChoice();
int getARectangle();
void displayOne(Rectangle r, int which);
void displayAll(Rectangle myRectangles[]);
void editOne(Rectangle& r, int which);
int findLargest(Rectangle myRectangles[]);
int findSmallest(Rectangle myRectangles[]);
void clearScreen();

int main()
{
    Rectangle myRectangles[NUM_RECTANGLES];
    char choice;
    int whichOne;
    cout << "\n          Welcome to the Rectangle Class Program!\n\n";
    loadArray(myRectangles);
    do
    {
        choice = getChoice();
        clearScreen();
        switch (choice)
        {
            case '1':
                displayAll(myRectangles);
                break;
            case '2':
                whichOne = getARectangle();
                displayOne(myRectangles[whichOne], whichOne + 1);
                break;
            case '3':
                whichOne = getARectangle();
                editOne(myRectangles[whichOne], whichOne + 1);
                break;
            case '4':
                whichOne = findSmallest(myRectangles);
                displayOne(myRectangles[whichOne], whichOne + 1);
                break;
            case '5':
                whichOne = findLargest(myRectangles);
                displayOne(myRectangles[whichOne], whichOne + 1);
                break;
            case '6':
                displayOne(myRectangles[0], 1);
                cout << "\n plus \n";
                displayOne(myRectangles[1], 2);
                cout << "\n equals: \n";
                displayOne(myRectangles[0] + myRectangles[1], 0);
                break;
            case 'Q':
                break;
            default:
                cout << "That is not a listed choice.  Please try again.\n";
        }
    } while (choice != 'Q');
    cout << "\n\tGoodbye\n\n";
    system("pause");
}
int findLargest(Rectangle myRectangles[])
{
    int largest = 0;
    for (int i = 1; i < NUM_RECTANGLES; i++)
        if (myRectangles[i] > myRectangles[largest])
            largest = i;
    return largest;
}
int findSmallest(Rectangle myRectangles[])
{
    int smallest = 0;
    for (int i = 1; i < NUM_RECTANGLES; i++)
        if (myRectangles[i] < myRectangles[smallest])
            smallest = i;
    return smallest;
}

void editOne(Rectangle& r, int which)
{
    int nextI;
    char nextC;
    displayOne(r, which);
    cout << "Enter the new X coordinate: ";
    cin >> nextI;
    r.setXCoord(nextI);
    cout << "Enter the new Y coordinate: ";
    cin >> nextI;
    r.setYCoord(nextI);
    cout << "Enter the new height: ";
    cin >> nextI;
    while (!r.setHeight(nextI))
    {
        cout << "That number is not valid.  Please enter a positive integer: ";
        cin >> nextI;
    }
    cout << "Enter the new width: ";
    cin >> nextI;
    while (!r.setWidth(nextI))
    {
        cout << "That number is not valid.  Please enter a positive integer: ";
        cin >> nextI;
    }
    cout << "Enter the new border character: ";
    cin >> nextC;
    r.setBorder(nextC);
    cout << "Enter the new fill character: ";
    cin >> nextC;
    r.setFill(nextC);
    system("cls");
    cout << "Editing complete.  New Rectangle:";
    displayOne(r, which);
}
void displayAll(Rectangle myRectangles[])
{
    for (int i = 0; i < NUM_RECTANGLES; i++)
        displayOne(myRectangles[i], i + 1);
}

void displayOne(Rectangle r, int which)
{
    cout << "\n************************\n**** Rectangle #" << which << " ****\n";
    r.displayStats(cout);
    r.displayRectangle(cout);
    cout << "************************\n\n";
}
int getARectangle()
{
    int which;
    cout << "Please choose a rectangle (1.." << NUM_RECTANGLES << "): ";
    cin >> which;
    while ((which < 1) || (which > NUM_RECTANGLES))
    {
        cout << "I'm sorry that is not between 1 and " << NUM_RECTANGLES << endl;
        cout << "Please choose a rectangle: ";
        cin >> which;
    }
    return which - 1;  // which - 1 to change index from 1..n to 0..n-1
}

char getChoice()
{
    char choice;
    cout << "\n\nWhat would you like to do?\n"
    << "1) View all the rectangles\n"
    << "2) View one rectangle\n"
    << "3) Edit a rectangle\n"
    << "4) View smallest rectangle\n"
    << "5) View largest rectangle\n"
    << "6) View the first 2 added together\n"
    << "Q) Quit\n";
    cin >> choice;
    choice = toupper(choice);
    return choice;
}
void loadArray(Rectangle myRectangles[])
{
    ifstream infile;
    infile.open("Rectangles.txt");
    if (infile.fail())
    {
        cerr << "The file 'Rectangles.txt' could not be opened.\nMake sure it's in the same folder.\n";
        exit(1);
    }
    for (int i = 0; i < NUM_RECTANGLES; i++)
        infile >> myRectangles[i];
}


/*
 clearScreen()
 Chooses a system clear screen that hopefully works for whatever system is used.
 Copied and modified from:
 https://stackoverflow.com/questions/228617/how-do-i-clear-the-console-in-both-windows-and-linux-using-c
 */
void clearScreen()
{
#ifdef _WIN32
    system("cls");
#else
    // Assume POSIX
    system("clear");
#endif
}
