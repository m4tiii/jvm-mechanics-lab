package pl.rokitowski.core.language.generics;

import java.util.ArrayList;
import java.util.List;

public class Storage<T extends Number> {
    private final List<T> items = new ArrayList<>();

    public Storage(){}

    public void add(T item){
        if(item == null){
            throw new IllegalArgumentException("Element nie może być null");
        }
        items.add(item);
    }

    public double sum(){
        double sum = 0.0;
        for(T el:items){
            sum += el.doubleValue();
        }
        return sum;
    }

    public double average(){

        double sum = 0.0;
        for(T el:items){
            sum += el.doubleValue();
        }
        if(sum == 0.0){
            return 0.0;
        }
        return sum/items.size();
    }


    public boolean hasGreaterThanAverage(Storage<?> other){
        if(other == null){
            throw new IllegalArgumentException("Magazyn do porównania nie może być null");
        }

        return average() > other.average();
    }
}
