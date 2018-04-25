CS150 - Introduction to Computing II - mp03 (Exception Hanling) - 50 pts 

Due: 5:00 pm Friday, February 10, 2017
==========================================================================================
Electronic submission:
You must submit a single .zip archive file of your BlueJ project folder. Use
a utility that produces .zip files (Windows: right click | Send to | compress,
Mac: right click | compress). No other formats will be accepted.
==========================================================================================
Objectives:
    - To learn about exceptions in Java while reading/writing from a text file.
    - To continute using JUnit to unit test your classes.
    - To further make use of inheritance and polymorphism.
==========================================================================================
Project setup:
Existing project:
Rename the project to mp<n>.<FirstLast>

New project: 
Using BlueJ, create the project mp<n>.<FirstLast>

Either project:
Replace <n> with the mp's number and <FirstLast> with your name. Do not include the <> brackets. 
For instance, mp03.SocratisTornaritis. 

This is the only acceptable name, so please be careful. Any other variation 
of this will not be graded.

Refer to the appropriate "how to" tutorials available on the course website, 
for instructions on how to create a BlueJ project and manage its files.
==========================================================================================
Language features used:
    - inheritance
    - polymorphism
    - exceptions
    - file IO
    - ArrayLists
==========================================================================================
Problem Description:
In this assignment you are going to make use of files to read in instructor and student
records. These records reflect personal information along with courses taught or taken,
based on university member classification.

A superclass, UniversityMember, and two subclasses, Instructor and Student round up the
classes used. ArrayLists are used both as members and in the driver as the primary storage
mechanism for courses and UniversityMembers.

Your program will read and load all the records into an ArrayList of UniversityMember
instances, with each ArrayList item being of a subclass type. This is our polymorphic
set up.

Once the data is loaded, your program will then list out the records, first by member
type, an then in their entirety.
==========================================================================================
Sample output:

Instructor List:
    Instructor: Doe, John
           doh: Jan 30, 2017
Courses taught: (2)
	CS140-Introduction to Computing I
	CS150-Introduction to Computing II

    Instructor: Smith, Mary
           doh: Jan 30, 2017
Courses taught: (1)
	CS240-Introduction to Computing III


Student List:
       Student: Doe, Jane
      enrolled: Jan 30, 2017
 Courses taken: (3)
	CS111-Computer Concepts
	CS140-Introduction to Computing I
	PE100-Volleyball

       Student: Smith, Joe
      enrolled: Jan 30, 2017
 Courses taken: (2)
	CS150-Introduction to Computing III
	CS234-Database and Web Development


Member List:
    Instructor: Doe, John
           doh: Jan 30, 2017
Courses taught: (2)
	CS140-Introduction to Computing I
	CS150-Introduction to Computing II

       Student: Doe, Jane
      enrolled: Jan 30, 2017
 Courses taken: (3)
	CS111-Computer Concepts
	CS140-Introduction to Computing I
	PE100-Volleyball

    Instructor: Smith, Mary
           doh: Jan 30, 2017
Courses taught: (1)
	CS240-Introduction to Computing III

       Student: Smith, Joe
      enrolled: Jan 30, 2017
 Courses taken: (2)
	CS150-Introduction to Computing III
	CS234-Database and Web Development

==========================================================================================
Program requirements:
    (1) Add a new class to the project. Name this class UniversityMember.
    (2) Add a new class to the project. Name this class Instructor.
    (3) Add a new class to the project. Name this class Student.
    (4) Implement each class by translating its UML class diagram, given below.
    (5) Run the unit tests each time you implement a method or class. This will help you figure
    out any mistakes in the code or logic.
    (6) Create a text file, named universityMembers.txt with the following records:
    
    i,John,Doe
    2
    CS140-Introduction to Computing I
    CS150-Introduction to Computing II
    s,Jane,Doe
    3
    CS111-Computer Concepts
    CS140-Introduction to Computing I
    PE100-Volleyball
    i,Mary,Smith
    1
    CS240-Introduction to Computing III
    s,Joe,Smith
    2
    CS150-Introduction to Computing III
    CS234-Database and Web Development
    
    The format of the file is as follows:
    
    i - instructor, s - student
    count of courses
    list of courses
    
    (7) Add the provided class Main to the project. This class is partially implemented for
    you as a starting point.
    
    To complete the driver's implementation you should carray out the following:
    
    (a) main() - Use a try/catch block to call the method loadFromFile() to load all the
    data from the file, and the method displayUniversityMembers() three times, one for each
    of the three separate lists to display. See sample output above.
    
    (b) displayUniversityMembers() - Use a switch statement to produce the appropriate list.
    Here you will have to use the 'instanceof' operator to find out the type of instance in
    the ArrayList so you may produce the exact list desired.
    
    (c) loadFromFile() - Implement the 'else' body that addresses Student instance. It should
    be almost identical to the code in the 'if' body for Instructor instances.
    
    
