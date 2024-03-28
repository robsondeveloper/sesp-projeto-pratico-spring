package br.gov.mt.sesp.sespprojetopraticospring.service;

import br.gov.mt.sesp.sespprojetopraticospring.dto.pessoa.PessoaRequest;
import br.gov.mt.sesp.sespprojetopraticospring.dto.pessoa.PessoaResponse;
import br.gov.mt.sesp.sespprojetopraticospring.mapper.PessoaMapper;
import br.gov.mt.sesp.sespprojetopraticospring.model.Pessoa;
import br.gov.mt.sesp.sespprojetopraticospring.repository.PessoaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    private final PessoaRepository repository;
    private final PessoaMapper mapper;

    public PessoaService(PessoaRepository repository, PessoaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<PessoaResponse> listar() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    public PessoaResponse porId(Long id) {
        return mapper.toResponse(buscar(id));
    }

    @Transactional
    public PessoaResponse criar(PessoaRequest request) {
        var pessoa = mapper.toModel(request);
        repository.save(pessoa);
        return mapper.toResponse(pessoa);
    }

    @Transactional
    public void atualizar(Long id, PessoaRequest request) {
        var pessoa = buscar(id);
        mapper.update(request, pessoa);
        repository.save(pessoa);
    }

    @Transactional
    public void deletar(Long id) {
        var pessoa = buscar(id);
        repository.delete(pessoa);
    }

    private Pessoa buscar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("pessoa não encontrada"));
    }
}
