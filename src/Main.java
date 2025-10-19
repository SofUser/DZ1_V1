import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int size = getArraySize(scanner);
            int min = getBound(scanner, "мин");
            int max = getBound(scanner, "макс", min);

            int[] intArray = new int[size];
            fillArray(intArray, min, max);
            processArray("целых чисел", intArray);

            double[] doubleArray = new double[size];
            fillArray(doubleArray, min, max);
            processArray("дробных чисел", doubleArray);
        } catch (Exception e) {
            System.out.println("Произошла непредвиденная ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static int getArraySize(Scanner scanner) {
        int size = 0;
        while (size <= 0) {
            System.out.print("Введите размер массива (>0): ");
            try {
                if (scanner.hasNextInt()) {
                    size = scanner.nextInt();
                } else {
                    System.out.println("Ошибка! Введите целое число");
                    scanner.nextLine();
                    continue;
                }

                if (size <= 0) {
                    System.out.println("Ошибка! Размер должен быть >0");
                }
            } catch (Exception e) {
                System.out.println("Ошибка ввода: " + e.getMessage());
            }
        }
        return size;
    }

    private static int getBound(Scanner scanner, String boundName) {
        System.out.print("Введите " + boundName + " границу: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Ошибка! Введите целое число");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static int getBound(Scanner scanner, String boundName, int min) {
        int bound;
        do {
            System.out.print("Введите " + boundName + " границу (>= " + min + "): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Ошибка! Введите целое число");
                scanner.next();
            }
            bound = scanner.nextInt();
            if (bound < min) {
                System.out.println("Ошибка! Максимальная граница должна быть >= минимальной (" + min + ")");
            }
        } while (bound < min);
        return bound;
    }

    public static void fillArray(int[] arr, int min, int max) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * (max - min + 1)) + min;
        }
    }

    public static void fillArray(double[] arr, int min, int max) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.random() * (max - min) + min;
        }
    }

    public static void processArray(String type, int[] arr) {
        System.out.println("\nМассив " + type + ":");
        printArray(arr);

        System.out.println("Макс: " + findMax(arr));
        System.out.println("Мин: " + findMin(arr));
        System.out.printf("Среднее: %.2f\n", findAverage(arr));

        sortAscending(arr);
        System.out.println("По возрастанию:");
        printArray(arr);

        sortDescending(arr);
        System.out.println("По убыванию:");
        printArray(arr);
    }

    public static void processArray(String type, double[] arr) {
        System.out.println("\nМассив " + type + ":");
        printArray(arr);

        System.out.println("Макс: " + findMax(arr));
        System.out.println("Мин: " + findMin(arr));
        System.out.printf("Среднее: %.2f\n", findAverage(arr));

        sortAscending(arr);
        System.out.println("По возрастанию:");
        printArray(arr);

        sortDescending(arr);
        System.out.println("По убыванию:");
        printArray(arr);
    }

    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) if (num > max) max = num;
        return max;
    }

    public static double findMax(double[] arr) {
        double max = arr[0];
        for (double num : arr) if (num > max) max = num;
        return max;
    }

    public static int findMin(int[] arr) {
        int min = arr[0];
        for (int num : arr) if (num < min) min = num;
        return min;
    }

    public static double findMin(double[] arr) {
        double min = arr[0];
        for (double num : arr) if (num < min) min = num;
        return min;
    }

    public static double findAverage(int[] arr) {
        int sum = 0;
        for (int num : arr) sum += num;
        return (double) sum / arr.length;
    }

    public static double findAverage(double[] arr) {
        double sum = 0;
        for (double num : arr) sum += num;
        return sum / arr.length;
    }

    public static void sortAscending(int[] arr) {
        for (int i = 0; i < arr.length-1; i++)
            for (int j = 0; j < arr.length-i-1; j++)
                if (arr[j] > arr[j+1]) swap(arr, j, j+1);
    }

    public static void sortAscending(double[] arr) {
        for (int i = 0; i < arr.length-1; i++)
            for (int j = 0; j < arr.length-i-1; j++)
                if (arr[j] > arr[j+1]) swap(arr, j, j+1);
    }

    public static void sortDescending(int[] arr) {
        for (int i = 0; i < arr.length-1; i++)
            for (int j = 0; j < arr.length-i-1; j++)
                if (arr[j] < arr[j+1]) swap(arr, j, j+1);
    }

    public static void sortDescending(double[] arr) {
        for (int i = 0; i < arr.length-1; i++)
            for (int j = 0; j < arr.length-i-1; j++)
                if (arr[j] < arr[j+1]) swap(arr, j, j+1);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void swap(double[] arr, int i, int j) {
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int[] arr) {
        for (int num : arr) System.out.print(num + " ");
        System.out.println();
    }

    public static void printArray(double[] arr) {
        for (double num : arr) System.out.printf("%.2f ", num);
        System.out.println();
    }
}