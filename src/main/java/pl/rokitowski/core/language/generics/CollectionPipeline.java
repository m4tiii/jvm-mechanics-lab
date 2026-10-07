package pl.rokitowski.core.language.generics;

import java.util.List;
import java.util.function.Predicate;

public final class CollectionPipeline {
    private CollectionPipeline(){}

    public static <T> void copyAll(List<? extends T> src, List<? super T> dest){
        if(src == null){
            throw new IllegalArgumentException("List nie mogą być null");
        }
        if(dest == null){
            throw new IllegalArgumentException("List nie mogą być null");
        }
        dest.addAll(src);
    }

    public static <T> void filterAndTransfer(
            List<? extends T> src,
            List<? super T> dest,
            Predicate<? super T> condition
    ){
        if(src == null){
            throw new IllegalArgumentException("Parametry nie mogą być null");
        }
        if(dest == null){
            throw new IllegalArgumentException("Parametry nie mogą być null");
        }
        if(condition == null){
            throw new IllegalArgumentException("Parametry nie mogą być null");
        }
        for (T el : src){
            if (condition.test(el)){
                dest.add(el);
            }
        }
    }
}
