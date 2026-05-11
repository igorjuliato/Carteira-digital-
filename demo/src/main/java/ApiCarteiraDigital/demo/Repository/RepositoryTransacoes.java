package ApiCarteiraDigital.demo.Repository;

import ApiCarteiraDigital.demo.Domain.Transacoes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryTransacoes extends JpaRepository<Transacoes, Long> {

}
