// Craps Game
// Samuel Feye
// CS240 - 003
// 01.12.18
// Homework 1

// includes 
#include <iostream> 
#include <fstream> 
#include <string>
#include <iomanip>
#include <cstdlib>
#include <ctime>

// add namespace
using namespace std;

// named constants
int MY_ROLL;
int POINT_INT = 0;
char EXIT = 'a';

// function prototypes
int roll();

// main
int main()
{
    srand((unsigned)time(NULL));
	cout << "WELCOME TO THIS CRAP GAME!" << endl;
    cout << "The Game Is About To Begin" << endl;

    while (EXIT != 'q')
    {
        MY_ROLL = roll ();
        
        if (MY_ROLL == 11)
        {
            cout << "You Rolled A " << MY_ROLL << "! Congrats You Win!" << endl;
            
        }

        else if (MY_ROLL == 7)
        {
            cout << "You Rolled A " << MY_ROLL << "! Congrats You Win!" << endl;
            MY_ROLL = 13;
           
        }

        else if (MY_ROLL == 2)
        {
            cout << "You Rolled A " << MY_ROLL << "... Too Bad, You Lose!" << endl;
            
        }
        else if (MY_ROLL == 3)
        {
            cout << "You Rolled A " << MY_ROLL << "... Too Bad, You Lose!" << endl;
            
        }
        else if (MY_ROLL == 12)
        {
            cout << "You Rolled A " << MY_ROLL << "... Too Bad, You Lose!" << endl;
        }
        else 
        {
            POINT_INT = MY_ROLL;
            MY_ROLL = 0;
            while (MY_ROLL != 13)
            {
                MY_ROLL = roll();
                cout << "Point Is: " << POINT_INT << endl;
                cout << "You Rolled A " << MY_ROLL << endl;
                if (MY_ROLL == POINT_INT)
                {
                    cout <<"Again? Congrats You Win!" << endl;
                    MY_ROLL = 13;
                }
                else if (MY_ROLL == 7)
                {
                    cout << "Too Bad, You Lose." << endl;
                    MY_ROLL = 13;
                }

            }
        }
        cout << "Enter 'q' to quit" << endl;
        EXIT = cin.get();
    }
    cout << "Goodbye";
}

int roll()
{
    int ROLL_1 = (rand()%6+1);
    int ROLL_2 = (rand()%6+1);
    int TOTAL_ROLLED = (ROLL_1 + ROLL_2);
    cout << "Roll 1: " << ROLL_1 << " Roll 2 : " << ROLL_2;
    return TOTAL_ROLLED;
}
