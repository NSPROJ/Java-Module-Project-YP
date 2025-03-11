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