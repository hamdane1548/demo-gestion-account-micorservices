package net.oussama.cards.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Getter
@Setter @AllArgsConstructor @NoArgsConstructor
public class Cards extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long CardId;
    private String mobile_number;
    private String card_number;
    private String card_type;
    private String total_limit;
    private String available_amount;
    @Column(insertable = false)
    private String amount_used;
}
