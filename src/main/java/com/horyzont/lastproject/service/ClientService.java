package com.horyzont.lastproject.service;

import ch.qos.logback.core.net.server.Client;
import com.horyzont.lastproject.dao.ClientDao;
import com.horyzont.lastproject.entities.ClientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientDao clientDao;

    public String deleteClient(Integer id) {
        ClientEntity entity = new ClientEntity();
        entity.setId(id);
        clientDao.delete(entity);
        return "client deleted";
    }
    //look how to return client deleted

    public ClientEntity register(String client_name, String email){
       ClientEntity entity = new ClientEntity();
       entity.setClient_name(client_name);
       entity.setEmail(email);
       clientDao.save(entity);
       return  entity;
   }

   public List<ClientEntity> getAllClients(){
        return clientDao.findAll();
   }
}
