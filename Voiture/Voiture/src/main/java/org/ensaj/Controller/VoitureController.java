package org.ensaj.Controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.ensaj.Client;
import org.ensaj.Model.Voiture;
import org.ensaj.Repository.VoitureRepository;
import org.ensaj.Service.VoitureService;
import org.ensaj.clients.ClientRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VoitureController {


    VoitureRepository voitureRepository;


    VoitureService voitureService;

    ClientRest clientRest;

    public VoitureController(VoitureRepository voitureRepository, VoitureService voitureService, ClientRest clientRest) {
        this.voitureRepository = voitureRepository;
        this.voitureService = voitureService;
        this.clientRest = clientRest;
    }

    @GetMapping(value ="/voitures")
    public List<Voiture> chercherVoiture(){
        return voitureRepository.findAll();
    }

    @GetMapping("/voitures/{Id}")
    public Voiture chercherUneVoiture(@PathVariable Long Id) throws Exception{
        Voiture voiture = voitureRepository.findById(Id).get();
        Client client = clientRest.findClientByID(voiture.getClientId());
        voiture.setClient(client);
        return voiture;
     }


    @PostMapping("/voitures")
    public Voiture enregistrerUneVoiture(@RequestBody Voiture voiture){
        return voitureService.enregistrerVoiture(voiture);
    }



}
