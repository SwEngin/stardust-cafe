package com.swengin.stardust.cafe.order;

import com.swengin.stardust.cafe.CafeException;
import com.swengin.stardust.cafe.product.Product;
import com.swengin.stardust.cafe.product.ProductRepository;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderService {

    private final static String RECEIPT_MESSAGE = "Thanks for your order, see you soon!";
    private final ProductRepository productRepository;

    public OrderService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public Receipt doOrder(List<Item> items) {

        List<Product> products = productRepository.products();

        if (CollectionUtils.isEmpty(retriveRealProducts(items, products))) {
            throw new CafeException("Order can't be accepted, please choose an item!");
        }

        return new ReceiptBuilder()
                .withItems(items)
                .withTotal(calculateTotal(items, products))
                .withMessage(RECEIPT_MESSAGE)
                .build();
    }

    private List<Product> retriveRealProducts(List<Item> items, List<Product> products) {
        return items.stream()
                .filter(item -> products.contains(item.getProduct()))
                .map(item -> item.getProduct())
                .collect(Collectors.toList());
    }

    private double calculateTotal(List<Item> items, List<Product> products) {
        return items.stream()
                .filter(item -> products.contains(item.getProduct()))
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();
    }

}
