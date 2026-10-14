package pl.rokitowski.core.language.events;

import pl.rokitowski.core.language.generics.CollectionPipeline;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class EventBus {

    private final Map<Class<? extends Event>, List<Consumer<? extends Event>>> listeners = new HashMap<>();


    public <E extends Event> void subscribe(Class<E> eventType, Consumer<E> listener){
        listeners.computeIfAbsent(eventType, key -> new ArrayList<>())
                .add(listener);
    }

//    @SuppressWarnings("unchecked")
//    public <E extends Event> void publish(E event){
//        List<Consumer<? extends Event>> eventListeners = listeners.getOrDefault(event.getClass(), Collections.emptyList());
//        for (Consumer<? extends Event> rawListener : eventListeners){
//            Consumer<E> typedListener = (Consumer<E>) rawListener;
//            typedListener.accept(event);
//        }
//    }

    @SuppressWarnings("unchecked")
    public <E extends  Event> void publish(E event){
        for(Class<? extends Event> registredType : listeners.keySet()){
            if(registredType.isAssignableFrom(event.getClass())){
                List<Consumer<? extends Event>> eventListener = listeners.get(registredType);
                for (Consumer<? extends Event> rawListener : eventListener){
                    Consumer<E> typedListener = (Consumer<E>)rawListener;
                    typedListener.accept(event);
                }
            }
        }
    }

    public <E extends Event> void subscribe(
            Class<E> eventType,
            Predicate<E> filter,
            Consumer<E> listener){

        Consumer<E> filteredListener = event -> {
            if(filter.test(event)){
                listener.accept(event);
            }
        };

        subscribe(eventType, filteredListener);
    }
}
