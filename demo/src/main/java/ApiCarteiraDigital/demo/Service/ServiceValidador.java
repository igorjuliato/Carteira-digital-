package ApiCarteiraDigital.demo.Service;

import ApiCarteiraDigital.demo.Domain.Usuario;
import ApiCarteiraDigital.demo.Dto.DtoLoginUsuario;
import ApiCarteiraDigital.demo.Repository.RepositoryUsuario;
import ApiCarteiraDigital.demo.infra.ExSenhaInconrreta;
import ApiCarteiraDigital.demo.infra.ExUsuarioInexistente;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class ServiceValidador {

    @Autowired
    private RepositoryUsuario repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String validarUsuario(DtoLoginUsuario.Request dto) {

        Usuario usuario = repository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new ExUsuarioInexistente("usuario não cadastrado"));

        boolean match = passwordEncoder.matches(dto.getSenha(), usuario.getSenha());
        if (match) {
            return "tkk_liberado";
        } else {
            throw new ExSenhaInconrreta("senha ou email incorreto");
        }
    }
}
