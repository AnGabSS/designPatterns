package one.digitalinnovation.designpatterns.service;

import one.digitalinnovation.designpatterns.model.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ViaCep", url = "https://viacep.com.br/ws")
public interface ViaCepService {

    @GetMapping("/{cep}/json")
    Endereco consultarCep(@PathVariable("cep") String cep);
}
