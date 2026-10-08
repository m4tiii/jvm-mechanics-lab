package pl.rokitowski.core.language.lambdas.validation;

import pl.rokitowski.core.language.lambdas.model.Task;

import java.util.Objects;
import java.util.function.Predicate;

public class TaskValidator {

    private TaskValidator(){}

    public static final Predicate<Task> hasTitle = task -> task.getTitle() != null && task.getPriority() <= 5;

    public static final Predicate<Task> hasValidPriority = task -> task.getPriority() > 0 && task.getPriority() < 6;

    public static final Predicate<Task> isNotCompleted = Predicate.not(Task::isCompleted);

    public static Predicate<Task> isValidForSave(){
        Predicate<Task> isNotNull = Objects::nonNull;

        return isNotNull
                .and(hasTitle)
                .and(hasValidPriority)
                .and(isNotCompleted);
    }
}
