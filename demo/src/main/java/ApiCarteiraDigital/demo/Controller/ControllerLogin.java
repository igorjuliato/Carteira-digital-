package ApiCarteiraDigital.demo.Controller;

import ApiCarteiraDigital.demo.Dto.DtoLoginUsuario;
import ApiCarteiraDigital.demo.Dto.DtoCadastroUsuario;
import ApiCarteiraDigital.demo.Service.ControleDeConta.ServiceRegistroDeUsuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice("/login")
public class ControllerLogin {

    @Autowired
    private AuthenticationManager maneger;

    @Autowired
    private ServiceRegistroDeUsuario registro;

    @PostMapping()
    public ResponseEntity Login(@RequestBody @Valid DtoLoginUsuario.Request dto){
       var userAutho = new UsernamePasswordAuthenticationToken(dto.getLogin(), dto.getSenha());
       var autho = maneger.authenticate(userAutho);

       return ResponseEntity.ok().build();
    }

    @PostMapping("/cadastro")
    public ResponseEntity Registro(@RequestBody @Valid DtoCadastroUsuario.Request dto){
      registro.RegistroDeUsuario(dto);
      return ResponseEntity.ok().build();
    }
}
