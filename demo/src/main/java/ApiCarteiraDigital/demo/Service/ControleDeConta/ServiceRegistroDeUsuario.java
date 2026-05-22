package ApiCarteiraDigital.demo.Service;

import ApiCarteiraDigital.demo.Domain.Carteira;
import ApiCarteiraDigital.demo.Domain.Usuario;
import ApiCarteiraDigital.demo.Domain.UsuarioRole;
import ApiCarteiraDigital.demo.Dto.DtoCadastroUsuario;
import ApiCarteiraDigital.demo.Repository.RepositoryCarteira;
import ApiCarteiraDigital.demo.Repository.RepositoryUsuario;
import ApiCarteiraDigital.demo.Service.RegrasDeNegocios.ServiceValidacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class ServiceRegistroDeUsuario {

    @Autowired
    private ServiceValidacao validacao;

    @Autowired
    private RepositoryUsuario repository;

    @Autowired
    private RepositoryCarteira repositoryCarteira;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void RegistroDeUsuario(DtoCadastroUsuario.Request dto) {
        validacao.ValidacaoDeExistenciaDeUsuario(dto);

        String SenhaCript = passwordEncoder.encode(dto.getSenha());

        int idade = Period.between(dto.getDataDeNascimento(), LocalDate.now()).getYears();

        Usuario usuario = new Usuario();
        usuario.setSenha(SenhaCript);
        usuario.setNome(dto.getLogin());
        usuario.setEmail(dto.getEmail());
        Carteira carteira = new Carteira();
        carteira.setDonoCarteira(usuario);

        if (idade >= 18) {
            usuario.setRole(UsuarioRole.MAIOR);
        } else {
            usuario.setRole(UsuarioRole.MENOR);
        }

        repository.save(usuario);
        repositoryCarteira.save(carteira);
    }
}
