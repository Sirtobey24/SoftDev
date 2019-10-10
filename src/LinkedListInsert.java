import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class LinkedListInsert
{
    public static void main(String[] args)
    {
        LinkedList<Integer> list = new LinkedList<>();
        Random rand = new Random();
        int sum = 0;
        double average = 0.0;

        for (int i = 0; i < 25; i++)
        {
            int randint = rand.nextInt(100);
            list.push(randint);
        }

        Collections.sort(list);
        System.out.println(list);

        Iterator<Integer> itr = list.iterator();
        while (itr.hasNext())
        {
            sum += itr.next();
        }
        average = (float) sum / list.size();

        System.out.println("Sum is: " + sum);
        System.out.printf("Average is: %.2f", average);

        Collections.reverse(list);
        System.out.println("\n" + list);
    }

}
