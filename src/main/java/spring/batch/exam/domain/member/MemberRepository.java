package spring.batch.exam.domain.member;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.batch.exam.domain.member.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
