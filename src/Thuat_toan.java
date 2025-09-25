import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Thuat_toan {
    public static void writeFile() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        try (FileWriter writer = new FileWriter("text.txt")) {
            for (int i = 0; i < n; i++){
                System.out.print("Enter element " + (i + 1) + ": ");
                float element = sc.nextFloat();

                writer.write(writer + "");
            }

        } catch (IOException e){
            System.out.println("Error");
            e.printStackTrace();
        }
        sc.close(); //đóng objecj sc


    }
}
