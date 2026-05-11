package ApiCarteiraDigital.demo.Service;

import ApiCarteiraDigital.demo.Dto.DtoTransacao;
import ApiCarteiraDigital.demo.Repository.RepositoryCarteira;
import ApiCarteiraDigital.demo.infra.ExTransacaoInvalida;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public class ServiceValidacaoDeTransicaoBancaria {

    @Autowired
    private RepositoryCarteira repository;

    public void Validar(DtoTransacao.Request dto){
     BigDecimal credito = repository.getDinheiro(dto.getDestinatarioId());

     if(credito.compareTo(BigDecimal.ZERO) < dto.getValor().compareTo(BigDecimal.ZERO)){
        new ExTransacaoInvalida("voce não tem credito suficiente");
     }
    }
}
