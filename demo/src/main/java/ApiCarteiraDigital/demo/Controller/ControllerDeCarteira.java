package ApiCarteiraDigital.demo.Controller;

import ApiCarteiraDigital.demo.Dto.DtoBuscarExtratos;
import ApiCarteiraDigital.demo.Service.ServiceExtratos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerDeCarteira {

  @Autowired
  private ServiceExtratos extratos;


@GetMapping("/extratos")
public ResponseEntity<Page<DtoBuscarExtratos.Response>> BuscarExtratos(DtoBuscarExtratos.Request dto, Pageable page){
  Page<DtoBuscarExtratos.Response> response = extratos.BuscarExtratos(dto, page)
          .map(DtoBuscarExtratos.Response :: new);

  return ResponseEntity.ok(response);
}
}
