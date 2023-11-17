import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Totsales {

    public static void main(String[] args) {
        // Creating a sample list of Sale objects
        List<Sale> sales = new ArrayList<>();
        sales.add(new Sale("ProductA", 100.0, LocalDate.of(2022, 1, 2)));
        sales.add(new Sale("ProductB", 150.0, LocalDate.of(2022, 12, 15)));
        sales.add(new Sale("ProductA", 50.0, LocalDate.of(2022, 2, 1)));
        sales.add(new Sale("ProductB", 200.0, LocalDate.of(2022, 1, 5)));
        sales.add(new Sale("ProductC", 120.0, LocalDate.of(2022, 1, 3)));

        // Specify the cutoff date
        LocalDate cutoffDate = LocalDate.of(2023, 1, 1);

        // Java stream pipeline
        Map<String, Double> result = sales.stream()
                .filter(sale -> sale.getDate().isBefore(cutoffDate))
                .collect(Collectors.groupingBy(Sale::getProduct,
                        Collectors.summingDouble(Sale::getAmount)))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .limit(3)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        // Display the result
        result.forEach((product, totalSales) -> System.out.println(product + ": " + totalSales));
    }

    // Define your Sale class
    static class Sale {
        private String product;
        private double amount;
        private LocalDate date;

        // Constructor
        public Sale(String product, double amount, LocalDate date) {
            this.product = product;
            this.amount = amount;
            this.date = date;
        }

        // Getters
        public String getProduct() {
            return product;
        }

        public double getAmount() {
            return amount;
        }

        public LocalDate getDate() {
            return date;
        }
    }
}
