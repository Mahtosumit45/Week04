package JavaGenerics.warehouseManagement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseItemTest {
    private Storage<Electronics> electronicsStorage;
    private Storage<Groceries> groceriesStorage;
    private Storage<Furniture> furnitureStorage;

    @BeforeEach
    void setUp() {
        electronicsStorage = new Storage<>();
        groceriesStorage = new Storage<>();
        furnitureStorage = new Storage<>();
    }

    @Test
    void testAddAndRetrieveElectronics() {
        Electronics laptop = new Electronics("Laptop");
        electronicsStorage.add(laptop);
        assertEquals("Electronics - Laptop", electronicsStorage.get(0).toString());
    }

    @Test
    void testAddAndRetrieveGroceries() {
        Groceries apple = new Groceries("Apple");
        groceriesStorage.add(apple);
        assertEquals("Groceries - Apple", groceriesStorage.get(0).toString());
    }

    @Test
    void testAddAndRetrieveFurniture() {
        Furniture chair = new Furniture("Chair");
        furnitureStorage.add(chair);
        assertEquals("Furniture - Chair", furnitureStorage.get(0).toString());
    }

    @Test
    void testDisplayItems() {
        electronicsStorage.add(new Electronics("TV"));
        groceriesStorage.add(new Groceries("Banana"));
        furnitureStorage.add(new Furniture("Table"));

        List<Electronics> electronicsList = electronicsStorage.getList();
        List<Groceries> groceriesList = groceriesStorage.getList();
        List<Furniture> furnitureList = furnitureStorage.getList();

        assertEquals("Electronics - TV", electronicsList.get(0).toString());
        assertEquals("Groceries - Banana", groceriesList.get(0).toString());
        assertEquals("Furniture - Table", furnitureList.get(0).toString());
    }

}