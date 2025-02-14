package br.com.cadastro.validator;

import br.com.cadastro.exceptions.RegistroDuplicadoException;
import br.com.cadastro.model.Pessoa;
import br.com.cadastro.service.repository.PessoaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CpfValidator {

    private final PessoaRepository pessoaRepository;

    public CpfValidator(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public void validar(Pessoa pessoa) {
        if(existePessoaComCpf(pessoa)) {
            throw new RegistroDuplicadoException("CPF já cadastrado!");
        }
    }

    private boolean existePessoaComCpf(Pessoa pessoa) {
        Optional<Pessoa> pessoaEncontrada = pessoaRepository.findByCpf(pessoa.getCpf());

        if(pessoa.getCpf() == null) {
            return pessoaEncontrada.isPresent();
        }

        return pessoaEncontrada
                .map(Pessoa::getCpf)
                .stream()
                .anyMatch(id -> !id.equals(pessoa.getId()));
    }
}
