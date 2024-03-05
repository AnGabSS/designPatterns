package one.digitalinnovation.designpatterns.service;

import one.digitalinnovation.designpatterns.model.Cliente;

public interface ClienteService {

    Iterable<Cliente> findAll();

    Cliente searchForId(Long id);

    void inserir(Cliente cliente);

    void atualizar(Long id, Cliente cliente);

    void deletar(Long id);
}
