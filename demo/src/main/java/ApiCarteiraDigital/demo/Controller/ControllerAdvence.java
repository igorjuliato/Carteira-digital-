package ApiCarteiraDigital.demo.Controller;

import ApiCarteiraDigital.demo.infra.ExSenhaInconrreta;
import ApiCarteiraDigital.demo.infra.ExUsuarioInexistente;
import ApiCarteiraDigital.demo.infra.ExUsuarioJaExistente;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvence {

    @ExceptionHandler
    public ResponseEntity<String> exeptionsUsuarioNãoEncontrado(ExUsuarioInexistente ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<String> exeptionsUsuarioJaExistente(ExUsuarioJaExistente ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<String> exeSenhaIncorret(ExSenhaInconrreta ex){
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(ex.getMessage());
    }
}
