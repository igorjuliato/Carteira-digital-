package ApiCarteiraDigital.demo.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class DtoLoginUsuario {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public final class Request{
        private String email;
        private String senha;
    }
}
