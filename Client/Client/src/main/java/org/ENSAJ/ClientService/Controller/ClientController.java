package org.ENSAJ.ClientService.Controller;

import org.ENSAJ.ClientService.ClientApplication;
import org.ENSAJ.ClientService.Model.Client;
import org.ENSAJ.ClientService.Model.Voiture;
import org.ENSAJ.ClientService.Repository.ClientRepository;
import org.ENSAJ.ClientService.Service.ClientService;
//import org.ENSAJ.ClientService.Model.Voiture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ClientController {


    ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping("/clients")
    public List<Client> chercherClient(){
        return clientRepository.findAll();
    }

    @GetMapping("/clients/{id}")
    public Client chercherUnClient(@PathVariable Long id) throws Exception {
        return clientRepository.findById(id).orElseThrow();
    }



}
