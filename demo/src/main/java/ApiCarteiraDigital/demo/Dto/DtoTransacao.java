package ApiCarteiraDigital.demo.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


public class DtoTransacao {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static final class Debito{
        @NotNull
        private Long remetenteId;
        @NotNull
        private Long destinatarioId;
        @NotNull
        private BigDecimal valor;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static final class Credito{
        @NotNull
        private Long remetenteId;
        @NotNull
        private Long destinatarioId;
        @NotNull
        private BigDecimal valorTotal;
        @NotNull
        private int parcelas;
        @NotNull
        private BigDecimal ValorDeEntrada;
    }
}
