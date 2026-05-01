package ApiCarteiraDigital.demo.infra;

public class ExUsuarioJaExistente extends RuntimeException {
    public ExUsuarioJaExistente(String message) {
        super(message);
    }
}
