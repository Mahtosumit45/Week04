package JavaGenerics.warehouseManagement;

import java.util.List;

public class WildCard {
    public static void wildCard(List<? extends WarehouseItem> items){
        for(Object item : items){
            System.out.println(item);
        }
    }
}
