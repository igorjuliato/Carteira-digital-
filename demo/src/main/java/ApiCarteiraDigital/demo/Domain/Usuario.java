package ApiCarteiraDigital.demo.Domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;import lombok.NoArgsConstructor;import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue
    private Long id;

    private String Nome;

    @OneToOne(mappedBy = "Carteira")
    private Carteira carteira;

    @Column(unique = true, nullable = false)
    private String Email;

    @Column(nullable = false)
    private String senha;
}
