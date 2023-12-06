package org.ENSAJ.ClientService.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "SERVICE-VOITURE")
public interface VoitureClientRest {
//    @GetMapping("/clients/{id}")

}
