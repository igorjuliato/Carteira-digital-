package TestIntegracao;


import org.junit.jupiter.api.Nested;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = ApiCarteiraDigital.demo.DemoApplication.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class TestTransacao {


    @Nested
    class Transacao {

        @Nested
        class Sucesso{

            void test1(){
               private
            }
        }


        @Nested
        class Erro{

        }
    }

}
