package spring.batch.exam.domain.cash;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.batch.exam.domain.member.Member;

@Service
@RequiredArgsConstructor
public class CashService {
    private final CashLogRepository cashLogRepository;

    public CashLog addCash(Member member, long price, String eventType) {
        CashLog cashLog = CashLog.builder()
                .member(member)
                .price(price)
                .eventType(eventType)
                .build();

        cashLogRepository.save(cashLog);

        return cashLog;
    }
}
