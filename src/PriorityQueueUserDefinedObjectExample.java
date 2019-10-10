import java.io.*;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PriorityQueueUserDefinedObjectExample
{
    public static void main(String[] args) throws IOException
    {
        PriorityQueue<Employee> pQueue = new PriorityQueue<>();
        Scanner sc = new Scanner(System.in);
        String inputFileName;
        String outputFileName;

        boolean find = false;
        while (!find)
        {
            try
            {
                System.out.println("What is the name of the input file with Employee salaries?: ");
                inputFileName = sc.nextLine().trim();
                File file = new File(inputFileName);
                Scanner s = new Scanner(file);
                while (s.hasNextLine())
                {
                    pQueue.add(new Employee(s.next(), s.nextDouble()));
                }
                find = true;
                s.close();
                System.out.println("Existing Employee list: " + pQueue.toString()); //testing
            } catch (FileNotFoundException e)
            {
                System.out.println("File is not found! Please try again!");
            }
        }

        System.out.println("Please enter the output file name to include the priority queue in: ");
        outputFileName = sc.nextLine().trim();
        FileWriter fileWriter = new FileWriter(outputFileName);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        while (!pQueue.isEmpty())
        {
            //System.out.println(pQueue.remove()); //testing
            printWriter.printf("%s\n", pQueue.remove());
        }
        printWriter.close();
    }
}
