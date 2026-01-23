package net.oussama.micordemo.entites;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.oussama.micordemo.audit.AudtiAwareImpl;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Date;
@Getter
@Setter
@ToString
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class) //role de sa
public class BaseEntitry {
    @Column(updatable = false)
    @CreatedDate
    private LocalDateTime creationDate;
    @Column(updatable = false)
    @CreatedBy
    private String CreadtedBy;
    @Column(insertable = false )
    @LastModifiedDate
    private LocalDateTime lastModificationDate;
    @Column(insertable = false )
    @LastModifiedBy
    private String UpdateBy;
    @Column(insertable = false )
    private LocalDateTime deletionDate;
    @Column(insertable = false)
    private String deletedBy;


}
