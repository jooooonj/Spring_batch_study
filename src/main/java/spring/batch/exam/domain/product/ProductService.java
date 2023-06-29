package spring.batch.exam.domain.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public void create(String name, int price, String makerShopName, List<ProductOption> options) {
        Product product = Product.builder()
                .name(name)
                .price(price)
                .makerShopName(makerShopName)
                .build();

        for (ProductOption option : options ) {
            product.addOption(option);
        }

        productRepository.save(product);
        productRepository.save(product);
    }
}
