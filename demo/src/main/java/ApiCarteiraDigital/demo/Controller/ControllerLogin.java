package ApiCarteiraDigital.demo.Controller;

import ApiCarteiraDigital.demo.Dto.DtoLoginUsuario;
import ApiCarteiraDigital.demo.Service.SerivceRegistroUsuario;
import ApiCarteiraDigital.demo.Service.ServiceValidador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice("/login")
public class ControllerLogin {

    @Autowired
    private ServiceValidador validador;

    @Autowired
    private SerivceRegistroUsuario registroDeUsuario;

    @PostMapping
    public ResponseEntity<String> Login(@Validated @RequestBody DtoLoginUsuario.Request dto){
       String response =  validador.validarUsuario(dto);
       return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<String> Cadastro(@Validated @RequestBody DtoLoginUsuario.Request dto){
        String Token = registroDeUsuario.RegistrarUsuario(dto);
        return ResponseEntity.ok(Token);
    }

}
