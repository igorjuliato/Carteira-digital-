package ApiCarteiraDigital.demo.Controller;

import ApiCarteiraDigital.demo.Dto.DtoLoginUsuario;import ApiCarteiraDigital.demo.Service.ServiceValidador;import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice("/login")
public class ControllerLogin {

    private ServiceValidador validador;

    @PostMapping
    public ResponseEntity<String> Login (@Validated DtoLoginUsuario.Request dto){
       String response =  validador.validarUsuario(dto);
       return ResponseEntity.ok(response);
    }

}
