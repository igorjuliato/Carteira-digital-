package ApiCarteiraDigital.demo.infra;

public class ExTransacaoInvalida extends RuntimeException {
    public ExTransacaoInvalida(String message) {
        super(message);
    }
}
