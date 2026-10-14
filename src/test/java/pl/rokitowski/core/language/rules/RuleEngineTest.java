package pl.rokitowski.core.language.rules;

import org.junit.jupiter.api.Test;
import pl.rokitowski.core.language.generics.Result;

import java.util.List;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class RuleEngineTest {
    record Order(String customerEmail, double totalAmount, int itemsCount){}

    @Test
    void shouldDetectInvalidOrderFields(){

        RuleEngine<Order> engine = new RuleEngine<>();

        engine.addFieldRule(
                o -> o.totalAmount(),
                a -> a > 0,
                "Kwota musi być większa od 0"
        );

        engine.addFieldRule(
                i -> i.itemsCount(),
                i -> i > 0,
                "Ilość rzeczy musi być większa od 0"
        );

        Order invalidOrder = new Order("jan@kowalski.pl", -50.0, 0);
        Result<Order, List<String>> result = engine.validateWithResult(invalidOrder);

        assertFalse(result.isSuccess);
        assertEquals(2, result.getError().size());
    }

    @Test
    void shouldPassWithValidFields(){
        RuleEngine<Order> engine = new RuleEngine<>();

        engine.addFieldRule(
                o -> o.totalAmount(),
                a -> a > 0,
                "Kwota musi być większa od 0"
        );

        engine.addFieldRule(
                i -> i.itemsCount(),
                i -> i > 0,
                "Ilość rzeczy musi być większa od 0"
        );

        Order invalidOrder = new Order("jan@kowalski.pl", 50.0, 3);
        Result<Order, List<String>> result = engine.validateWithResult(invalidOrder);

        assertTrue(result.isSuccess);
        assertNotNull(result.getData());
    }

    @Test
    void shouldDetectInvalidEmail(){
        RuleEngine<Order> engine = new RuleEngine<>();

        Predicate<String> notNull = s -> s != null;
        Predicate<String> validFormat = s -> !s.isBlank() && s.contains("@");

        engine.addFieldRule(
                e -> e.customerEmail(),
                notNull.and(validFormat),
                "Nieprawidłowy email"
        );

        Order invalidOrder = new Order(null, 50.0 , 3);
        Result<Order, List<String>> result = engine.validateWithResult(invalidOrder);

        assertFalse(result.isSuccess);
    }

}