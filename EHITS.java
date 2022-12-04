import java.io.File;
import java.util.Scanner;

public class EHITS {
    public static void main(String[] args) {
        ElasticERL erl1 = new ElasticERL();
        erl1.SetEINTreshhold(100);
        
        File file = new File("EHITS_test_file1.txt");
        try {
            Scanner sc = new Scanner(file);
            sc.close();
        } catch (Exception e) {
            System.out.println("File not found");
        }
        
        
        for (int i = 0; i < 100; i++) {
            // System.out.println(erl1.allKeys().toString());
            erl1.add("Machine" + i);
            System.out.println("test3");
        }



        // int i = 1;
        // while (sc.hasNextLine()) {
        // erl1.add(Integer.parseInt(sc.nextLine()), "Machine line: " + i);
        // }

        // sc.close();
    }
}
