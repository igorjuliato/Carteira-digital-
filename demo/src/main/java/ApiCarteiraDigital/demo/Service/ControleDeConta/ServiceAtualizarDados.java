package ApiCarteiraDigital.demo.Service.ControleDeConta;

import ApiCarteiraDigital.demo.Domain.Usuario;
import ApiCarteiraDigital.demo.Dto.DtoAtualizarDadosDaConta;
import ApiCarteiraDigital.demo.Repository.RepositoryUsuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceAtualizarDados {

    @Autowired
    private RepositoryUsuario repositoryUsuario;

    @Transactional
    public void DadosDaConta(Long id, @Valid DtoAtualizarDadosDaConta dto) {
        Usuario usuario = repositoryUsuario.findById(id).orElseThrow();
    }
}
