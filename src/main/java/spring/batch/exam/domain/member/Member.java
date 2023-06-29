package spring.batch.exam.domain.member;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Service;
import spring.batch.exam.domain.base.BaseEntity;

@Entity
@Getter
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
@Setter
public class Member extends BaseEntity {
    private String username;
    private String password;
    private String email;
    private long restCash;
}
