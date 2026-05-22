package ApiCarteiraDigital.demo.Dto;

import ApiCarteiraDigital.demo.Domain.Transacoes;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DtoBuscarExtratos {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public final class Request{
        @NotBlank
        private Long Id;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {

        private Long transacaoId;
        private Long destinatarioId;
        private BigDecimal valor;
        private LocalDate data;

        public Response(Transacoes t){
            this.data = t.getDataTransicao();
            this.transacaoId= t.getId();
            this.destinatarioId= t.getDestinatarioId();
            this.valor = t.getValor();
        }
    }
}
