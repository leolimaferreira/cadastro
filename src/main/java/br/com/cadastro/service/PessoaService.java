package br.com.cadastro.service;

import br.com.cadastro.model.Pessoa;
import br.com.cadastro.service.repository.PessoaRepository;
import br.com.cadastro.validator.CpfValidator;
import br.com.cadastro.validator.EmailValidator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final CpfValidator cpfValidator;
    private final EmailValidator emailValidator;

    public PessoaService(PessoaRepository pessoaRepository, CpfValidator cpfValidator, EmailValidator emailValidator) {
        this.pessoaRepository = pessoaRepository;
        this.cpfValidator = cpfValidator;
        this.emailValidator = emailValidator;
    }

    public List<Pessoa> findAll() {
        return this.pessoaRepository.findAll();
    }

    public Pessoa save(Pessoa pessoa) {
        cpfValidator.validar(pessoa);
        emailValidator.validar(pessoa);
        return pessoaRepository.save(pessoa);
    }

}
