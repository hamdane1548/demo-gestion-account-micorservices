package net.oussama.micordemo.repository;

import jakarta.transaction.Transactional;
import net.oussama.micordemo.entites.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface AccountReositroy extends JpaRepository<AccountEntity,Long> {
    Optional<AccountEntity> findBycustomerNumber(Long count);
    @Transactional
    @Modifying
    Optional<Boolean> deleteBycustomerNumber(Long count);
}
