package ApiCarteiraDigital.demo.Controller;

import ApiCarteiraDigital.demo.Dto.DtoAtualizarDadosDaConta;
import ApiCarteiraDigital.demo.Service.ControleDeConta.ServiceAtualizarDados;
import ApiCarteiraDigital.demo.Service.ControleDeConta.ServiceDeletar;
import jakarta.validation.Valid;
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

    @PutMapping("{id}/atualizarDadosConta")
    public ResponseEntity AtualizarDados(@PathVariable Long id, @Valid DtoAtualizarDadosDaConta dto){
        atualizar.DadosDaConta(id, dto);
    }

}
