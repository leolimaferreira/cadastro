package br.com.cadastro.service;

import br.com.cadastro.exceptions.RegistroDuplicadoException;
import br.com.cadastro.model.Pessoa;
import br.com.cadastro.service.repository.PessoaRepository;
import br.com.cadastro.validator.CpfValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final CpfValidator cpfValidator;

    public PessoaService(PessoaRepository pessoaRepository, CpfValidator cpfValidator) {
        this.pessoaRepository = pessoaRepository;
        this.cpfValidator = cpfValidator;
    }

    public List<Pessoa> findAll() {
        return this.pessoaRepository.findAll();
    }

    public Pessoa save(Pessoa pessoa) {
        cpfValidator.validar(pessoa);
        return pessoaRepository.save(pessoa);
    }

    public Optional<Pessoa> findByCpf(String cpf) {return this.pessoaRepository.findByCpf(cpf);}
}
