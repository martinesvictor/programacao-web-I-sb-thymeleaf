package br.com.ada.programacaowebIsb.service;

import br.com.ada.programacaowebIsb.model.Cliente;
import br.com.ada.programacaowebIsb.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public void createCliente(Cliente cliente){
        this.clienteRepository.save(cliente);
    }

    public List<Cliente> listarTodos() {
        return this.
                clienteRepository.findAll();
    }

    public Page<Cliente> listarPaginado(Integer numeroPagina, Integer tamanhoPagina) {
        return this.clienteRepository
                   .findAll(PageRequest.of(numeroPagina, tamanhoPagina, Sort.by(Sort.Order.asc("id"))));
    }

    public Optional<Cliente> buscarClientePorId(Long id) {
        return this.clienteRepository.findById(id);
    }

    public Optional<Cliente> buscarClientePeloCpf(String cpf) {
        return this.clienteRepository.findByCpfContaining(cpf);
    }

    public void removerClientePorId(Long id) {
        this.clienteRepository.deleteById(id);
    }
}
