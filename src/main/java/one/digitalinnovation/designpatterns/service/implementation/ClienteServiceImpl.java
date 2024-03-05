package one.digitalinnovation.designpatterns.service.implementation;

import one.digitalinnovation.designpatterns.model.Cliente;
import one.digitalinnovation.designpatterns.model.ClienteRepository;
import one.digitalinnovation.designpatterns.model.Endereco;
import one.digitalinnovation.designpatterns.model.EnderecoRepository;
import one.digitalinnovation.designpatterns.service.ClienteService;
import one.digitalinnovation.designpatterns.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;
    ViaCepService viaCepService;


    @Override
    public Iterable<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente searchForId(Long id) {

        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    @Override
    public void inserir(Cliente cliente) {
        salvarClienteComCep(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clienteDb = clienteRepository.findById(id);

        if(clienteDb.isPresent()){
                salvarClienteComCep(cliente);
        }
    }

    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }

    private void salvarClienteComCep(Cliente cliente){

        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() ->{
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);

        clienteRepository.save(cliente);
    }
}
