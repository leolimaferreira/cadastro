package br.com.cadastro.validator;

import br.com.cadastro.exceptions.RegistroDuplicadoException;
import br.com.cadastro.model.Pessoa;
import br.com.cadastro.service.repository.PessoaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EmailValidator {
    private final PessoaRepository pessoaRepository;

    public EmailValidator(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public void validar(Pessoa pessoa) {
        if(existePessoaComEmail(pessoa)) {
            throw new RegistroDuplicadoException("Email já cadastrado!");
        }
    }

    private boolean existePessoaComEmail(Pessoa pessoa) {
        Optional<Pessoa> pessoaEncontrada = pessoaRepository.findByEmail(pessoa.getEmail());

        if(pessoa.getEmail() == null) {
            return pessoaEncontrada.isPresent();
        }

        return pessoaEncontrada
                .map(Pessoa::getEmail)
                .stream()
                .anyMatch(id -> !id.equals(pessoa.getId()));
    }
}
