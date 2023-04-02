package br.com.alura.linguagens.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LinguagemController {

    @Autowired
    private LinguagemRepository repositorio;

    @GetMapping(value = "/linguagens")
    public List<Linguagem> obterLinguagens() {
        return repositorio.findAll();
    }

    @PostMapping(value = "/linguagens")
    public Linguagem inserirLinguagem(@RequestBody Linguagem linguagem) {
        return repositorio.save(linguagem);
    }
}
