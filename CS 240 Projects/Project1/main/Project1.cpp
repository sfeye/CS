// Boggle Game
// Samuel Feye
// CS240 - 003
// 02.02.18
// Project 1

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
const int NUMBER_OF_SPACES = 16;

//prototypes
string buildBoard(int count[NUMBER_OF_SPACES], char buildBoard[NUMBER_OF_SPACES][6]);
void printBoard(string str);
void doLettersExist(string str);
void clearScreen(string str);
string shakeBoard(string str, int count[NUMBER_OF_SPACES], char boggleBoard[NUMBER_OF_SPACES][6]);

//main
int main ()
{
    int count[NUMBER_OF_SPACES];
    char boggleBoard[NUMBER_OF_SPACES][6];
    cout << "Press enter to continue..." << endl;
    getchar();
    string myBoard = buildBoard(count, boggleBoard);
    char ans;
    char ans2;
    srand(unsigned (time(NULL)));
    do
    {
        myBoard = shakeBoard(myBoard,count,boggleBoard);
        printBoard(myBoard);
        
        
        do
        {
            doLettersExist(myBoard);
            cout << "Enter any letter to try again!(q to quit)" << endl;
            cin >> ans2;
        }while(ans2 != 'q');
        
        cout << "Press Y to reload the board." << endl;
        cin >> ans;
        clearScreen(myBoard);
    }while(tolower(ans) == 'y');
    
    cout << "Thanks for playing!" << endl;
}

//functions
string buildBoard (int count[NUMBER_OF_SPACES], char boggleBoard[NUMBER_OF_SPACES][6])
{
    string str;
    string x;
    int c = 0;
    ifstream myFile;
    myFile.open("BoggleDiceCaps.txt");
    if (myFile.fail())
        cout << "fail";
    while(!myFile.eof())
    {
        myFile >> x;
        for(int i = 0; i < x.length(); i++)
            {
                boggleBoard[c][i] = x[i];
            }
        c++;
    }
    myFile.close();
    
//    char boggleBoard[NUMBER_OF_SPACES][6] =
//    {
//        {'L','R','Y','T','T','E'},
//        {'V','T','H','R','W','E'},
//        {'E','G','H','W','N','E'},
//        {'S','E','O','T','I','S'},
//        {'A','N','A','E','E','G'},
//        {'I','D','S','Y','T','T'},
//        {'O','A','T','T','O','W'},
//        {'M','T','O','I','C','U'},
//        {'A','F','P','K','F','S'},
//        {'X','L','D','E','R','I'},
//        {'H','C','P','O','A','S'},
//        {'E','N','S','I','E','U'},
//        {'Y','L','D','E','V','R'},
//        {'Z','N','R','N','H','L'},
//        {'O','B','B','A','O','J'},
//        {'N','M','I','Q','H','U'},
//    };
    
    for(int i = 0; i < NUMBER_OF_SPACES; i++)
    {
        str[i] = boggleBoard[i][rand()%6];
        count[i] = i;
    }
    return str;
}

void printBoard (string str)
{
    int j = 0;
    cout << endl << "_________________" << endl;
    
    for (int i = 0; i < 4; i++)
    {
        for (int k = 0; k < 4; k++)
        {
            if (str[j] == 'Q')
                cout << "| " << "Qu" << "";
            else
                cout << "| " << str[j] << " ";
            j++;
        }
        cout << "|" << endl << "_________________" << endl;
    }
}

void doLettersExist (string str)
{
    string word;
    bool fullWord = true;
    cout << "Enter a letter: ";
    cin >> word;
    bool exists[word.length()];
    cout << endl;
    for (int j = 0; j < word.length(); j++)
    {
        for(int i = 0; i <= NUMBER_OF_SPACES; i++)
        {
            if(str[i] == toupper(word[j]))
            {
                exists[j] = true;
                break;
            }
            else
                exists[j] = false;
        }
    }
    for (int k = 0; k < word.length(); k++)
    {
        if(exists[k])
            fullWord = true;
        else
        {
            fullWord = false;
            break;
        }
    }
    if(fullWord)
        cout << word << " exists!" << endl;
    else
        cout << word << " does not exist..." << endl;
}

string shakeBoard(string str, int count[NUMBER_OF_SPACES], char boggleBoard[NUMBER_OF_SPACES][6])
{
    for(int i = 1; i <= 500; i++)
    {
        int location1 = int(rand()%NUMBER_OF_SPACES);
        int location2 = int(rand()%NUMBER_OF_SPACES);
        int die1Location = count[location1];
        int die2Location = count[location2];
        str[location1] = boggleBoard[die2Location][rand()%6];
        str[location2] = boggleBoard[die1Location][rand()%6];
        count[location1] = die2Location;
        count[location2] = die1Location;
    }
    return str;
}

void clearScreen(string str)
{
    for(int i = 0; i < NUMBER_OF_SPACES; i++)
    {
        str[i] = NULL;
    }
    #ifdef _WIN32
    
        system("cls");
    #else
        // Assume POSIX
        system("clear");
    #endif
}

