package spring.batch.exam.domain.cart;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.batch.exam.domain.member.Member;
import spring.batch.exam.domain.product.ProductOption;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartItemRepository cartItemRepository;

    public CartItem addItem(Member member, ProductOption productOption, int quantity) {
        CartItem oldCartItem = cartItemRepository.findByMemberIdAndProductOptionId(member.getId(), productOption.getId()).orElse(null);

        if ( oldCartItem != null ) {
            oldCartItem.setQuantity(oldCartItem.getQuantity() + quantity);
            cartItemRepository.save(oldCartItem);
            return oldCartItem;
        }

        CartItem cartItem = CartItem.builder()
                .member(member)
                .productOption(productOption)
                .quantity(quantity)
                .build();
        return cartItemRepository.save(cartItem);
    }
}
