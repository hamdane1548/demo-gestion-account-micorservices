package net.oussama.micordemo.entites;

import jakarta.persistence.*;
import lombok.*;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class AccountEntity extends BaseEntitry {
    @Id
    private Long accountNumber;
    private Long customerNumber;
    private String accountType;
    private String branchAddress;
}
