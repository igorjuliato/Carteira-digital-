package ApiCarteiraDigital.demo.Service;

import ApiCarteiraDigital.demo.Domain.Transacoes;
import ApiCarteiraDigital.demo.Dto.DtoBuscarExtratos;
import ApiCarteiraDigital.demo.Repository.RepositoryCarteira;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceExtratos {

    @Autowired
    private RepositoryCarteira repository;

    public Page<Transacoes> BuscarExtratos(DtoBuscarExtratos.Request dto, Pageable page){
     return repository.FindByCarteirasId(dto.getId(), page);
    }
}
