// Samuel Feye
// CS240
// Professor Klein
// 04.23.2018
// Project 4 / HW 4
// BinaryTreeLinked.h

// header file for the template class
#pragma once
#include<iostream>
using namespace std;

template<class T>
class BinaryTreeLinked
{
public:
    struct node;
    typedef node* nodePtr;
    struct node
    {
        T data;
        nodePtr left, right;
    };
    nodePtr root;
public:
    int levels = 0;
    BinaryTreeLinked();
    ~BinaryTreeLinked();
    void deleteTree();
    void insert(T elt);
    // TODO functions
    void printInorder() const;
    void countNodesPerLevel(int counts[], int &levels, int arraySize) const;
    void countParentTypes(int counts[]) const;
private:
    void recursiveInsert(T elt, nodePtr &curr);
    void recursiveDeleteTree(nodePtr & curr);
    void recursivePrint (nodePtr temp) const;
    int recursiveCountLevels(nodePtr temp, int &levels) const;
    int recursiveCountNodesPerLevel(nodePtr temp, int base, int depth) const;
};
template<class T>
BinaryTreeLinked<T>::BinaryTreeLinked()
{
    root = nullptr;
//    root = new node();
//    root->data = 14;
//    root->left = new node();
//    root->right = new node();
//    root->left->right = new node();
//    root->right->right = new node();
//    root->left->data = 4;
//    root->right->data = 51;
//    root->left->right->data = 5;
//    root->right->right->data = 80;
}

template<class T>
BinaryTreeLinked<T>::~BinaryTreeLinked()
{
    recursiveDeleteTree(root);
}
// public functions
template<class T>
void BinaryTreeLinked<T>::deleteTree()
{
    recursiveDeleteTree(root);
    root = nullptr; //prevents root from being a dangling ptr
}
template<class T>
void BinaryTreeLinked<T>::insert(T elt)
{
    recursiveInsert(elt, root);
}

// TODO fucntions /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
template<class T>
void BinaryTreeLinked<T>::printInorder() const
{
    recursivePrint(root);
    cout << endl;
}
template<class T>
void BinaryTreeLinked<T>::countNodesPerLevel(int counts[], int &levels, int arraySize) const
{
    // if levels is greater than arraySize then it ends
    if(levels > arraySize)
        return;
    recursiveCountLevels(root, levels);
    for(int i = 0; i < levels; i++)
    {
        cout << "c[" << i << "] " << recursiveCountNodesPerLevel(root, 0, i) << endl;
    }
    cout << "Levels: " << levels << endl << endl;
}
template<class T>
void BinaryTreeLinked<T>::countParentTypes(int counts[]) const
{
    //j is used to print down from parent to children
    int j = (levels-1);
    for(int i = 0; i < levels; i++)
    {
        cout << "c[" << i << "] " << recursiveCountNodesPerLevel(root, 0, j) << endl;
        j--;
    }
}
// End TODO functions ////////////////////////////////////////////////////////////////

// private funtions
// GIVEN FUNCTIONS //////////////////////////////////////////////////////////////////////////////
template<class T>
void BinaryTreeLinked<T>::recursiveDeleteTree(nodePtr & curr)
{
    if (curr != nullptr)
    {
        recursiveDeleteTree(curr->left); //always works for any tree because it handles everything
        recursiveDeleteTree(curr->right); //post-order traversal
        delete curr;
    }
}

template<class T>
void BinaryTreeLinked<T>::recursiveInsert(T elt, nodePtr &curr)
{
    if (curr == nullptr)
    {
        curr = new node;
        curr->data = elt;
        curr->left = curr->right = nullptr;
    }
    else if (elt < curr->data)
        recursiveInsert(elt, curr->left);
    else
        recursiveInsert(elt, curr->right);
}
// End Given //////////////////////////////////////////////////////////////////////////////

// print function ///////////////////////////////////////////////////////////
template<class T>
void BinaryTreeLinked<T>::recursivePrint(nodePtr temp) const
{
    if(temp == nullptr)
        return;
    else if (temp == root)
        cout << "Root: " << temp->data << endl;
    if (temp->left != nullptr)
    {
        if(temp->left->left != nullptr && temp->left->right != nullptr)
            cout << temp->left->data << " Left child: " << temp->left->left->data << " Right child: " << temp->left->right->data << endl;
        else if(temp->left->left != nullptr && temp->left->right == nullptr)
            cout << temp->left->data << " Left child: " << temp->left->left->data << " Right child: " << "--" << endl;
        else if(temp->left->left == nullptr && temp->left->right != nullptr)
            cout << temp->left->data << " Left child: " << "--" << " Right child: " << temp->left->right->data << endl;
        else
            cout << temp->left->data << " Left child: " << "--" << " Right child: " << "--" << endl;
        recursivePrint(temp->left);
    }
    if (temp == root)
    {
        if(temp->left != nullptr && temp->right != nullptr)
            cout << temp->data << " Left child: " << temp->left->data << " Right child: " << temp->right->data << endl;
        else if(temp->left != nullptr && temp->right == nullptr)
            cout << temp->left->data << " Left child: " << temp->left->left->data << " Right child: " << "--" << endl;
        else if(temp->left == nullptr && temp->right != nullptr)
            cout << temp->data << " Left child: " << "--" << " Right child: " << temp->right->data << endl;
        else
            cout << temp->data << " Left child: " << "--" << " Right child: " << "--" << endl;
    }
    if (temp->right != nullptr)
    {
        if(temp->right->left != nullptr && temp->right->right != nullptr)
            cout << temp->right->data << " Left child: " << temp->right->left->data << " Right child: " << temp->right->right->data << endl;
        else if(temp->right->left != nullptr && temp->right->right == nullptr)
            cout << temp->right->data << " Left child: " << temp->right->left->data << " Right child: " << "--" << endl;
        else if(temp->right->left == nullptr && temp->right->right != nullptr)
            cout << temp->right->data << " Left child: " << "--" << " Right child: " << temp->right->right->data << endl;
        else
            cout << temp->right->data << " Left child: " << "--" << " Right child: " << "--" << endl;
        recursivePrint(temp->right);
    }
}
// count levels function ////////////////////////////////////////////////////////
template<class T>
int BinaryTreeLinked<T>::recursiveCountLevels(nodePtr temp, int &levels) const
{
    if(temp == nullptr)
        return 0;
    else
    {
        int lCount = recursiveCountLevels(temp->left, levels);
        int rCount = recursiveCountLevels(temp->right, levels);
        if (lCount > rCount)
        {
            levels = lCount + 1;
            return levels;
        }
        else
        {
            levels = (rCount + 1);
            return(levels);
        }
    }
}
// count nodes per level function /////////////////////////////////////////////////
// function takes parameters base and depth to traverse based on the current level and the bottom level
template<class T>
int BinaryTreeLinked<T>::recursiveCountNodesPerLevel (nodePtr temp, int base, int depth) const
{
        if (temp == NULL)
            return 0;
        if (base == depth)
            return 1;
        return recursiveCountNodesPerLevel(temp->left,  base+1, depth) + recursiveCountNodesPerLevel(temp->right, base+1, depth);
}




