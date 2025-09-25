import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int choice ;
        do {
            System.out.println("\n=== MENU ===");
            System.out.println("\n1.Input");
            System.out.println("\n2.Output");
            System.out.println("\n3.Bubble sort");
            System.out.println("\n4.Selection sort");
            System.out.println("\n5.Insertion sort");
            System.out.println("\n6.Search > value");
            System.out.println("\n7.Search = value");
            System.out.println("\n0.Exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    Thuat_toan.writeFile();
                    break;
                case 0:
                    System.out.println("Thanks!!!");
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }


        }while (choice != 0);

    }
}