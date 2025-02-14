package br.com.cadastro.controller;

import br.com.cadastro.model.Pessoa;
import br.com.cadastro.service.PessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoaController implements GenericController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping("/todasPessoas")
    public ResponseEntity<List<Pessoa>> buscarTodos() {
        return ResponseEntity.ok(this.pessoaService.findAll());
    }

    @PostMapping("cadastro")
    public ResponseEntity<Void> cadastrarPessoa(@RequestBody @Valid Pessoa pessoa) {

        Pessoa pessoaSalvar = new Pessoa();
        pessoaSalvar.setNome(pessoa.getNome());
        pessoaSalvar.setSexo(pessoa.getSexo());
        pessoaSalvar.setCpf(pessoa.getCpf());
        pessoaSalvar.setEmail(pessoa.getEmail());
        pessoaSalvar.setCelular(pessoa.getCelular());

        pessoaService.save(pessoaSalvar);
        var url = gerarHeaderLocation(pessoa.getId());
        return ResponseEntity.created(url).build();
    }

}
