package net.oussama.cards.repository;

import net.oussama.cards.entites.Cards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CardsRepository extends JpaRepository<Cards, Long> {
    @Query("select c from Cards c where c.card_number like :wq")
    Optional<Cards> findBycard_number(@Param("wq") String card_number);
}
