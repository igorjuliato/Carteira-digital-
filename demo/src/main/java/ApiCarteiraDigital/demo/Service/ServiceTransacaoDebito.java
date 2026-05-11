package ApiCarteiraDigital.demo.Service;

import ApiCarteiraDigital.demo.Domain.Carteira;
import ApiCarteiraDigital.demo.Domain.Usuario;
import ApiCarteiraDigital.demo.Dto.DtoTransacao;
import ApiCarteiraDigital.demo.Repository.RepositoryCarteira;
import ApiCarteiraDigital.demo.Repository.RepositoryUsuario;
import ApiCarteiraDigital.demo.infra.ExUsuarioInexistente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceTransacaoDebito {

    private ServiceValidacaoDeTransicaoBancaria validacao;

    @Autowired
    private RepositoryCarteira carteira;

    @Autowired
    private RepositoryUsuario usuario;

    @Autowired
    private DtoTransacao.Response response;

    public DtoTransacao.Response Debito(DtoTransacao.Request dto){
        boolean exist = usuario.existsById(dto.getDestinatarioId());
        if (exist == false) throw new ExUsuarioInexistente("esse usuario não existe");

        validacao.Validar(dto);

        Optional<Usuario> remetente = usuario.findById(dto.getRemetenteId());
        Optional<Usuario> destinatario = usuario.findById(dto.getDestinatarioId());

        Carteira carteiraRemetente = remetente.get().getCarteira();
        Carteira carteiraDestinatario = destinatario.get().getCarteira();

        carteiraRemetente.setDinheiro(carteiraRemetente.getDinheiro().subtract(dto.getValor()));
        carteiraDestinatario.setDinheiro(carteiraDestinatario.getDinheiro().add(dto.getValor()));

        carteira.save(carteiraDestinatario);
        carteira.save(carteiraRemetente);

        response.setMensagem("foi relizado uma transferencia de " +
                dto.getValor() + "para " + destinatario.get().getNome());

        return response;
    }
}
