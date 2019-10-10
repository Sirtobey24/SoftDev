import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class SetDemo
{
    private static HashSet<String> hashSet;
    private static HashSet<String> userinputwords;
    private static Scanner sc = new Scanner(System.in);
    private static String inputFileName;

    public static void main(String[] args)
    {
        hashSet = new HashSet<String>();
        getNames();
        searchNames("");
        printNames();
    }

    public static void getNames()
    {
        boolean find = false;
        while (!find)
        {
            try
            {
                System.out.println("What is the name of the input file with random names?: ");
                inputFileName = sc.nextLine().trim();
                File file = new File(inputFileName);
                Scanner s = new Scanner(file);

                while (s.hasNext())
                {
                    hashSet.add(s.next());
                }
                find = true;
                s.close();
                //System.out.println("Existing word list: " + hashSet.toString()); //testing
            } catch (FileNotFoundException e)
            {
                System.out.println("File is not found! Please try again!");
            }
        }

    }

    public static void searchNames(String userinput)
    {
        userinputwords = new HashSet<>();
        System.out.println("Enter a name to search for, use 99 to terminate searching: ");
        while (!userinput.equals("99"))
        {
            userinput = sc.next();
            if (userinput.equals("99"))
            {
                break;
            }
            userinputwords.add(userinput);
        }

        for (String key : userinputwords)
        {
            if (hashSet.contains(key))
            {
                System.out.println(key + " is found in set");
            }
            else
            {
                System.out.println(key + " is not found in set");
            }
        }
    }

    public static void printNames()
    {
        Iterator<String> itr = hashSet.iterator();
        System.out.println("The list of names without any duplicates: \n");
        while (itr.hasNext())
        {
            System.out.println(itr.next());
        }
    }
}
