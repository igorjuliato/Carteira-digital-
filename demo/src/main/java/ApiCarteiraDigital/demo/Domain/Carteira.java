package ApiCarteiraDigital.demo.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@Data
@Table(name = "carteiras")
public class Carteira {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @OneToOne
    @JoinColumn(name = "Usuario_id", unique = true)
    private Usuario DonoCarteira;

    private BigDecimal dinheiro;

}
