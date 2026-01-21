package net.oussama.micordemo.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Date;
@Getter
@Setter
@ToString
@MappedSuperclass
public class BaseEntitry {
    @Column(updatable = false)
    private LocalDateTime creationDate;
    @Column(updatable = false)
    private String CreadtedBy;
    @Column(insertable = false )
    private LocalDateTime lastModificationDate;
    @Column(insertable = false )
    private String UpdateBy;
    @Column(insertable = false )
    private LocalDateTime deletionDate;
    @Column(insertable = false)
    private String deletedBy;


}
