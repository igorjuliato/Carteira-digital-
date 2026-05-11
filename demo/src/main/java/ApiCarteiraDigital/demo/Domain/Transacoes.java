package ApiCarteiraDigital.demo.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@Data
@Table(name = "transacao")
public class Transacoes {

        @Id
        @GeneratedValue
        private Long id;

        private Long RemetenteId;
        private Long destinatarioId;

        private BigDecimal Valor;

        private LocalDate dataTransicao;

        private String status;
}
