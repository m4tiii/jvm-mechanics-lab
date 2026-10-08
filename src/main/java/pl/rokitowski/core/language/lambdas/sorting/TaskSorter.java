package pl.rokitowski.core.language.lambdas.sorting;

import pl.rokitowski.core.language.lambdas.model.Task;

import java.util.Comparator;

public class TaskSorter {
    private TaskSorter(){}

    public static Comparator<Task> getBackLogComparator(){
        return Comparator
                .comparing(Task::isCompleted)
                .thenComparingInt(Task::getPriority)
                .thenComparing(Task::getDueDate, Comparator.nullsLast(Comparator.naturalOrder()))
                .thenComparing(Task::getTitle, String.CASE_INSENSITIVE_ORDER);
    }
}
