import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Thuat_toan {
    public static float[] a;
    public static float[] b;

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
            a = new float[list.size()];
            for (int i = 0; i < list.size(); i++) {
                a[i] = list.get(i);
            }

            // In ra để kiểm tra
            System.out.println("Read from file:");
            System.out.print("Array a: ");
            for (float num : a) {
                System.out.print(num + " ");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Cannot open file");
        }
    }
    public static void bubbleSort() {
        b = Arrays.copyOf(a, a.length); //copy dữ liệu từ mảng a
        int n = b.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (b[j] > b[j + 1]) {
                    float temp = b[j];
                    b[j] = b[j + 1];
                    b[j + 1] = temp;
                    swapped = true;
                }
                System.out.println(Arrays.toString(b));
            }

        }
        try {
            FileWriter writer = new FileWriter("OUTPUT1.txt");
            writer.write(Arrays.toString(b));
            writer.close();

        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        }


    }
    public  static void selectionSort() {
        b = Arrays.copyOf(a, a.length);
        int n = b.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (b[j] < b[minIndex]) {
                    minIndex = j;
                }

            }
            if (minIndex != i) {
                float temp = b[i];
                b[i] = b[minIndex];
                b[minIndex] = temp;
            }
            System.out.println(Arrays.toString(b));
        }
        try {
            FileWriter writer = new FileWriter("OUTPUT2.txt");
            writer.write(Arrays.toString(b));
            writer.close();

        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        }
    }
    public static void insertionSort() {
        b = Arrays.copyOf(a, a.length);

        for (int i = 1; i < b.length; i++){
            float key = b[i];
            int j = i - 1;

            while (j >= 0 && b[j] > key) {
                b[j + 1] = b[j];
                j--;
            }
            b[j + 1] = key;
            System.out.println(Arrays.toString(b));
        }
        //In ra file OUTPUT3.txt
        try {
            FileWriter writer = new FileWriter("OUTPUT3.txt");
            writer.write(Arrays.toString(b));
            writer.close();

        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        }

    }
    public static void search(){
        Scanner sc =  new Scanner(System.in);
        //nhap value
        System.out.print("Enter value: ");
        float value = sc.nextFloat();

        //tim gia tri lon hon value
        ArrayList<Integer> indices = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            if (a[i] > value) {
                indices.add(i);
            }
        }
        //in ra man hinh
        if (indices.isEmpty()) {
            System.out.println("No element in the array is greater than" + value);
        } else {
            System.out.println(indices);
        }
        //ghi ket qua ra file
        try {
            FileWriter writer = new FileWriter("OUTPUT4.txt");
            if (indices.isEmpty()) {
                writer.write("No element in the array is greater than" + value);
            } else {
                writer.write(String.valueOf(indices));
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    public static void searchBinary() {
        //nhap gia tri value
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value: ");
        float value = sc.nextFloat();

        //sap xep bang insertion sort
        b = Arrays.copyOf(a, a.length);

        for (int i = 1; i < b.length; i++) {
            float key = b[i];
            int j = i - 1;

            while (j >= 0 && b[j] > key) {
                b[j + 1] = b[j];
                j--;
            }
            b[j + 1] = key;

        }
        //tim kiem Binary search
        int left = 0;
        int right = b.length - 1;
        int result = -1;// chua tim thay/ khong tim thay

        while (left <= right) {
            int mid = (left + right) / 2;

            if (b[mid] == value) {
                result = mid; // tim thay
                break;
            } else if (b[mid] < value) {
                left = mid + 1; // tim ben phai
            } else {
                right = mid - 1; // tim ben trai
            }

        }
        if (result == -1) {
            System.out.println("Cannot find " + value + " in array.");
        } else {
            System.out.println(result);
        }


    }
}
