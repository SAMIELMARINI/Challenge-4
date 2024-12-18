import java.util.*;

class Product {
    int id;
    String name;
    int quantity;

    public Product(int id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product ID: " + id + ", Name: " + name + ", Quantity: " + quantity;
    }
}

class Warehouse {
    private HashMap<Integer, Product> products;
    private List<Integer> dailyShipments;

    public Warehouse() {
        this.products = new HashMap<>();
        this.dailyShipments = new ArrayList<>();
    }

    public void addProduct(int id, String name, int quantity) {
        if (!products.containsKey(id)) {
            products.put(id, new Product(id, name, quantity));
            System.out.println("Product added successfully.");
        } else {
            System.out.println("Product with ID " + id + " already exists.");
        }
    }

    public void lookupProductById(int id) {
        Product product = products.get(id);
        if (product != null) {
            System.out.println(product);
        } else {
            System.out.println("Product with ID " + id + " not found.");
        }
    }

    public void printSortedProducts() {
        List<Product> productList = new ArrayList<>(products.values());
        productList.sort(Comparator.comparing(p -> p.name));
        System.out.println("Products sorted by name:");
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    public void recordShipment(int... productIds) {
        for (int id : productIds) {
            if (products.containsKey(id)) {
                dailyShipments.add(id);
            } else {
                System.out.println("Product with ID " + id + " not found in inventory.");
            }
        }
        System.out.println("Shipment recorded.");
    }

    public void printDailyShipments() {
        System.out.println("Daily shipment product IDs:");
        for (int id : dailyShipments) {
            System.out.println(id);
        }
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
  
        warehouse.addProduct(1, "Laptop", 10);
        warehouse.addProduct(2, "Monitor", 5);
        warehouse.addProduct(3, "Keyboard", 20);

        warehouse.lookupProductById(1);

        warehouse.printSortedProducts();

        warehouse.recordShipment(1, 2, 3);

        warehouse.printDailyShipments();
    }
}
