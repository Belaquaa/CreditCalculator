package CreditCalculator;

public class CreditCalculator {
    public static double calculateTotalPayment(double loanAmount, double monthlyPayment,
                                               double interestRate, String clientType) {
        double totalPayment = 0;
        double remainingAmount = loanAmount;
        int months = 0;

        while (remainingAmount > 0) {
            switch (clientType.toLowerCase()) {
                case "human":
                    if (months == 0) {
                        remainingAmount += remainingAmount * (interestRate / 100);
                    }
                    break;
                case "business":
                    if (months % 12 == 0 && months != 0) {
                        remainingAmount += remainingAmount * (interestRate / 100);
                    }
                    break;
                case "vladmarmelad": // нам льготный кредит
                    if (months % 36 == 0 && months != 0) {
                        remainingAmount += remainingAmount * (interestRate / 1000);
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Неизвестный тип клиента!");
            }
            remainingAmount -= monthlyPayment;
            totalPayment += monthlyPayment;
            months++;

            if (months > 1200) throw new IllegalArgumentException("Кредит не может быть выплачен в этой жизни :( ");
        }
        return totalPayment + remainingAmount; // если переплатили, то возвращаем свои кровные
    }
}


