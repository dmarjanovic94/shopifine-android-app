package rs.cod3rs.shopifine.domain;

import java.util.ArrayList;
import java.util.List;

public class OrderClause {

    public Long id;
    public Integer ordinal;
    public Integer quantity;
    public Double price;
    public Double amount;
    public Double discount;
    public Double discountAmount;
    public Long linkedProductId;
    public Product product;
    public List<Discount> discounts = new ArrayList<>();

    public OrderClause(
            final Long id,
            final Integer ordinal,
            final Integer quantity,
            final Double price,
            final Double amount,
            final Double discount,
            final Double discountAmount,
            final Long linkedProductId) {
        this.id = id;
        this.ordinal = ordinal;
        this.price = price;
        this.quantity = quantity;
        this.amount = amount;
        this.discount = discount;
        this.discountAmount = discountAmount;
        this.linkedProductId = linkedProductId;
    }
}
