package ApiCarteiraDigital.demo.Service;

import ApiCarteiraDigital.demo.Controller.ControllerLogin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(ControllerLogin.class)
public class TestControllerLogin {

    @MockitoBean
    private AuthenticationManager manager;

    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("deve dar tudo certo")
    public void Test1DeLogin() throws Exception {
        Authentication auth = mock(Authentication.class);

        when(manager.authenticate(any(Authentication.class))).thenReturn(auth);

        mvc.perform(post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                            "email":"teste@email.com",
                            "senha":"123456"
                        }
                        """
                )).andExpect(status().isOk());





    }
}
