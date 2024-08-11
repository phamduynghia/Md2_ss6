import java.util.Scanner;

public class exercise6_ss6_Product {
    private String productid;
    private String productName;
    private float importPrice;
    private float exportPrice;
    private float profit;
    private int quantity;
    private String descriptions;
    private boolean status;

    public exercise6_ss6_Product() {
    }

    public exercise6_ss6_Product(String productid, String productName, float importPrice, float exportPrice, int quantity, String descriptions, boolean status) {
        this.productid = productid;
        this.productName = productName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.quantity = quantity;
        this.descriptions = descriptions;
        this.status = status;
        calProfit();
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
        calProfit();
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        if (exportPrice >= importPrice * 1.2) {
            this.exportPrice = exportPrice;
            calProfit();
        } else {
            System.out.println("Export price must be at least 20% more than import price.");
        }
    }

    public float getProfit() {
        return profit;
    }

    public void setProfit(float profit) {
        this.profit = profit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void inputData(Scanner scanner, exercise6_ss6_Product[] arrProduct) {
        System.out.print("Enter product ID (PXXXX): ");
        this.productid = scanner.nextLine();

        for (exercise6_ss6_Product p : arrProduct) {
            if (p != null && p.productid.equals(this.productid)) {
                System.out.println("Product ID already exists.");
                return;
            }
        }

        System.out.print("Enter product name (6-50 characters): ");
        this.productName = scanner.nextLine();

        for (exercise6_ss6_Product p : arrProduct) {
            if (p != null && p.productName.equals(this.productName)) {
                System.out.println("Product name already exists.");
                return;
            }
        }

        System.out.print("Enter import price (greater than 0): ");
        this.importPrice = scanner.nextFloat();
        while (this.importPrice <= 0) {
            System.out.print("Invalid price. Enter again: ");
            this.importPrice = scanner.nextFloat();
        }

        System.out.print("Enter export price (at least 20% more than import price): ");
        this.exportPrice = scanner.nextFloat();
        while (this.exportPrice < this.importPrice * 1.2) {
            System.out.print("Invalid export price. Enter again: ");
            this.exportPrice = scanner.nextFloat();
        }
        calProfit();
        scanner.nextLine();

        System.out.print("Enter quantity (greater than 0): ");
        this.quantity = scanner.nextInt();
        while (this.quantity <= 0) {
            System.out.print("Invalid quantity. Enter again: ");
            this.quantity = scanner.nextInt();
        }
        scanner.nextLine();

        System.out.print("Enter descriptions: ");
        this.descriptions = scanner.nextLine();

        System.out.print("Enter status (true for available, false for not available): ");
        this.status = scanner.nextBoolean();
    }

    public void displayData() {
        System.out.printf("Product ID: %s\n", this.productid);
        System.out.printf("Product Name: %s\n", this.productName);
        System.out.printf("Import Price: %.2f\n", this.importPrice);
        System.out.printf("Export Price: %.2f\n", this.exportPrice);
        System.out.printf("Profit: %.2f\n", this.profit);
        System.out.printf("Quantity: %d\n", this.quantity);
        System.out.printf("Descriptions: %s\n", this.descriptions);
        System.out.printf("Status: %s\n", this.status ? "Available" : "Not Available");
    }

    public void calProfit() {
        this.profit = this.exportPrice - this.importPrice;
    }
}


