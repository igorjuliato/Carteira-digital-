package ApiCarteiraDigital.demo.Service;

import ApiCarteiraDigital.demo.Domain.Carteira;
import ApiCarteiraDigital.demo.Domain.Usuario;
import ApiCarteiraDigital.demo.Dto.DtoTransacao;
import ApiCarteiraDigital.demo.Repository.RepositoryCarteira;
import ApiCarteiraDigital.demo.Repository.RepositoryUsuario;
import ApiCarteiraDigital.demo.infra.ExUsuarioInexistente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ServiceTransacao {

    @Autowired
    private ServiceValidacao validacao;

    @Autowired
    private RepositoryCarteira carteira;

    @Autowired
    private RepositoryUsuario usuario;

    @Autowired
    private DtoTransacao.Debito response;

    @Transactional
    public void Debito(DtoTransacao.Debito dto){
        boolean exist = usuario.existsById(dto.getDestinatarioId());
        if (exist == false) throw new ExUsuarioInexistente("esse usuario não existe");

        validacao.ValidadorDebito(dto);

        Optional<Usuario> remetente = usuario.findById(dto.getRemetenteId());
        Optional<Usuario> destinatario = usuario.findById(dto.getDestinatarioId());

        Carteira carteiraRemetente = remetente.get().getCarteira();
        Carteira carteiraDestinatario = destinatario.get().getCarteira();

        carteiraRemetente.setDinheiro(carteiraRemetente.getDinheiro().subtract(dto.getValor()));
        carteiraDestinatario.setDinheiro(carteiraDestinatario.getDinheiro().add(dto.getValor()));

        carteira.save(carteiraDestinatario);
        carteira.save(carteiraRemetente);
    }

    @Transactional
    public void Credito(DtoTransacao.Credito dto ){
      validacao.ValidacaoCredito(dto);
    }
}
