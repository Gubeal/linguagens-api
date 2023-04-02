package br.com.alura.linguagens.api;

import java.util.List;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class LinguagemController {

    @Autowired
    private LinguagemRepository repositorio;

    @GetMapping(value = "/linguagens")
    public List<Linguagem> obterLinguagens() {
        return repositorio.findByOrderByRanking();
    }

    @PostMapping(value = "/linguagens")
    public Linguagem inserirLinguagem(@RequestBody Linguagem linguagem) {
        return repositorio.save(linguagem);
    }

    @GetMapping(value = "/linguagens/{id}")
    public Linguagem obterLinguagemPorId(@PathVariable String id) {
        return repositorio.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping(value = "/linguagens/{id}")
    public Linguagem atualizarLinguagemPorId(@PathVariable String id, @RequestBody Linguagem linguagem) {
        if (!repositorio.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        linguagem.setId(id);
        return repositorio.save(linguagem);
    }

    @DeleteMapping(value = "/linguagens/{id}")
    public void excluirImagemPorId(@PathVariable String id) {
        repositorio.deleteById(id);
    }

}
