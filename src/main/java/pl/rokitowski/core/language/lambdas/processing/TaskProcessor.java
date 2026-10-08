package pl.rokitowski.core.language.lambdas.processing;

import pl.rokitowski.core.language.lambdas.model.Task;

import java.util.function.Consumer;
import java.util.function.Function;

public class TaskProcessor {
    public static void processTask(Task task, Function<Task, Task> modifier, Consumer<Task> notifier){
        if(task == null || modifier == null || notifier == null){
            throw new IllegalArgumentException("Parametry nie mogą być null");
        }

        Task modifiedTask = modifier.apply(task);

        notifier.accept(modifiedTask);
    }
}
