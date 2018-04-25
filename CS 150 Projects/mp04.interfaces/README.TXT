CS150 - Introduction to Computing II - mp04 (Interfaces) - 50 pts 

Due: 5:00 pm Friday, February 26, 2017
==========================================================================================
Electronic submission:
You must submit a single .zip archive file of your BlueJ project folder. Use
a utility that produces .zip files (Windows: right click | Send to | compress,
Mac: right click | compress). No other formats will be accepted.
==========================================================================================
Objectives:
    - To understand the effectiveness of interfaces and how to use them.
    - To get more practice with file IO.
    - To get more exposure to Unit testing.
==========================================================================================
Project setup:
Existing project:
Rename the project to mp<n>.<FirstLast>

New project: 
Using BlueJ, create the project mp<n>.<FirstLast>

Either project:
Replace <n> with the mp's number and <FirstLast> with your name. Do not include the <> brackets. 
For instance, mp04.SocratisTornaritis. 

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
    - Abstract classes and Interfaces
==========================================================================================
Problem Description:
    In this assignment you are going to make use of files to read in Employee records into 
    an array. This array will then be sorted using selection sort, and then the results 
    displayed to the screen. See output below.

    The assignment will make use of abstract classes and interfaces to tie everything
    together. See the requirements below for details.
==========================================================================================
Sample output:

Original employee list:
-----------------------
  Intern: [iLast1, iFirst1] [Paycheck: $0.00]
FullTime: [ftLast1, ftFirst1] [Annual salary: $65000.00] [Paycheck: $2500.00]
PartTime: [ptLast1, ptFirst1] [hours: 50.0 (r: 40.0, o: 10.0)] [rate: $13.50] [Paycheck: $742.50 (r: $540.00, o: $202.50)]
FullTime: [ftLast2, ftFirst2] [Annual salary: $55000.00] [Paycheck: $2115.38]
PartTime: [ptLast2, ptFirst2] [hours: 40.0 (r: 40.0, o: 0.0)] [rate: $20.00] [Paycheck: $800.00 (r: $800.00, o: $0.00)]

Sorted employee list:
---------------------
FullTime: [ftLast1, ftFirst1] [Annual salary: $65000.00] [Paycheck: $2500.00]
FullTime: [ftLast2, ftFirst2] [Annual salary: $55000.00] [Paycheck: $2115.38]
  Intern: [iLast1, iFirst1] [Paycheck: $0.00]
PartTime: [ptLast1, ptFirst1] [hours: 50.0 (r: 40.0, o: 10.0)] [rate: $13.50] [Paycheck: $742.50 (r: $540.00, o: $202.50)]
PartTime: [ptLast2, ptFirst2] [hours: 40.0 (r: 40.0, o: 0.0)] [rate: $20.00] [Paycheck: $800.00 (r: $800.00, o: $0.00)]
==========================================================================================
Program requirements:
    The file "employees.txt" is provided for you. Make sure it is newline terminated in 
    your environment (Windows users).

    The file consists of three types of employee record, I-Intern, F-Full time, and 
    P-Part time. Each record type has a variable amount of fields as shown below:

    I,<first>,<last>
    F,<first>,<last>,<annualSalary>
    P,<first>,<last>,<hourlyRate>,<hoursPerWeek>

    There are three types of employees, FullTime, PartTime and Intern, each represented by
    a corresponding concrete class. The abstract Employee class serves as their superclass.
    The Employee class implements the Comparable interface, so that employees can be compared
    to each other by last name first name order.

    The interface PayPolicy is implemented by the three concret pay classes, PayWithSalary,
    PayWithWage and PayWithNoPay. Each one defines the pay behavior that employees may
    exhibit. This interface is used by the Employee class as a property defining each
    Employee's pay behavior.

    Several classes have been provided that need implementing. These are:
    
    (1) Employee - the absract superclass
    (2) FullTime - the full time employee
    (3) PartTime - the part time employee
    (4) Intern - the intern
    
    (5) PayPolicy - the interface defining pay behavior
    (6) PayWithSalary - pay class for salaried employees (FullTime)
    (7) PayWithWage - pay class for hourly employees (PartTime)
    (8) PayWithNoPay - pay class for free labor (Intern)
    
    (9) Main - the driver
    
    Refer to each class for TODO comments. These will instruct you to what you need
    to add/change.
    
    Below are the UML class diagrams of all the classes, interfaces you are to add.
    
==========================================================================================


---------------------------------------------------------------------------------
                                PayPolicy <<interface>>
---------------------------------------------------------------------------------

---------------------------------------------------------------------------------
+pay(): double
---------------------------------------------------------------------------------
Method notes:
    - pay(): the abstract method that all classes implementing this interface must provide
==========================================================================================



---------------------------------------------------------------------------------
                                PayWithSalary <<implements PayPolicy>>
---------------------------------------------------------------------------------
-annualSalary: double
---------------------------------------------------------------------------------
+PayWithSalary(annualSalary: double)

+getAnnualSalary(): double <<final>>
+setAnnualSalary(annualSalary: double): void <<final>>

+pay(): double <<Override>>

+toString(): String <<Override>>
---------------------------------------------------------------------------------
Method notes:
    - ctor: Initializes object.
    
    - pay(): returns the bi-weekly paycheck amount.
==========================================================================================



---------------------------------------------------------------------------------
                                PayWithWage <<implements PayPolicy>>
