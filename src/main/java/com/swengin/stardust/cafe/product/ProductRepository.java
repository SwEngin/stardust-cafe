package com.swengin.stardust.cafe.product;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductRepository {

    public List<Product> products() {
        return List.of(new ProductBuilder().withName("Mocha").withPrice(3.45).build(),
                        new ProductBuilder().withName("Espresso").withPrice(2.75).build(),
                        new ProductBuilder().withName("Sandwich").withPrice(2.75).build(),
                        new ProductBuilder().withName("Croissant").withPrice(2.45).build(),
                        new ProductBuilder().withName("Cake").withPrice(2.45).build());
    }
}
