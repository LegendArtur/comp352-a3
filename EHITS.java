import java.io.File;
import java.util.Scanner;

public class EHITS {
    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);

        System.out.print("Set threshold: ");
        int input = kb.nextInt();

        ElasticERL erl1 = new ElasticERL();
        erl1.SetEINTreshhold(input);
        
        File file = new File("EHITS_test_file1.txt");
        try {
            Scanner sc = new Scanner(file);
            
            for(int i = 0; i < input; i++) {
                erl1.add(Integer.parseInt(sc.nextLine()), "M" + i);
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("File not found");
        }

        System.out.println(erl1.toString());

        System.out.print("\nSet index to get value: ");
        input = kb.nextInt();
        System.out.println(erl1.getValues(input));

        System.out.print("\nSet index to get next: ");
        input = kb.nextInt();
        System.out.println(input);
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
        System.out.println(erl1.toString());

        System.out.println("\nallKeys() gives an already sorted Double Linked List: ");
        DoublyLinkedList dll = erl1.allKeys();
        System.out.println(dll.toString());

        System.out.println("\nThe final method is rangeKeys(). Select two keys from:\n" + erl1.toString());
        System.out.print("\nSelect key1: ");
        input = kb.nextInt();
        System.out.print("\nSelect key2: ");
        int key2 = kb.nextInt();
        System.out.println("Distance is: " + erl1.rangeKey(input, key2));

        
        kb.close();
    }
}
