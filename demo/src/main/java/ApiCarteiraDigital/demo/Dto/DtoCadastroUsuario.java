package ApiCarteiraDigital.demo.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public class DtoCadastroUsuario {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @NotBlank
    public final class Request{
        @NotBlank
        private String Login;
        @NotBlank
        private String senha;
        @NotBlank
        private LocalDate dataDeNascimento;

        @NotBlank
        @Email
        private String email;

        @NotBlank
        @CPF
        private String cpf;
    }
}
