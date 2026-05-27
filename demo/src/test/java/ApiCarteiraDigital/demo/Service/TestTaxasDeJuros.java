package ApiCarteiraDigital.demo.Service;

import ApiCarteiraDigital.demo.Dto.DtoTransacao;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

@ExtendWith(MockitoExtension.class)
public class TestTaxasDeJuros {

    @Autowired
    private ServiceTaxasDeJuros service;

    @Test
    @DisplayName("esse metodo deve dar erro por inexistencia do usuario")
    public void test1InvalidoPorInexistencia(){



        Assertions.assertEquals(service.Baixa());
    }
}
