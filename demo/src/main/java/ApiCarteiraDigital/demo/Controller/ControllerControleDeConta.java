package ApiCarteiraDigital.demo.Service.ControleDeConta;

import ApiCarteiraDigital.demo.Controller.ServiceAtualizarDados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@ControllerAdvice("/conta")
public class ControllerControleDeConta {

    @Autowired
    private ServiceDeletar serviceDeletar;

    @Autowired
    private ServiceAtualizarDados atualizar;

    @DeleteMapping("/{id}")
    public ResponseEntity DeletarConta(@PathVariable Long id){
      serviceDeletar.Conta(id);

      return ResponseEntity.noContent().build();
    }

    @PutMapping("/atualizarDadosConta")
    public ResponseEntity AtualizarDados()

}
