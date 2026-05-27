package ApiCarteiraDigital.demo.Mapper;

import ApiCarteiraDigital.demo.Domain.Usuario;
import ApiCarteiraDigital.demo.Dto.DtoAtualizarDadosDaConta;
import ApiCarteiraDigital.demo.Dto.DtoLoginUsuario;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;


@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = IGNORE)
public interface MapperUsuario {
    Usuario converter(DtoLoginUsuario.Request dto);

    void Atualizar(DtoAtualizarDadosDaConta.Request dto, @MappingTarget Usuario usuario);
}
