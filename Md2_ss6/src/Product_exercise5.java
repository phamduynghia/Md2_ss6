import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Product_exercise5 {
    private String productid;
    private String productName;
    private float price;
    private String description;
    private Date created;
    private String catalogName;
    private int productStatus;

    public Product_exercise5() {
    }

    public Product_exercise5(String productid, String productName, float price, String description, Date created, String catalogName, int productStatus) {
        this.productid = productid;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.created = created;
        this.catalogName = catalogName;
        this.productStatus = productStatus;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public int getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(int productStatus) {
        this.productStatus = productStatus;
    }

    public void inputData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter product ID (C/S/A followed by 3 characters): ");
        this.productid = scanner.nextLine();

        System.out.print("Enter product name (10-50 characters): ");
        this.productName = scanner.nextLine();

        System.out.print("Enter price (greater than 0): ");
        this.price = scanner.nextFloat();
        scanner.nextLine(); // Clear the buffer

        System.out.print("Enter description: ");
        this.description = scanner.nextLine();

        System.out.print("Enter created date (dd/mm/yyyy): ");
        String dateStr = scanner.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.created = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.print("Enter catalog name: ");
        this.catalogName = scanner.nextLine();

        System.out.print("Enter product status (0: Available, 1: Out of Stock, 2: Not Selling): ");
        this.productStatus = scanner.nextInt();
    }

    public void displayData() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Product ID: " + this.productid);
        System.out.println("Product Name: " + this.productName);
        System.out.println("Price: " + this.price);
        System.out.println("Description: " + this.description);
        System.out.println("Created Date: " + sdf.format(this.created));
        System.out.println("Catalog Name: " + this.catalogName);
        System.out.println("Product Status: " + this.productStatus);
    }
}