==========================================================================================


---------------------------------------------------------------------------------
                                UniversityMember <<superclass>>
---------------------------------------------------------------------------------
-first: String
-last: String
-dateCreated: Date
---------------------------------------------------------------------------------
+UniversityMember(first: String, last: String, dateCreated: Date)

+getFirst(): String <<final>>
+getlast(): String <<final>>
+getName(): String <<final>>
+getDateCreated(): Date <<final>>

+setFirst(first: String): void <<final>>
+setLast(last: String): void <<final>>
+setName(first: String, last: String): void <<final>>
+setDateCreated(dateCreated: Date): void <<final>>

+toString(): String <<Override>
---------------------------------------------------------------------------------
Method notes:
    - getName(): Returns the name as: <last>, <first>
    
    - toString(): Returns the formatted string: 
    [<last>, <first>][<dateCreated]

==========================================================================================



---------------------------------------------------------------------------------
                                Instructor <<extends UniversityMember>>
---------------------------------------------------------------------------------
-coursesTaught: ArrayList<String>
---------------------------------------------------------------------------------
+Instructor(first: String, last: String, dateHired: Date)

+getCoursesTaught(): ArrayList<String> <<final>>
+addCourse(course: String): void <<final>>

+toString(): String <<Override>>
---------------------------------------------------------------------------------
Method notes:
    - ctor: Initializes inherited properties, then assigns an instance of the
    ArrayList class to the coursesTaught property.
    
    - descriptor: Returns the formatted object:
        Instructor: <last>, <first>
               doh: <dateCreated>
    Courses taught: (2)
        CS140-Introduction to Computing I
        CS150-Introduction to Computing II
        ...
==========================================================================================



---------------------------------------------------------------------------------
                                Student <<extends UniversityMember>>
---------------------------------------------------------------------------------
-coursesTaken: ArrayList<String>
---------------------------------------------------------------------------------
+Student(first: String, last: String, dateEnrolled: Date)

+getCoursesTaken(): ArrayList<String> <<final>>
+addCourse(course: String): void <<final>>

+toString(): String <<Override>>
---------------------------------------------------------------------------------
- ctor: Initializes inherited properties, then assigns an instance of the
    ArrayList class to the coursesTaken property.
    
    - descriptor: Returns the formatted object:
          Student: <last>, <first>
         enrolled: <dateCreated>
    Courses taken: (2)
        CS140-Introduction to Computing I
        CS150-Introduction to Computing II
        ...
==========================================================================================
Grading Rubric:
================================================================================
Feature:                                                            Points
Reward submission (5:00p Wed)                                           +5
Penalized submission (5:00p Sat)                                       -25
Late submission (> 5:00p Sat)                                          -50
--------------------------------------------------------------------------------
Project file not named properly                                         -5
--------------------------------------------------------------------------------
Program does not compile or run                                         -6
--------------------------------------------------------------------------------
Coding style:
 - no comments, bad variable names, no code structure                   -5
--------------------------------------------------------------------------------
UniversityMember class:                                                 10 
--------------------------------------------------------------------------------
Instructor class:                                                       10 
--------------------------------------------------------------------------------
Student class:                                                          10      
--------------------------------------------------------------------------------
Main class:                                                             15
--------------------------------------------------------------------------------
Text file not created:                                                   5         
--------------------------------------------------------------------------------