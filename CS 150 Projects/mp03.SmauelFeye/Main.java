import java.util.Date;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class Main {
    private static enum UniversityMemberClassification {
        INSTRUCTOR,
        STUDENT,
        NONE
    }
    
    /* Create the ArrayList of UniversityMember instances. */
    private static ArrayList<UniversityMember> uMembers;
    
    public static void main(String[] args) {
        try
        {
            //loads the text file universityMember.txt
            uMembers = loadFromFile("universityMembers.txt");
            System.out.println("Instructor list: ");
            System.out.println();
            //diplays all of the members that are instances of 
            //the instructor class
            displayUniversityMembers(UniversityMemberClassification.INSTRUCTOR);
            
            System.out.println("Student list: ");
            System.out.println();
            //displays all of the members that are instances of
            //the student class
            displayUniversityMembers(UniversityMemberClassification.STUDENT);
            
            System.out.println();
            System.out.println("Member list: ");
            //prints out all members found in the file
            System.out.println(uMembers);            
        }
        catch (FileNotFoundException e)
        {
            //provides a message in class the file is 
            //unable to load
            e.getMessage();
        }
    }
    
    private static ArrayList<UniversityMember> loadFromFile(String filename) throws FileNotFoundException {
        ArrayList<UniversityMember> uMembers = new ArrayList<>();
        
        try ( Scanner fin = new Scanner( new File(filename) ); ) {
            String line;
            String[] fields;
            int courseCount;
            String course;
            Instructor instructor;
            Student student;
            
            while ( fin.hasNext() ) {
                /* Instructor or Student */
                line = fin.nextLine();
                fields = line.split(",");
                
                /* Instantiate appropriate object type */
                if ( fields[0].equals("i") ) {
                    instructor = new Instructor( fields[1], fields[2], new Date() );
                    
                    /* Course count */
                    courseCount = Integer.parseInt( fin.nextLine() );
                
                    /* Courses */
                    for (int i = 1; i <= courseCount; i++) {
                        course = fin.nextLine();
                    
                        instructor.addCourse(course);
                    }
                    uMembers.add(instructor);
                    
                } else {
                    student = new Student( fields[1], fields[2], new Date() );
                    courseCount = Integer.parseInt( fin.nextLine() );
                    
                    for (int i = 1; i <=courseCount; i++)
                    {
                      course = fin.nextLine();
                      student.addCourse(course);
                    }
                    
                    uMembers.add(student);
                }// end if
            }// end while
        }
        
        return uMembers;
    }//end loadFromFile
    
    private static void displayUniversityMembers(UniversityMemberClassification classification) 
    {
        for (UniversityMember member : uMembers)
        {
            //checks to see if the member is a student or instrcutor then uses
            //that classifications toString method to display that member
            
            if (classification.equals(UniversityMemberClassification.STUDENT) && member instanceof Student)
            {
                System.out.println( member );
            }//end if
            
            
            if (classification.equals(UniversityMemberClassification.INSTRUCTOR) && member instanceof Instructor)
            {
                System.out.println( member );
            }//end if
            
        }//for
        
    }//end displayUniversityMembers

}
