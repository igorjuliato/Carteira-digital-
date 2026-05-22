package ApiCarteiraDigital.demo.Service.RegrasDeNegocios;

import ApiCarteiraDigital.demo.Dto.DtoCadastroUsuario;
import ApiCarteiraDigital.demo.Dto.DtoTransacao;
import ApiCarteiraDigital.demo.Repository.RepositoryCarteira;
import ApiCarteiraDigital.demo.Repository.RepositoryUsuario;
import ApiCarteiraDigital.demo.infra.ExTransacaoInvalida;
import ApiCarteiraDigital.demo.infra.ExUsuarioJaExistente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ServiceValidacao {

    @Autowired
    private RepositoryUsuario repositoryUsuario;

    @Autowired
    private RepositoryCarteira repositoryCarteira;

    public void ValidadorDebito(DtoTransacao.Debito dto){
     BigDecimal credito = repositoryCarteira.getDinheiro(dto.getDestinatarioId());

     if(credito.compareTo(BigDecimal.ZERO) < dto.getValor().compareTo(BigDecimal.ZERO)){
        throw new ExTransacaoInvalida("voce não tem credito suficiente");
     }
    }

    public void ValidacaoDeExistenciaDeUsuario(DtoCadastroUsuario.Request dto) {
        boolean validEmail = repositoryUsuario.findByEmail(dto.getEmail());
        boolean validCPF = repositoryUsuario.existByCPF(dto.getCpf());
        boolean validLogin = repositoryUsuario.existByLogin(dto.getLogin());

        if (validCPF || validEmail || validLogin) {
            throw new ExUsuarioJaExistente("Email ou login ja existente no sistema");
        }
    }

    public void ValidacaoCredito(DtoTransacao.Credito dto){
        BigDecimal credito = repositoryCarteira.getDinheiro(dto.getDestinatarioId());

        if(credito.compareTo(BigDecimal.ZERO) < dto.getValorDeEntrada().compareTo(BigDecimal.ZERO)){
            throw new ExTransacaoInvalida("voce não tem credito suficiente");
        }
    }
}
