import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class function {

    public static void main(String[] args) throws Exception {
        boolean b1 =true;
        boolean b2=true;


        ArrayList<Integer> e1 =new ArrayList<Integer>();
        ArrayList<Integer> f1 =new ArrayList<Integer>();
        try {
            File file=new File("log.txt");
            file.createNewFile();
            Scanner sc =new Scanner(file);
            while(sc.hasNextLine())
            {
                String [] in=sc.nextLine().split(",");

                e1.add(Integer.parseInt(in[0].replaceAll("[^0-9]","")));
                f1.add(Integer.parseInt(in[1].replaceAll("[^0-9]","")));
                //System.out.println(e1);
                //System.out.println(f1);






            }


        }
        catch (FileNotFoundException e)
        {
            System.out.println("error 2 ");
            throw new Exception();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (Integer inte: f1) {


            if (e1.contains(inte)) {
                System.out.println("ee");
                if (b1) {
                    b1 = false;
                } else {
                    b2 = false;
                    break;
                }
            }

        }
        if (!b1 && !b2) {
            System.out.println("error 1 ");
            throw new Exception();

        }
        else {
            Map<Integer, Long> freq = f1.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            System.out.println("Top 3 Menu Items Consumed");
            freq.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(3).forEach(System.out::println);
        }

    }
}
