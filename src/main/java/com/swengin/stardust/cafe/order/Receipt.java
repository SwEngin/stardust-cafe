package com.swengin.stardust.cafe.order;

import net.karneim.pojobuilder.GeneratePojoBuilder;

import java.util.List;
import java.util.Objects;

@GeneratePojoBuilder
public class Receipt {

    private List<Item> items;
    private String message;
    private double total;


    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receipt that = (Receipt) o;
        return Objects.equals(items, that.items)
                && Objects.equals(message, that.message)
                && Objects.equals(total, that.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(items, message, total);
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "items=" + items +
                ", message='" + message + '\'' +
                ", total=" + total +
                '}';
    }
}
