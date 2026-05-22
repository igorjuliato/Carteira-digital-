package ApiCarteiraDigital.demo.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class DtoLoginUsuario {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public final class Request{
        @NotBlank
        private String login;
        @NotBlank
        private String senha;
    }
}
