package ApiCarteiraDigital.demo.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public class DtoAtualizarDadosDaConta {


    public final class Request{

        private String Login;

        private String senha;

        private LocalDate dataDeNascimento;

        @Email
        private String email;

        @CPF
        private String cpf
    }
}
