package ch05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService {
  Map<String, Product> products = new HashMap<>();

  public ProductService() {
    Product p = new Product("1", "i-phone 17", "애플", 1200000, "2025.09.14");
    products.put("1", p);
    p = new Product("2", "Gallaxy 25", "삼성", 1500000, "2025.09.24");
    products.put("2", p);
  }

  public List<Product> findAll() {
    return new ArrayList<>(products.values());
  }

  public Product find(String id) {
    return products.get(id);
  }
}
