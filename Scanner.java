package CreditCalculator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Scanner {

    static {
        getCreditInfo();
    }

    static private String[] creditInfo;

    public static double getLoanAmount() {
        return parseToDouble(creditInfo[0]);
    }

    public static double getMonthlyPayment() {
        return parseToDouble(creditInfo[1]);
    }

    public static double getInterestRate() {
        return parseToDouble(creditInfo[2]);
    }

    public static String getClientType() {
        return creditInfo[3];
    }

    private static void getCreditInfo() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите параметры кредита (сумма, ежемесячный платеж, процент, тип клиента):");
            creditInfo = reader.readLine().trim().split(" ");
            if (creditInfo.length != 4) throw new IOException();
        } catch (IOException e) {
            System.err.println(STR."Ошибка в вводе данных: \{e}");
        }
    }

    private static double parseToDouble(String input) {
        try {
            double value = Double.parseDouble(input);
            if (value < 0) throw new NumberFormatException();
            return value;
        } catch (NumberFormatException e) {
            throw new NumberFormatException(STR."Ошибка в преобразовании данных: \{input}");
        }
    }
}