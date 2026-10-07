package pl.rokitowski.core.language.generics;

public final class ArrayUtils {

    private ArrayUtils(){}

    public static <T> void swap(T[] array, int i, int j){
        if(array == null){
            throw new IllegalArgumentException("Obiekt array jest null");
        }
        if (i < 0 || j < 0 || i >= array.length || j >= array.length) {
            throw new IndexOutOfBoundsException("Indeks poza zakresem tablicy");
        }

        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static <T extends Comparable<T>> T findMax(T[] array){
        if(array == null || array.length == 0){
            throw new IllegalArgumentException("Tablica nie może być pusta lub null");
        }

        T max = array[0];

        for (int i = 1; i < array.length; i++) {
            if(array[i].compareTo(max) > 0){
                max = array[i];
            }
        }
        return max;
    }

    public static <T extends Comparable<T>> int countGreaterThan(T[] array, T elem){
        if (array == null || elem == null) {
                throw new IllegalArgumentException("Argumenty nie mogą być null");
            }


        int count = 0;

        for (int i = 0; i < array.length; i++) {
            if(array[i] != null && array[i].compareTo(elem) > 0){
                count++;
            }
        }

        return count;
    }
}
