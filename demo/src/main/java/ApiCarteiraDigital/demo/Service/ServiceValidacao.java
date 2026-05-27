package ApiCarteiraDigital.demo.Service;

import ApiCarteiraDigital.demo.Domain.Usuario;
import ApiCarteiraDigital.demo.Dto.DtoCadastroUsuario;
import ApiCarteiraDigital.demo.Dto.DtoTransacao;
import ApiCarteiraDigital.demo.Repository.RepositoryCarteira;
import ApiCarteiraDigital.demo.Repository.RepositoryUsuario;
import ApiCarteiraDigital.demo.infra.ExTransacaoInvalida;
import ApiCarteiraDigital.demo.infra.ExUsuarioInexistente;
import ApiCarteiraDigital.demo.infra.ExUsuarioJaExistente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class ServiceValidacao {

    @Autowired
    private RepositoryUsuario repositoryUsuario;

    @Autowired
    private RepositoryCarteira repositoryCarteira;

    public void ValidadorDebito(DtoTransacao.Debito dto){
     BigDecimal credito = repositoryCarteira.getDinheiro(dto.getDestinatarioId());

     if(credito.compareTo(dto.getValor()) < 0) {
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

        if(credito.compareTo(dto.getValorDeEntrada()) < 0){
            throw new ExTransacaoInvalida("voce não tem credito o suficiente para essa entrada");
        }
    }

    public void ValidacaoDeUsuarioDebito(DtoTransacao.Debito dto) {
        boolean exist = repositoryUsuario.existsById(dto.getDestinatarioId());
        Optional<Usuario> usuario = repositoryUsuario.findById(dto.getDestinatarioId());
        if(exist == false || usuario.get().getAtivo() == false){throw new ExUsuarioInexistente("Usuario não foi encontrado ou não existe");}
        }

    public void ValidacaoDeUsuarioCredito(DtoTransacao.Credito dto) {
        boolean exist = repositoryUsuario.existsById(dto.getDestinatarioId());
        Optional<Usuario> usuario = repositoryUsuario.findById(dto.getDestinatarioId());
        if(exist == false || usuario.get().getAtivo() == false){throw new ExUsuarioInexistente("Usuario não foi encontrado ou não existe");}
    }
    }

