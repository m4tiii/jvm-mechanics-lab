package pl.rokitowski.core.language.generics;

public class Result<T,E> {
    public final T data;
    public final E error;
    public final boolean isSuccess;

    private Result(T data, E error, boolean isSuccess) {
        this.data = data;
        this.error = error;
        this.isSuccess = isSuccess;
    }

    public static <T,E> Result<T,E> success(T data){
        return new Result<>(data, null, true);
    }

    public static <T,E> Result<T,E> failure(E error){
        return new Result<>(null, error, false);
    }

    public T getData(){
        if(!isSuccess){
            throw new IllegalStateException("Nie można pobrać danych, bo opercja zakończyła się niepowodzeniem");
        }
        return data;
    }

    public E getError() {
        if(isSuccess){
            throw new IllegalStateException("Nie można pobrać błędu, bo operacja zakończyła się powodzeniem");
        }
        return error;
    }

    public T orElse(T defaultValue){
        if (isSuccess){
            return data;
        }
        return defaultValue;
    }
}
