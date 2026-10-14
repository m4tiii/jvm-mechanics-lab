package pl.rokitowski.core.language.rules;

import java.util.function.Predicate;

public record Rule<T>(Predicate<T> condition, String errorMessage) {
    public boolean isSatisfiedBy(T target){
        return condition.test(target);
    }
}
