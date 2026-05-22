package ApiCarteiraDigital.demo.Controller;

import ApiCarteiraDigital.demo.Dto.DtoTransacao;
import ApiCarteiraDigital.demo.Service.Transacoes.ServiceTransacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice("/transacoes")
public class ControllerTransacao {

    @Autowired
    private ServiceTransacao service;

    @PostMapping("/debito")
    public ResponseEntity TransacaoDebito(@Validated  DtoTransacao.Debito dto){
      service.Debito(dto);

      return ResponseEntity.ok().build();
    }

    @PostMapping("/credito")
    public ResponseEntity TransacoesCredito(@Validated DtoTransacao.Credito dto){
      service.Credito(dto);

      return ResponseEntity.ok().build();
    }
}
