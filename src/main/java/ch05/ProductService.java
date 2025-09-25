package ch05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService {
  Map<String, Product> products = new HashMap<>();

  public ProductService() {
    Product p = new Product("101", "i-phone 17", "애플", 1200000, "2025.09.14");
    products.put("101", p);
    p = new Product("110", "Gallaxy 25", "삼성", 1500000, "2025.09.24");
    products.put("110", p);
    p = new Product("102", "Gallaxy 23", "삼성", 1000000, "2025.09.24");
    products.put("102", p);
  }

  public List<Product> findAll() {
    return new ArrayList<>(products.values());
  }

  public Product find(String id) {
    return products.get(id);
  }
}
