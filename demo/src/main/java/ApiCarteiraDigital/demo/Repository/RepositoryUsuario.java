package ApiCarteiraDigital.demo.Repository;

import ApiCarteiraDigital.demo.Domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepositoryUsuario extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

    boolean existsByemail(String email);
}
