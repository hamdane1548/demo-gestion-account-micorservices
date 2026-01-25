package net.oussama.loans.entites;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
    @Column(updatable = false)
    @CreatedBy
    private String createby;
    @Column(updatable = false)
    @CreatedDate
    private LocalDateTime createdate;
    @Column(insertable = false)
    @LastModifiedBy
    private String updateby;
    @Column(insertable = false)
    @LastModifiedDate
    private LocalDateTime updatedate;

}
