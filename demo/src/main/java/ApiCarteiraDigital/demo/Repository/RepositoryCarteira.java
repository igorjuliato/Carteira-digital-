package ApiCarteiraDigital.demo.Repository;

import ApiCarteiraDigital.demo.Domain.Carteira;
import ApiCarteiraDigital.demo.Domain.Transacoes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;


public interface RepositoryCarteira extends JpaRepository<Carteira, Long> {

    @Query("SELECT c.dinheiro FROM Carteiras c WHERE c.id = :id")
    BigDecimal getDinheiro(@Param("id") Long id);

    Page<Transacoes> FindByCarteirasId(Long id , Pageable page);
}
