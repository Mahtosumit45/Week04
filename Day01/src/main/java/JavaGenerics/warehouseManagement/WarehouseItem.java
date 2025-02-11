package JavaGenerics.warehouseManagement;

abstract class WarehouseItem {
    private String itemName;

    public WarehouseItem(String itemName) {
        this.itemName = itemName;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()+" - "+ itemName;
    }
}
class Electronics extends WarehouseItem {
    public Electronics(String itemName) {
        super(itemName);
    }
}
class Furniture extends WarehouseItem {
    public Furniture(String itemName) {
        super(itemName);
    }
}
class Groceries extends WarehouseItem {
    public Groceries(String itemName) {
        super(itemName);
    }
}
