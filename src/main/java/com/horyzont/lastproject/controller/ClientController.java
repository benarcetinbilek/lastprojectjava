package com.horyzont.lastproject.controller;

import ch.qos.logback.core.net.server.Client;
import com.horyzont.lastproject.entities.ClientEntity;
import com.horyzont.lastproject.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/register/{client_name}/{email}")
    public ClientEntity register(@PathVariable String client_name, @PathVariable String email) {
        return clientService.register(client_name,email);
    }

    @GetMapping("/deleteClient/{id}")
    public void deleteClient(@PathVariable Integer id){
         clientService.deleteClient(id);

    }

    @GetMapping("/getAll")
    public List<ClientEntity> getAllClients() {
        return clientService.getAllClients();
    }
}
