import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BillSplitter {
    public List<String> items;
    public double totalAmount;
    public int numberOfPeople;

    public BillSplitter() {
        items = new ArrayList<>();
        totalAmount = 0.0;
    }

    public void splitBill() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество персон для разделения счета: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Ошибка. Введите корректное количество персон: ");
            scanner.next();
        }
        numberOfPeople = scanner.nextInt();

        if (numberOfPeople <= 0) {
            System.out.println("Ошибка. Количество персон должно быть больше нуля.");
            return;
        }

        while (true) {
            System.out.print("Введите название товара или 'Завершить' для итога: ");
            String itemName = scanner.next();

            if (itemName.equalsIgnoreCase("завершить")) {
                break;
            }

            System.out.print("Введите количество товара: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Ошибка. Введите корректное количество товара: ");
                scanner.next();
            }
            int quantity = scanner.nextInt();

            if (quantity <= 0) {
                System.out.println("Ошибка. Количество товара должно быть больше нуля.");
                return;
            }

            System.out.print("Введите цену товара: ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Ошибка. Введите корректную цену товара: ");
                scanner.next();
            }
            double price = scanner.nextDouble();

            if (price < 0) {
                System.out.println("Ошибка. Цена товара не может быть отрицательной.");
                return;
            }

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
