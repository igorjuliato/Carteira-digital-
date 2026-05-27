package ApiCarteiraDigital.demo.Service.ControleDeConta;

import ApiCarteiraDigital.demo.Domain.Usuario;
import ApiCarteiraDigital.demo.Dto.DtoAtualizarDadosDaConta;
import ApiCarteiraDigital.demo.Mapper.MapperUsuario;
import ApiCarteiraDigital.demo.Repository.RepositoryUsuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceAtualizarDados {

    @Autowired
    private RepositoryUsuario repositoryUsuario;

    @Autowired
    private MapperUsuario mapper;

    @Transactional
    public void DadosDaConta(Long id, @Valid DtoAtualizarDadosDaConta.Request dto) {
        Usuario usuario = repositoryUsuario.findById(id).orElseThrow();

        mapper.Atualizar(dto, usuario);

        repositoryUsuario.save(usuario);
    }
}
