package spring.batch.exam.domain.cart;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    Optional<CartItem> findByMemberIdAndProductOptionId(long memberId, long productOptionId);
    List<CartItem> findAllByMemberId(Long memberId);

}
