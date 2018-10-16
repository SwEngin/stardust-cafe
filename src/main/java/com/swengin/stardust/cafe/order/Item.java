package com.swengin.stardust.cafe.order;

import com.swengin.stardust.cafe.product.Product;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class Item {

    @NotNull
    private Product product;
    @NotNull
    private int quantity;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item that = (Item) o;
        return Objects.equals(product, that.product)
                && Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, quantity);
    }

    @Override
    public String toString() {
        return "Item{"
                + "product=" + product
                + "quantity=" + quantity
                + '}';
    }
}
