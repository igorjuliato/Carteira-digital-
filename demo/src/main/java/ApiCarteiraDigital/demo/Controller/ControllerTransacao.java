package ApiCarteiraDigital.demo.Controller;

import ApiCarteiraDigital.demo.Dto.DtoTransacao;
import ApiCarteiraDigital.demo.Service.ServiceTransacaoDebito;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice("/transacoes")
public class ControllerTransacao {

    private ServiceTransacaoDebito service;

    @PostMapping("/pagamento")
    public ResponseEntity<DtoTransacao.Response> TransacaoDebito(@Validated @ResponseBody DtoTransacao.Request dto){
       service.Debito(dto);
    }
}
