package br.newtonpaiva.book.api.livros.resource;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;

import br.newtonpaiva.book.api.livros.request.LivroRequest;
import br.newtonpaiva.book.api.livros.response.LivroResponse;

@RequestMapping(path = "/v1/livros")
public interface LivroResource {

    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<LivroResponse> getById(@PathVariable Optional<String> id);

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<LivroResponse> create(@RequestBody Optional<LivroRequest> request);

    @PutMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<LivroResponse> update(@PathVariable Optional<UUID> id,
            @RequestBody Optional<LivroRequest> request);

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<UUID> deleteById(@PathVariable Optional<String> id);

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LivroResponse>> getAll();

}
