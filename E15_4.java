package E15_4;

import java.io.*;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class E15_4
{
    public static void main(String[] args)
    {

        Map<String,String> info = new HashMap<>();
        String menuChoice = menu();
        while(!menuChoice.equalsIgnoreCase("q"))
        {
            studentInfo(menuChoice, info);
            menuChoice = menu();
        }

    }

    public static void studentInfo(String menuChoice, Map info)
    {
        // Add a student
        if(menuChoice.equalsIgnoreCase("a"))
        {
            addStudent(info);
        }
        // Remove a student
        else if(menuChoice.equalsIgnoreCase("r"))
        {
            removeStudent(info);
        }
        // Modify a grade
        else if(menuChoice.equalsIgnoreCase("m"))
        {
            modifyGrade(info);
        }
        // Print all grades
        else if(menuChoice.equalsIgnoreCase("p"))
        {
            print(info);
        }

    }

    // Adds student to map
    public static void addStudent(Map info)
    {
        Scanner scn = new Scanner(System.in);
        String name, grade;
        System.out.println("Enter student name: ");
        name = scn.nextLine();
        System.out.println("Enter student grade: ");
        grade = scn.nextLine();
        info.put(name,grade);
    }

    // Removes student from map
    public static void removeStudent(Map info)
    {
        String name;
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter student name you would like to remove: ");
        name = scn.nextLine();
        if(info.containsKey(name))
        {
            info.remove(name);
            System.out.println(name + " was successfully removed");
        }
        else
        {
            System.out.println(name+" is not in system.");
        }
    }

    // Modifies grade value attached to student name
    public static void modifyGrade(Map info)
    {
        String name, grade;
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter student name whose grade you would like to modify: ");
        name = scn.nextLine();
        if(info.containsKey(name)) {
            System.out.println("Enter the new grade: ");
            grade = scn.nextLine();
            info.put(name, grade);
        }
        else
        {
            System.out.println(name + " is not in the system");
        }
    }

    // Prints all in map
    public static void print(Map info)
    {
        for(Object key : info.keySet())
        {
            System.out.println(key + ": " + info.get(key));
        }
    }

    // Prints menu and gets choice
    public static String menu()
    {
        // Menu
        Scanner scn = new Scanner(System.in);
        System.out.println("Select an option: ");
        System.out.println("(a) to add a student");
        System.out.println("(r) to remove a student");
        System.out.println("(m) to modify a grade");
        System.out.println("(p) to print all grades");
        System.out.println("(q) to quit");
        String menuChoice = scn.next();

        while(!(menuChoice.equalsIgnoreCase("a") || menuChoice.equalsIgnoreCase("r") || menuChoice.equalsIgnoreCase("m")
        || menuChoice.equalsIgnoreCase("p") || menuChoice.equalsIgnoreCase("q"))) {
            System.out.println("Invalid choice");
            System.out.println("Select an option: ");
            menuChoice = scn.next();
        }
        return menuChoice;
    }
}
