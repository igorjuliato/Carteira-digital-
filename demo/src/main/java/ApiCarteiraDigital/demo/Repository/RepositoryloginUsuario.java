package ApiCarteiraDigital.demo.Repository;

import ApiCarteiraDigital.demo.Domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryloginUsuario extends JpaRepository<Usuario, Long> {

}
