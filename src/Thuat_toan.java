import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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

                writer.write(element + " ");
            }

        } catch (IOException e){
            System.out.println("Error");
            e.printStackTrace();
        }



    }
    public static void readFile(){
        try{
            File file = new File("text.txt");
            Scanner scanner = new Scanner(file);

            ArrayList<Float> list = new ArrayList<>();

            while (scanner.hasNextFloat()) {
                list.add(scanner.nextFloat());
            }
            scanner.close();

            // Chuyển ArrayList -> mảng float[]
            float[] numbers = new float[list.size()];
            for (int i = 0; i < list.size(); i++) {
                numbers[i] = list.get(i);
            }

            // In ra để kiểm tra
            System.out.println("Dữ liệu trong mảng float:");
            for (float num : numbers) {
                System.out.print(num + " ");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file!");
        }
    }
}
