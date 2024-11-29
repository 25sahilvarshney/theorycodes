import java.util.ArrayList;
import java.util.List;
public class Managing_a_Library {
private List<String> books;

        public Managing_a_Library() {
            books = new ArrayList<>();
        }

        public void addBook(String title) {
            books.add(title);
        }

        public void removeBook(String title) {
            books.remove(title);
        }

        public boolean isBookInCollection(String title) {
            return books.contains(title);
        }

        public static void main(String[] args) {
            Managing_a_Library library = new Managing_a_Library();
            library.addBook("The Great Gatsby");
            library.addBook("1984");
            System.out.println(library.isBookInCollection("1984")); // true
            library.removeBook("1984");
            System.out.println(library.isBookInCollection("1984")); // false
        }
    }




