package ApiCarteiraDigital.demo.Domain;

import ApiCarteiraDigital.demo.Dto.DtoCadastroUsuario;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue
    private Long id;

    private String Nome;

    @OneToOne(mappedBy = "DonoCarteira")
    private Carteira carteira;

    @Column(unique = true, nullable = false)
    private String Email;

    @Column(nullable = false)
    private String senha;

    private UsuarioRole role;

    private Boolean ativo = true;

    @Override
    public boolean isEnabled() {
        return this.ativo;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == UsuarioRole.MAIOR) return List.of(new SimpleGrantedAuthority("DE_MAIOR"));
        else {
            return List.of(new SimpleGrantedAuthority("DE_MAIOR"));
        }
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return Nome;
    }
}
