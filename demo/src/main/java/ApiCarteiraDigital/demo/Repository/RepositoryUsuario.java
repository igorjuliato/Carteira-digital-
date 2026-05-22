package ApiCarteiraDigital.demo.Repository;

import ApiCarteiraDigital.demo.Domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface RepositoryUsuario extends JpaRepository<Usuario, Long> {

    boolean findByEmail(String email);

    boolean existsByemail(String email);

    Usuario findByLogin(String login);

    boolean existByLogin(String login);

    boolean existByCPF(String cpf);
}
