package ApiCarteiraDigital.demo.Service;

import ApiCarteiraDigital.demo.Domain.Usuario;
import ApiCarteiraDigital.demo.Dto.DtoLoginUsuario;
import ApiCarteiraDigital.demo.Mapper.MapperUsuario;
import ApiCarteiraDigital.demo.Repository.RepositoryUsuario;
import ApiCarteiraDigital.demo.infra.ExUsuarioJaExistente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;


public class SerivceRegistroUsuario {

    @Autowired
    private MapperUsuario mapper;

    @Autowired
    private RepositoryUsuario repository;

    @Autowired
    private Usuario usuario;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String RegistrarUsuario(DtoLoginUsuario.Request dto) {
       boolean verificar = repository.existsByemail(dto.getEmail());
       if(verificar) throw new ExUsuarioJaExistente("Esse Usuario ja esta acadastrado no sistema" +
               ",deseja fazer login");

      usuario = mapper.converter(dto);

      String senhaHash = passwordEncoder.encode(dto.getSenha());

      usuario.setSenha(senhaHash);

      repository.save(usuario);
      return "usuario cadastrado com sucesso";
    }
}
