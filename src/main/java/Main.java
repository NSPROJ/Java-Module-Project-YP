import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BillSplitter billSplitter = new BillSplitter();
        billSplitter.splitBill();
        billSplitter.printBill();
    }
}

class BillSplitter {
    private List<String> items;
    private double totalAmount;
    private int numberOfPeople;

    public BillSplitter() {
        items = new ArrayList<>();
        totalAmount = 0.0;
        numberOfPeople = 0;
    }

    public void splitBill() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество персон для разделения счета: ");
        numberOfPeople = scanner.nextInt();

        while (true) {
            System.out.print("Введите название товара или 'Завершить' для итога: ");
            String itemName = scanner.next();

            if (itemName.equalsIgnoreCase("завершить")) {
                break;
            }

            System.out.print("Введите количество товара: ");
            int quantity = scanner.nextInt();

            System.out.print("Введите цену товара: ");
            double price = scanner.nextDouble();

            double itemTotal = quantity * price;
            totalAmount += itemTotal;

            items.add(itemName + " - " + String.format("%.2f", itemTotal) + " " + Rubles.getSingularOrPlural(itemTotal));
        }
    }

    public void printBill() {
        double amountPerPerson = totalAmount / numberOfPeople;

        System.out.println("\nСчет:");
        for (String item : items) {
            System.out.println(item);
        }

        System.out.println("\nОбщая сумма: " + String.format("%.2f", totalAmount) + " " + Rubles.getSingularOrPlural(totalAmount));
        System.out.println("Сумма на каждого: " + String.format("%.2f", amountPerPerson) + " " + Rubles.getSingularOrPlural(amountPerPerson) + " на человека");
    }
}

class Rubles {
    public static String getSingularOrPlural(double amount) {
        int rubles = (int) amount;
        int lastDigit = rubles % 10;
        int lastTwoDigits = rubles % 100;

        if (lastTwoDigits >= 11 && lastTwoDigits <= 19) {
            return "рублей";
        } else if (lastDigit == 1) {
            return "рубль";
        } else if (lastDigit >= 2 && lastDigit <= 4) {
            return "рубля";
        } else {
            return "рублей";
        }
    }
}