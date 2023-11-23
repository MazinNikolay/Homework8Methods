import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int year = 2021;
        isLeapYear(year);
        int clientDeviceYear = 2021;
        int clientOs = 1;
        checkOsVersion(clientDeviceYear, clientOs);
        int deliveryDistance = 60;
        System.out.println();
        checkDeliveryDistance(deliveryDistance);
        System.out.println();
        int[] array = {3, 2, 1, 6, 5};
        reverseArray(array);
        System.out.println("Измененный массив: " + Arrays.toString(array));
        String line = "aabccddefgghiijjkk";
        cacheDouble(line);
        int arrayPaymentLength = 30;
        int[] arrayPayment = generateRandomArray(arrayPaymentLength);
        System.out.println(averagePayment(arrayPayment));
    }

    public static void isLeapYear(int year) {
        if ((year % 100 != 0 && year % 4 == 0) || (year % 400 == 0 && year % 4 == 0)) {
            System.out.println(year + " год — високосный год");
        } else System.out.println(year + " год — невисокосный год");
    }

    public static void checkOsVersion(int clientDeviceYear, int clientOs) {
        int currentYear = LocalDate.now().getYear();
        String os = (clientOs == 0) ? "iOS" : "Android";
        String version = (clientDeviceYear < currentYear) ? "облегченную" : "обычную";
        System.out.printf("Установите %s версию приложения для %s по ссылке", version, os);
    }

    public static void checkDeliveryDistance(int deliveryDistance) {
        String deliveryTime = "";
        if (deliveryDistance < 20) {
            deliveryTime = "1";
        } else if (deliveryDistance >= 20 && deliveryDistance < 60) {
            deliveryTime = "2";
        } else if (deliveryDistance >= 60 && deliveryDistance < 100) {
            deliveryTime = "3";
        } else deliveryTime = "доставки нет";
        System.out.printf("Потребуется дней: %s", deliveryTime);
    }

    public static void reverseArray(int[] array) {
        int tempVariable;
        int arrayEndElement = array.length - 1;
        System.out.println("Исходный массив: " + Arrays.toString(array));
        for (int i = 0; i < array.length / 2; i++) {
            tempVariable = array[i];
            array[i] = array[arrayEndElement - i];
            array[arrayEndElement - i] = tempVariable;
        }
    }

    public static void cacheDouble(String line) {
        System.out.println("Строка: " + line);
        int i = 0;
        boolean doubleFound = false;
        while (i < line.length() && (!doubleFound)) {
            i++;
            if (line.charAt(i) == line.charAt(i - 1)) {
                doubleFound = true;
            }
        }
        if (doubleFound) {
            System.out.println("Дубль найден. Дублирующийся символ - " + line.charAt(i));
            return;
        }
    }

    public static int[] generateRandomArray(int length) {
        Random rnd = new Random();
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(100_000, 200_000);
        }
        return arr;
    }

    public static int sumPayments(int[] array) {
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        return sum;
    }

    public static float averagePayment(int[] arrayPayment) {
        int monthCount = arrayPayment.length;
        int sum = sumPayments(arrayPayment);
        float average = (float) sum / monthCount;
        return average;
    }
}