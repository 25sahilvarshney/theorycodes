import java.util.*;
public class GROCERY_STORE_INVENTORY {
    private List<String> items;

    public GROCERY_STORE_INVENTORY() {
        items = new ArrayList<>();
    }

    public void addItem(String item) {
        items.add(item);
    }

    public void removeItem(String item) {
        items.remove(item);
    }

    public String getItem(int index) {
        return items.get(index);
    }

    public void updateItem(int index, String newItem) {
        items.set(index, newItem);
    }

    public void displayInventory() {
        for (String item : items) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        GROCERY_STORE_INVENTORY inventory = new GROCERY_STORE_INVENTORY();
        inventory.addItem("Item A");
        inventory.addItem("Item B");
        inventory.addItem("Item C");
        System.out.println("Item at index 1: " + inventory.getItem(1));
        inventory.updateItem(1, "Updated Item B");
        inventory.removeItem("Item C");
        inventory.displayInventory();
    }
}
