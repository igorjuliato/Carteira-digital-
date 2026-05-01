package ApiCarteiraDigital.demo.Mapper;

import ApiCarteiraDigital.demo.Domain.Usuario;
import ApiCarteiraDigital.demo.Dto.DtoLoginUsuario;
import org.mapstruct.Mapper;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;


@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = IGNORE)
public interface MapperUsuario {
    Usuario converter(DtoLoginUsuario.Request dto);
}
