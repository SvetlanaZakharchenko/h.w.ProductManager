package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    Product first = new Book(1, "Жизнь Взаймы", 500, "Ремарк");
    Product second = new Book(2, "Три товарища", 600, "Ремарк");
    Product third = new Book(3, "Джейн Эйр", 1000, "Шарлотта Бронте");
    Product fourth = new Smartphone(4, "Iphone", 100_000, "Apple");
    Product fifth = new Smartphone(5, "Galaxy", 80_000, "Samsung");

    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
    }

    @Test
    public void addProduct() {
        manager.add(first);
        assertArrayEquals(new Product[]{first}, repository.findAll());
    }

    @Test
    public void searchByName() {
        setUp();

        Product[] expected = new Product[]{second};
        Product[] actual = manager.searchBy("Три товарища");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchMatchesNameBook() {
        setUp();

        Product[] expected = new Product[]{third};
        Product[] actual = manager.searchBy("Джейн Эйр");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchMatchesAuthor() {
        setUp();

        Product[] expected = new Product[]{third};
        Product[] actual = manager.searchBy("Шарлотта Бронте");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchMatchesManufacture() {
        setUp();

        Product[] expected = new Product[]{fourth};
        Product[] actual = manager.searchBy("Apple");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchMatchesNameSmartphone() {
        setUp();

        Product[] expected = new Product[]{fifth};
        Product[] actual = manager.searchBy("Galaxy");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchAllBooksByAuthor() {
        setUp();

        Product[] expected = new Product[]{first,second};
        Product[] actual = manager.searchBy("Ремарк");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchAll() {
        setUp();

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(null);
        assertArrayEquals(expected, actual);
    }
}