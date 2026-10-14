package pl.rokitowski.core.language.patternmatching;

public sealed interface OrderStatus permits OrderStatus.Pending, OrderStatus.Shipped, OrderStatus.Cancelled{

    record Pending(int daysToShip) implements OrderStatus {}
    record Shipped(String trackingNumber) implements OrderStatus {}
    record Cancelled(String reason) implements OrderStatus {}
}
