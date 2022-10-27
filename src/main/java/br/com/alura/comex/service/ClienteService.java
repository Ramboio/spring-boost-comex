package br.com.alura.comex.service;

import br.com.alura.comex.model.Cliente;
import br.com.alura.comex.model.ClienteForm;
import br.com.alura.comex.repository.ClienteRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ResponseEntity<Cliente> create(ClienteForm clienteForm) {
        Cliente cliente = clienteRepository.save(clienteForm.converter());

        return new ResponseEntity<>(cliente, HttpStatus.CREATED);
    }

    public ResponseEntity<List<Cliente>> listAll(int offset) {
        Pageable sortByName = PageRequest.of(offset,5, Sort.by("nome"));
        List<Cliente> returnList = clienteRepository.findAll(sortByName).getContent();

        return new ResponseEntity<>(returnList, HttpStatus.OK);
    }

    public Optional<Cliente> getById(Long id) {
        return clienteRepository.findById(id);
    }

}
