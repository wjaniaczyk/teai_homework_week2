package pl.wj.teai.homework.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.wj.teai.homework.model.Product;
import pl.wj.teai.homework.util.BigDecimalGenerator;

import java.util.HashSet;
import java.util.Set;

@Repository
public class ProductRepoRandomImpl implements IProductRepo{

    private Set<Product> products;
    private BigDecimalGenerator bigDecimalGenerator;

    @Autowired
    public ProductRepoRandomImpl(BigDecimalGenerator bigDecimalGenerator) {
        this.bigDecimalGenerator = bigDecimalGenerator;
        this.products = new HashSet<>();
        create5ProductsWithRandomPrices();
    }

    public Set<Product> getAllProducts() {
        return products;
    }

    private void create5ProductsWithRandomPrices(){
        Product product;
        for (int i = 1; i < 6; i++) {
            product = new Product(i, "product_" + i, bigDecimalGenerator.getRandomInGivenRange());
            addProduct(product);
        }
    }

    public void addProduct(Product product){
        products.add(product);
    }
}
