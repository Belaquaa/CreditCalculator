package CreditCalculator;

import java.util.Locale;

public class App {

    public static void main(String[] args) {
        double totalPayment = CreditCalculator.calculateTotalPayment(
                Scanner.getLoanAmount(),
                Scanner.getMonthlyPayment(),
                Scanner.getInterestRate(),
                Scanner.getClientType());

        double overpay = totalPayment - Scanner.getLoanAmount();
        System.out.println(STR."Сумма платежа: \{overpay}");
        System.out.println(STR."Это \{
                String.format(Locale.ENGLISH, "%.2f", overpay * 100 / (totalPayment - overpay))
                }% переплаты от суммы кредита");
    }
}
