package turocha.aleksander.banksystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import turocha.aleksander.banksystem.entity.dto.client.InputClientDto;
import turocha.aleksander.banksystem.entity.Client;
import turocha.aleksander.banksystem.entity.dto.client.OutputClientDto;
import turocha.aleksander.banksystem.service.ClientService;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
public class ClientController {
    private final ClientService clientService;

    @GetMapping("/get-all")
    public List<Client> getClients() {
        return clientService.getClients();
    }

    @GetMapping("/get-by-Id/{id}")
    public ResponseEntity<Client> getClientById(@RequestParam Long id) {
        return clientService.getClientById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add-client")
    public ResponseEntity<OutputClientDto> addClient(@RequestBody InputClientDto inputClientDto) {
        OutputClientDto savedClient = clientService.addClient(inputClientDto);
        URI savedClientUri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedClient.getId())
                .toUri();
        return ResponseEntity.created(savedClientUri).body(savedClient);
    }

}
