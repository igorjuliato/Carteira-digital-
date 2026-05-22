package ApiCarteiraDigital.demo.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


public class DtoTransacao {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public final class Debito{
        @NotBlank
        private Long remetenteId;
        @NotBlank
        private Long destinatarioId;
        @NotBlank
        private BigDecimal valor;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public final class Credito{
        private Long remetenteId;
        private Long destinatarioId;
        private BigDecimal valorTotal;
        private int parcelas;
        private BigDecimal ValorDeEntrada;
    }
}
