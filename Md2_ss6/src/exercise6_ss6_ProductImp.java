import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class exercise6_ss6_ProductImp {
    private static final int MAX_PRODUCTS = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        exercise6_ss6_Product[] products = new exercise6_ss6_Product[MAX_PRODUCTS];
        int count = 0;

        while (true) {
            System.out.println("\n------------------------------MENU---------------------------------");
            System.out.println("1. Nhập thông tin n sản phẩm");
            System.out.println("2. Hiển thị thông tin các sản phẩm");
            System.out.println("3. Tính lợi nhuận các sản phẩm");
            System.out.println("4. Sắp xếp các sản phẩm theo lợi nhuận giảm dần");
            System.out.println("5. Thống kê các sản phẩm theo giá");
            System.out.println("6. Tìm các sản phẩm theo tên sản phẩm");
            System.out.println("7. Nhập sản phẩm");
            System.out.println("8. Bán sản phẩm");
            System.out.println("9. Cập nhật trạng thái sản phẩm");
            System.out.println("10. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer

            switch (choice) {
                case 1:
                    System.out.print("Nhập số lượng sản phẩm cần thêm: ");
                    int n = scanner.nextInt();
                    scanner.nextLine(); // Clear the buffer
                    for (int i = 0; i < n && count < MAX_PRODUCTS; i++) {
                        System.out.println("Nhập thông tin sản phẩm thứ " + (count + 1) + ":");
                        exercise6_ss6_Product product = new exercise6_ss6_Product();
                        product.inputData(scanner, products);
                        products[count++] = product;
                    }
                    break;

                case 2:
                    for (int i = 0; i < count; i++) {
                        products[i].displayData();
                        System.out.println();
                    }
                    break;

                case 3:
                    for (int i = 0; i < count; i++) {
                        products[i].calProfit();
                    }
                    System.out.println("Lợi nhuận đã được tính lại cho tất cả sản phẩm.");
                    break;

                case 4:
                    Arrays.sort(products, 0, count, Comparator.comparingDouble(exercise6_ss6_Product::getProfit).reversed());
                    System.out.println("Sản phẩm đã được sắp xếp theo lợi nhuận giảm dần.");
                    break;

                case 5:
                    System.out.print("Nhập khoảng giá (fromPrice toPrice): ");
                    float fromPrice = scanner.nextFloat();
                    float toPrice = scanner.nextFloat();
                    scanner.nextLine(); // Clear the buffer
                    int countInRange = 0;
                    for (int i = 0; i < count; i++) {
                        if (products[i].getExportPrice() >= fromPrice && products[i].getExportPrice() <= toPrice) {
                            countInRange++;
                        }
                    }
                    System.out.println("Số lượng sản phẩm trong khoảng giá: " + countInRange);
                    break;

                case 6:
                    System.out.print("Nhập tên sản phẩm để tìm: ");
                    String searchName = scanner.nextLine();
                    boolean found = false;
                    for (int i = 0; i < count; i++) {
                        if (products[i].getProductName().contains(searchName)) {
                            products[i].displayData();
                            System.out.println();
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Không tìm thấy sản phẩm.");
                    }
                    break;

                case 7:
                    System.out.print("Nhập mã sản phẩm cần nhập: ");
                    String productIdToAdd = scanner.nextLine();
                    System.out.print("Nhập số lượng cần nhập: ");
                    int quantityToAdd = scanner.nextInt();
                    scanner.nextLine(); // Clear the buffer
                    boolean productFound = false;
                    for (int i = 0; i < count; i++) {
                        if (products[i].getProductid().equals(productIdToAdd)) {
                            products[i].setQuantity(products[i].getQuantity() + quantityToAdd);
                            System.out.println("Số lượng sản phẩm đã được cập nhật.");
                            productFound = true;
                            break;
                        }
                    }
                    if (!productFound) {
                        System.out.println("Sản phẩm không tìm thấy.");
                    }
                    break;

                case 8:
                    System.out.print("Nhập tên sản phẩm cần bán: ");
                    String productNameToSell = scanner.nextLine();
                    System.out.print("Nhập số lượng cần bán: ");
                    int quantityToSell = scanner.nextInt();
                    scanner.nextLine(); // Clear the buffer
                    boolean productSold = false;
                    for (int i = 0; i < count; i++) {
                        if (products[i].getProductName().equalsIgnoreCase(productNameToSell)) {
                            if (products[i].getQuantity() >= quantityToSell) {
                                products[i].setQuantity(products[i].getQuantity() - quantityToSell);
                                System.out.println("Số lượng sản phẩm đã được cập nhật.");
                            } else {
                                System.out.println("Số lượng không đủ để bán.");
                            }
                            productSold = true;
                            break;
                        }
                    }
                    if (!productSold) {
                        System.out.println("Sản phẩm không tìm thấy.");
                    }
                    break;

                case 9:
                    System.out.print("Nhập mã sản phẩm cần cập nhật trạng thái: ");
                    String productIdToUpdate = scanner.nextLine();
                    boolean productUpdated = false;
                    for (int i = 0; i < count; i++) {
                        if (products[i].getProductid().equals(productIdToUpdate)) {
                            products[i].setStatus(!products[i].isStatus());
                            System.out.println("Trạng thái sản phẩm đã được cập nhật.");
                            productUpdated = true;
                            break;
                        }
                    }
                    if (!productUpdated) {
                        System.out.println("Sản phẩm không tìm thấy.");
                    }
                    break;

                case 10:
                    System.out.println("Thoát khỏi chương trình.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }
}
