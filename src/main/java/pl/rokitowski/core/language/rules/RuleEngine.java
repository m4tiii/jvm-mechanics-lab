package pl.rokitowski.core.language.rules;

import pl.rokitowski.core.language.generics.Result;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class RuleEngine<T> {
    private final List<Rule<T>> rules = new ArrayList<>();

    public RuleEngine<T> addRule(Predicate<T> condition, String errorMessage){
        if (condition == null){
            throw new IllegalArgumentException("Warunek nie może być null!");
        }
        rules.add(new Rule<>(condition, errorMessage));
        return this;
    }

    public RuleEngine<T> addRule(Rule<T> rule){
        if(rule == null){
            throw new IllegalArgumentException("Warunek nie może być null!");
        }
        rules.add(rule);
        return this;
    }

    public List<String> validate(T target){
        List<String> errors = new ArrayList<>();

        for (Rule<T> rule : rules){
            if(!rule.isSatisfiedBy(target)){
                errors.add(rule.errorMessage());
            }
        }
        return errors;
    }

    public Result<T, List<String>> validateWithResult(T target){
        List<String> errors = validate(target);

        if(errors.isEmpty()){
            return Result.success(target);
        }
        return Result.failure(errors);
    }

    public <R> RuleEngine<T> addFieldRule(
            Function<T,R> fieldExtractor,
            Predicate<R> fieldCondition,
            String errorMessage){

        Predicate<T> combinedRule = target -> {
            R fieldValue = fieldExtractor.apply(target);
            return  fieldCondition.test(fieldValue);
        };

        return addRule(combinedRule, errorMessage);
    }
}
