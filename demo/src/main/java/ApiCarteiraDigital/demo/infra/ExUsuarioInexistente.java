package ApiCarteiraDigital.demo.infra;

public class ExUsuarioInexistente extends RuntimeException {
    public ExUsuarioInexistente(String message) {
        super(message);
    }
}
