package br.gov.mt.sesp.sespprojetopraticospring.resource;

import br.gov.mt.sesp.sespprojetopraticospring.dto.pessoa.PessoaRequest;
import br.gov.mt.sesp.sespprojetopraticospring.dto.pessoa.PessoaResponse;
import br.gov.mt.sesp.sespprojetopraticospring.service.PessoaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/v1/pessoas")
public class PessoaResource {

    private final PessoaService service;

    public PessoaResource(PessoaService service) {
        this.service = service;
    }

    @GetMapping
    public List<PessoaResponse> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public PessoaResponse porId(@PathVariable Long id) {
        return service.porId(id);
    }

    @PostMapping
    public ResponseEntity<PessoaResponse> criar(@RequestBody PessoaRequest request) {
        var response = service.criar(request);
        var uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable Long id, PessoaRequest request) {
        service.atualizar(id, request);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
