import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class function {

    public static void main(String[] args) {
        boolean b1 =false;
        boolean b2=false;


        ArrayList<Integer> e1 =new ArrayList<Integer>();
        ArrayList<Integer> f1 =new ArrayList<Integer>();
        try {
            File file=new File("");
            Scanner sc =new Scanner(file);
            while(sc.hasNextLine())
            {
                String [] in=sc.nextLine().split(",");

                e1.add(Integer.parseInt(in[0].replaceAll("[^0-9]","")));
                f1.add(Integer.parseInt(in[1].replaceAll("[^0-9]","")));
                if (e1.contains(f1.get(f1.size()-1)))
                {
                    if(b1)
                    {b1=false;}
                    else
                    {b2=false;}
                }
                if (!b1 && !b2)
                {
                    System.out.println("error");
                    throw new FileNotFoundException();

                }




            }


        }
        catch (FileNotFoundException e)
        {
            System.out.println("error");

        }
        Map<Integer, Long> freq= f1.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        freq.entrySet().stream().sorted(Map.Entry.comparingByValue()).limit(3).forEach(System.out::println);


    }
}
