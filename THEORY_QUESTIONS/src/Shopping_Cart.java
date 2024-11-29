import java.util.*;

public class Shopping_Cart {
    private List<String> cart;

    public Shopping_Cart() {
        cart = new ArrayList<>();
    }

    public void addItem(String item) {
        cart.add(item);
    }

    public void removeItem(int index) {
        cart.remove(index);
    }

    public String getItem(int index) {
        return cart.get(index);
    }

    public int getTotalItems() {
        return cart.size();
    }

    public void displayCart() {
        for (String item : cart) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        Shopping_Cart cart = new Shopping_Cart();
        cart.addItem("Item A");
        cart.addItem("Item B");
        cart.addItem("Item C");
        System.out.println("Total items: " + cart.getTotalItems());
        System.out.println("Item at index 1: " + cart.getItem(1));
        cart.removeItem(1);
        cart.displayCart();
    }
}

