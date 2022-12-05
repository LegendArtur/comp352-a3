import java.io.File;
import java.util.Scanner;

public class EHITS {
    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);

        //TESTING FILE 1
        System.out.print("TESTING FILE 1\n");

        ElasticERL erl1 = new ElasticERL();
        erl1.SetEINTreshhold(500000);
        
        File file = new File("EHITS_test_file1.txt");
        try {
            Scanner sc = new Scanner(file);
            
            for(int i = 0; i < 500000; i++) {
                erl1.add(Integer.parseInt(sc.nextLine()), "ID" + i);
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("File not found");
        }

        testERL(erl1, kb);

        //TESTING FILE 2
        System.out.print("\n\n\n\n\nTESTING FILE 2\n");

        erl1 = new ElasticERL();
        erl1.SetEINTreshhold(500000);
        
        file = new File("EHITS_test_file2.txt");
        try {
            Scanner sc = new Scanner(file);
            
            for(int i = 0; i < 500000; i++) {
                erl1.add(Integer.parseInt(sc.nextLine()), "ID" + i);
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("File not found");
        }

        testERL(erl1, kb);

        //TESTING FILE 3
        System.out.print("\n\n\n\n\nTESTING FILE 3\n");

        erl1 = new ElasticERL();
        erl1.SetEINTreshhold(500000);
        
        file = new File("EHITS_test_file3.txt");
        try {
            Scanner sc = new Scanner(file);
            
            for(int i = 0; i < 500000; i++) {
                erl1.add(Integer.parseInt(sc.nextLine()), "ID" + i);
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("File not found");
        }

        testERL(erl1, kb);

        //TESTING generate() for 40000
        System.out.print("\n\n\n\n\nTESTING generate() for 40000\n");

        erl1 = new ElasticERL();
        erl1.SetEINTreshhold(40000);
        
        
        for(int i = 0; i < 40000; i++) {
            erl1.add(erl1.generate(), "ID" + i);
        }

        testERL(erl1, kb);

        //TESTING generate() for 400000
        System.out.print("\n\n\n\n\nTESTING generate() for 400000\n");

        erl1 = new ElasticERL();
        erl1.SetEINTreshhold(400000);
        
        
        for(int i = 0; i < 400000; i++) {
            erl1.add(erl1.generate(), "ID" + i);
        }

        testERL(erl1, kb);
        
        kb.close();
    }

    /**
     * This function tests the ElasticERL class by printing the contents of the ElasticERL,
     * getting the value at a specified index, 
     * getting the next key at a specified index, 
     * getting the previous key at a specified index, 
     * removing a key at a specified index, 
     * printing the contents of the ElasticERL, 
     * printing the contents of the DoublyLinkedList returned by the allKeys() method, 
     * and finally printing the distance between two specified keys
     * 
     * @param erl1 ElasticERL object
     * @param kb Scanner object
     */
    private static void testERL(ElasticERL erl1, Scanner kb) {
        erl1.printContents();

        System.out.print("\nSet index to get value: ");
        int input = kb.nextInt();
        System.out.println(erl1.getValues(input));

        System.out.print("\nSet index to get next: ");
        input = kb.nextInt();
        int value = erl1.nextKey(input);
        if (value == -1) {
            System.out.println(input + " -> null");
        } else {
            System.out.println(input + " -> " + value);
        }
        
        System.out.print("\nSet index to get prev: ");
        input = kb.nextInt();
        value = erl1.prevKey(input);
        if (value == -1) {
            System.out.println("null <- " + input);
        } else {
            System.out.println(value + " <- " + input);
        }
        
        System.out.print("\nSet index to remove: ");
        input = kb.nextInt();
        erl1.remove(input);
        erl1.printContents();

        System.out.println("\nallKeys() gives a sorted Sequence implemented as Doubly Linked List: ");
        DoublyLinkedList dll = erl1.allKeys();
        dll.printContents();

        System.out.println("\nThe final method is rangeKeys(). Select two keys from:\n");
        erl1.printContents();

        System.out.print("\nSelect key1: ");
        input = kb.nextInt();
        System.out.print("\nSelect key2: ");
        int key2 = kb.nextInt();
        System.out.println("Distance is: " + erl1.rangeKey(input, key2));
    }
}
