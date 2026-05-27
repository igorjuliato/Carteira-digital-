package ApiCarteiraDigital.demo.Service;

import ApiCarteiraDigital.demo.Domain.Carteira;
import ApiCarteiraDigital.demo.Domain.Usuario;
import ApiCarteiraDigital.demo.Dto.DtoTransacao;
import ApiCarteiraDigital.demo.Repository.RepositoryCarteira;
import ApiCarteiraDigital.demo.Repository.RepositoryUsuario;
import ApiCarteiraDigital.demo.infra.ExTransacaoInvalida;
import ApiCarteiraDigital.demo.infra.ExUsuarioInexistente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TestValidacaoDebito {

    @Mock
    private RepositoryUsuario repositoryUsuario;

    @Mock
    private RepositoryCarteira repositoryCarteira;

    @InjectMocks
    private ServiceValidacao validacao;

    @Captor
    private ArgumentCaptor<Carteira> captorCarteira;


    @Test
    @DisplayName("deve ocorrer ExTransacaoInvalida")
    public void teste1DeValidacaoDeCredito(){
        DtoTransacao.Debito dto = new DtoTransacao.Debito();
        dto.setDestinatarioId(1L);
        dto.setRemetenteId(2L);
        dto.setValor(new BigDecimal("100"));

        when(repositoryCarteira.getDinheiro(anyLong()))
                .thenReturn(new BigDecimal("80"));


        Assertions.assertThrows(ExTransacaoInvalida.class,() -> validacao.ValidadorDebito(dto));
    }

    @Test
    @DisplayName("não deve ocorrer nada")
    public void teste2DeValidacaoDeCredito(){
        DtoTransacao.Debito dto = new DtoTransacao.Debito();
        dto.setDestinatarioId(1L);
        dto.setRemetenteId(2L);
        dto.setValor(new BigDecimal("100"));

        when(repositoryCarteira.getDinheiro(anyLong()))
                .thenReturn(new BigDecimal("100"));

        validacao.ValidadorDebito(dto);
    }

    @Test
    @DisplayName("deve ocorrer ExUsuarioInexistente, por inexistencia")
    public void teste1DeErroValidacaoDeUsuario(){
        DtoTransacao.Debito dto = new DtoTransacao.Debito();
        dto.setDestinatarioId(1L);
        dto.setRemetenteId(2L);
        dto.setValor(new BigDecimal("100"));

        when(repositoryUsuario.existsById(anyLong())).thenReturn(false);

        Assertions.assertThrows(ExUsuarioInexistente.class,() -> validacao.ValidacaoDeUsuarioDebito(dto));
    }

    @Test
    @DisplayName("deve ocorrer ExUsuarioInexistente, por usuario esta inativo")
    public void teste2DeErroValidacaoDeUsuario(){
        DtoTransacao.Debito dto = new DtoTransacao.Debito();
        dto.setDestinatarioId(1L);
        dto.setRemetenteId(2L);
        dto.setValor(new BigDecimal("100"));

        Usuario usuario = new Usuario();
        usuario.setAtivo(false);

        when(repositoryUsuario.findById(anyLong())).thenReturn(Optional.of(usuario));

        Assertions.assertThrows(ExUsuarioInexistente.class,() -> validacao.ValidacaoDeUsuarioDebito(dto));
    }

    @Test
    @DisplayName("não deve ocorrer nada")
    public void teste3DeValidacaoDeUsuario(){
        DtoTransacao.Debito dto = new DtoTransacao.Debito();
        dto.setDestinatarioId(1L);
        dto.setRemetenteId(2L);
        dto.setValor(new BigDecimal("100"));

        Usuario usuario = new Usuario();
        usuario.setAtivo(true);

        when(repositoryUsuario.existsById(anyLong())).thenReturn(true);
        when(repositoryUsuario.findById(anyLong())).thenReturn(Optional.of(usuario));

        validacao.ValidacaoDeUsuarioDebito(dto);
    }




}
