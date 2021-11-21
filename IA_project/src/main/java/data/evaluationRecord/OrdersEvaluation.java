package data.evaluationRecord;

import java.util.ArrayList;
import java.util.List;

public class OrdersEvaluation {
    private List<Product> products;

    public OrdersEvaluation() {
        products = new ArrayList<>();
    }

    public OrdersEvaluation(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProducts(Product product){
        products.add(product);
    }

    @Override
    public String toString() {
        return "\n" +
                "{products=" + products +
                '}';
    }
}
