// Homework2
// Samuel Feye
// CS240 - 003
// 02.02.18
// Homework2

// includes

#include <iostream>
#include <cstdlib>
#include <ctime>
#include <cstdio>
#include <fstream>
#include <string>

// add namespace
using namespace std;

//prototypes
double calcAverage(double arr[], int size);
double findMax(double arr[], int size);
string findLongerStringInFile(ifstream &infile);
void countLetters(ifstream &infile, int counts[]);

//main
int main()
{
    double arr[] = {1,2,3,4,5};
    int size = 5;
    cout << calcAverage(arr, size) << endl;
    cout << findMax(arr, size) << endl;
}

//functions

double calcAverage(double arr[], int size)
{
    int sum = 0;
    for(int i = 0; i < size; i++)
    {
        sum += arr[i];
    }
    sum = (sum/size);
    return sum;
}

double findMax(double arr[], int size)
{
    int max = 0;
    for(int i = 0; i < size; i++)
    {
        if (max < arr[i]){max = arr[i];}
    }
    return max;
}

string findLongestStringInFile(ifstream &infile)
{
    string temp;
    string longestString;
    while (!infile.eof())
    {
        infile >> temp;
        if (!infile.fail())
            if (temp.length() > longestString.length())
            {
                longestString = temp;
            }
    }
    return longestString;
}

void countLetters(ifstream &infile, int counts[])
{
    string temp;
    while (!infile.eof())
    {
        infile >> temp;
        for (int i = 0; i < 26; i++)
        {
            counts[i] = 0;
        }
        for(int i = 0; i < temp.length(); i ++)
        {
            counts[i] = temp[i];
        }
    }
    
}
