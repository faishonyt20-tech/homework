class Author {
    private String firstName;
    private String lastName;

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}

class Book {
    private String title;
    private Author author;
    private int publicationYear;

    public Book(String title, Author author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    @Override
    public String toString() {
        return title + " (" + publicationYear + ")";
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Библиотечный справочник ===\n");

        // Создаем авторов
        Author author1 = new Author("Лев", "Толстой");
        Author author2 = new Author("Фёдор", "Достоевский");
        Author author3 = new Author("Антон", "Чехов");

        System.out.println("Созданные авторы:");
        System.out.println("1. " + author1.getFullName());
        System.out.println("2. " + author2.getFullName());
        System.out.println("3. " + author3.getFullName());
        System.out.println();

        // Создаем книги
        Book book1 = new Book("Война и мир", author1, 1869);
        Book book2 = new Book("Анна Каренина", author1, 1877);
        Book book3 = new Book("Преступление и наказание", author2, 1866);
        Book book4 = new Book("Вишневый сад", author3, 1904);

        System.out.println("Созданные книги:");
        System.out.println("1. " + book1);
        System.out.println("2. " + book2);
        System.out.println("3. " + book3);
        System.out.println("4. " + book4);
    }
}