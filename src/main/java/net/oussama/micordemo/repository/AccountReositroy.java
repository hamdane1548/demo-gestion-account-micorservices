package net.oussama.micordemo.repository;

import net.oussama.micordemo.entites.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface AccountReositroy extends JpaRepository<AccountEntity,Long> {
    Optional<AccountEntity> findBycustomerNumber(Long count);
}
