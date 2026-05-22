package ApiCarteiraDigital.demo.Service.ControleDeConta;

import ApiCarteiraDigital.demo.Domain.Usuario;
import ApiCarteiraDigital.demo.Repository.RepositoryUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceDeletar {

    @Autowired
    private RepositoryUsuario repositoryUsuario;

    @Transactional
    public void Conta(Long id){
        Usuario usuario = repositoryUsuario.findById(id).orElseThrow();

        usuario.setAtivo(false);

        repositoryUsuario.save(usuario);
    }



}
