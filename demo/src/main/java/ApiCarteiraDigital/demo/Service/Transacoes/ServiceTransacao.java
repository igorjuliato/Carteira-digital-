package ApiCarteiraDigital.demo.Service.Transacoes;

import ApiCarteiraDigital.demo.Domain.Carteira;
import ApiCarteiraDigital.demo.Domain.Usuario;
import ApiCarteiraDigital.demo.Dto.DtoTransacao;
import ApiCarteiraDigital.demo.Repository.RepositoryCarteira;
import ApiCarteiraDigital.demo.Repository.RepositoryUsuario;
import ApiCarteiraDigital.demo.Service.ServiceTaxasDeJuros;
import ApiCarteiraDigital.demo.Service.ServiceValidacao;
import ApiCarteiraDigital.demo.infra.ExUsuarioInexistente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class ServiceTransacao {

    @Autowired
    private ServiceValidacao validacao;

    @Autowired
    private RepositoryCarteira carteira;

    @Autowired
    private RepositoryUsuario repositoryUsuario;

    @Autowired
    private ServiceTaxasDeJuros taxaJuros;

    @Transactional
    public void Debito(DtoTransacao.Debito dto){
        validacao.ValidacaoDeUsuarioDebito(dto);
        validacao.ValidadorDebito(dto);

        Optional<Usuario> destinatario = repositoryUsuario.findById(dto.getDestinatarioId());
        Optional<Usuario> remetente = repositoryUsuario.findById(dto.getRemetenteId());

        Carteira carteiraRemetente = remetente.get().getCarteira();
        Carteira carteiraDestinatario = destinatario.get().getCarteira();

        carteiraRemetente.setDinheiro(carteiraRemetente.getDinheiro().subtract(dto.getValor()));
        carteiraDestinatario.setDinheiro(carteiraDestinatario.getDinheiro().add(dto.getValor()));

        carteira.save(carteiraDestinatario);
        carteira.save(carteiraRemetente);
    }

    @Transactional
    public void Credito(DtoTransacao.Credito dto ){
      validacao.ValidacaoDeUsuarioCredito(dto);
      validacao.ValidacaoCredito(dto);

      if(dto.getParcelas() > 6){
          taxaJuros.Alta(dto.getValorDeEntrada(), dto.getValorTotal(), dto.getParcelas());
      } else {
          taxaJuros.Baixa(dto.getValorDeEntrada(), dto.getValorTotal(), dto.getParcelas());
      }

      Carteira carteiraRemetente = carteira.findById(dto.getRemetenteId()).orElseThrow();
      Carteira carteiraDestinatario = carteira.findById(dto.getDestinatarioId()).orElseThrow();

      carteiraRemetente.setDinheiro(carteiraRemetente.getDinheiro().subtract(dto.getValorDeEntrada()));
      carteiraDestinatario.setDinheiro(carteiraRemetente.getDinheiro().add(dto.getValorDeEntrada()));

      carteira.save(carteiraRemetente);
      carteira.save(carteiraDestinatario);
    }
}
