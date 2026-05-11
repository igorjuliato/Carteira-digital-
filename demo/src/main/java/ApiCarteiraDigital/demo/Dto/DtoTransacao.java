package ApiCarteiraDigital.demo.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


public class DtoTransacao {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public final class Request{
        private Long remetenteId;
        private Long destinatarioId;
        private BigDecimal valor;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public final class Response{
        private String mensagem;
    }
}
