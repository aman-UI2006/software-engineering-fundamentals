# Practical Design Patterns

Patterns are reusable design vocabulary, not mandatory templates. Apply one only when it reduces coupling or clarifies a changing behavior.

| Pattern | Intent | Example |
|---|---|---|
| Strategy | Encapsulate interchangeable algorithms | Payment fee or route calculation |
| Factory Method | Delegate object creation | Parser selected by input type |
| Observer | Notify subscribers when state changes | Event subscribers |
| Adapter | Convert one interface into another | Legacy service integration |
| Decorator | Add behavior by wrapping an object | Logging or retry around a client |
| Builder | Construct complex objects step by step | Validated configuration |

## Strategy example (Java)
```java
interface DiscountPolicy { double apply(double subtotal); }
final class NoDiscount implements DiscountPolicy {
 public double apply(double subtotal){return subtotal;}
}
final class PercentageDiscount implements DiscountPolicy {
 private final double rate;
 PercentageDiscount(double rate){if(rate<0||rate>1)throw new IllegalArgumentException();this.rate=rate;}
 public double apply(double subtotal){return subtotal*(1-rate);}
}
final class Checkout {
 private final DiscountPolicy policy;
 Checkout(DiscountPolicy policy){this.policy=policy;}
 double total(double subtotal){return policy.apply(subtotal);}
}
```

Before introducing a pattern, identify the axis of change, compare it with a simpler conditional, and ensure the abstraction is independently testable.
