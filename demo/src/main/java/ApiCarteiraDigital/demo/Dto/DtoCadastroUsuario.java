package ApiCarteiraDigital.demo.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public class DtoRegistroUsuario {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @NotBlank
    public final class Request{
        private String Login;
        private String senha;
        private LocalDate dataDeNascimento;

        @Email
        private String email;

        @CPF
        private String cpf;
    }
}