---------------------------------------------------------------------------------
-hourlyRate: double
-hoursPerWeek: double
-regularHours: double
-overtimeHours: double
---------------------------------------------------------------------------------
+PayWithWage(hourlyRate: double, hoursPerWeek: double)

+getHourlyRate(): double <<final>>
+getHoursPerWeek(): double <<final>>
+getRegularHours(): double <<final>>
+getOvertimeHours(): double <<final>>

+setHourlyRate(hourlyRate: double): void <<final>>
+setHoursPerWeek(hoursPerWeek: double): void <<final>>

+regularPay(): double
+overtimePay(): double
+pay(): double <<Override>>
---------------------------------------------------------------------------------
Method notes:
    - ctor: Initializes object.
    
    - setHoursPerWeek(): sets all hour properties. If more than 40 hours are worked
    then those extra hours are the overtime hours.
    
    - regularPay(): returns a 40 hour pay load.
    
    - overtimePay(): returns the overtime pay at 1.5 the rate.
    
    - pay(): returns the weekly total paycheck amount.
==========================================================================================




---------------------------------------------------------------------------------
                                PayWithNoPay <<implements PayPolicy>>
---------------------------------------------------------------------------------

---------------------------------------------------------------------------------
+pay(): double <<Override>>
---------------------------------------------------------------------------------
Method notes:
    - pay(): returns 0.0, since interns do not get paid. This choice makes things
    simpler.
==========================================================================================




---------------------------------------------------------------------------------
               Employee <<abstract>><< implements Comparable<Employee> >>
---------------------------------------------------------------------------------
-first: String
-last: String
#payPolicy: PayPolicy
---------------------------------------------------------------------------------
#Employee(first: String, last: String, payPolicy: PayPolicy)

+getFirst(): String <<final>>
+getlast(): String <<final>>
+getName(): String <<final>>
+getPayPolicy(): PayPolicy <<final>>

+setFirst(first: String): void <<final>>
+setLast(last: String): void <<final>>
+setName(first: String, last: String): void <<final>>
+setPayPolicy(payPolicy: PayPolicy): void <<final>>

+payCheck(): double

+compareTo(Employee o): int <<Override>>

+toString(): String <<Override>
---------------------------------------------------------------------------------
Method notes:
    - payCheck(): This method produces the employee's paycheck, whether weekly
    or bi-weekly, based on the employee type. This determination is made by
    the .pay() method of the corresponding PayWithxxx class, which know how to
    create such a paycheck. Simply call this .pay() method and return its result.
    
    - compareTo(): This should compare the two employee instances using the formatted
    string: <last><space><first>
    
    - descriptor: Returns the formatted string: 
    [<last>, <first>]

==========================================================================================



---------------------------------------------------------------------------------
                                FullTime <<extends Employee>>
---------------------------------------------------------------------------------

---------------------------------------------------------------------------------
+FullTime(first: String, last: String, annualSalary: double)

+toString(): String <<Override>>
---------------------------------------------------------------------------------
Method notes:
    - ctor: Initializes its superclass. Note that the annualSalary is a property of
    the PayWithSalary class, which FullTime objects conform to.
    
    - descriptor: Returns the formatted object:
    FullTime: [<last>, first>] [Annual salary: $<annual salary>] [Paycheck: $<pay check>]
        
==========================================================================================



---------------------------------------------------------------------------------
                                PartTime <<extends Employee>>
---------------------------------------------------------------------------------

---------------------------------------------------------------------------------
+PartTime(first: String, last: String, hourlyRate: double, hoursPerWeek: double)

+toString(): String <<Override>>
---------------------------------------------------------------------------------
Method notes:
    - ctor: Initializes its superclass. Note that the hourlyRate and hoursPerWeek are
    properties of the PayWithWage class, which PartTime objects conform to.
    
    - descriptor: Returns the formatted object:
    PartTime: [<last>, first>] ↵
    [hours: <hours per week> (r: <regular>, o: <overtime>)] ↵
    [rate: $<hourly rate>] ↵
    [Paycheck: $<weekly pay> (r: $<regular pay>, o: $<overtime pay>)]
    
    Note: ↵ indicates continuation on the same line, i.e. the string is one single line.
==========================================================================================

    
---------------------------------------------------------------------------------
                                Intern <<extends Employee>>
---------------------------------------------------------------------------------

---------------------------------------------------------------------------------
+PartTime(first: String, last: String)

+toString(): String <<Override>>
---------------------------------------------------------------------------------
Method notes:
    - ctor: Initializes its superclass, conforming to the PayWithNoPay() pay class.
    
    - descriptor: Returns the formatted object:
    Intern: [<last>, first>] [Paycheck: $<pay>]
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
Main class:                                                             10 
--------------------------------------------------------------------------------
PayPolicy interface:                                                     2 
--------------------------------------------------------------------------------
PayWithSalary class:                                                     5      
--------------------------------------------------------------------------------
PayWithWage class:                                                       8
--------------------------------------------------------------------------------
PayWithNoPay class:                                                      2
--------------------------------------------------------------------------------
Employee class:                                                          8
--------------------------------------------------------------------------------
FullTime class:                                                          5
--------------------------------------------------------------------------------
PartTime class:                                                          5
--------------------------------------------------------------------------------
Intern class:                                                            5
--------------------------------------------------------------------------------