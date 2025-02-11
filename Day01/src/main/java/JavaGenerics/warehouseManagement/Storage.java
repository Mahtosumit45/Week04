package JavaGenerics.warehouseManagement;

import java.util.*;

public class Storage <T extends WarehouseItem>{
    List<T> list = new ArrayList<>();
    public void add(T item){
        list.add(item);
    }
    public T get(int index){
        if(index >=0 && index < list.size()){
            return list.get(index);
        }
        return null;
    }
    public List<T> getList(){
        return list;
    }
}

