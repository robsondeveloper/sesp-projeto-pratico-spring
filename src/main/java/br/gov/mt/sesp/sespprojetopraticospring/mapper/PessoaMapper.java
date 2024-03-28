package br.gov.mt.sesp.sespprojetopraticospring.mapper;

import br.gov.mt.sesp.sespprojetopraticospring.dto.pessoa.PessoaRequest;
import br.gov.mt.sesp.sespprojetopraticospring.dto.pessoa.PessoaResponse;
import br.gov.mt.sesp.sespprojetopraticospring.model.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PessoaMapper {

    PessoaResponse toResponse(Pessoa model);

    Pessoa toModel(PessoaRequest request);

    void update(PessoaRequest request, @MappingTarget Pessoa model);
}