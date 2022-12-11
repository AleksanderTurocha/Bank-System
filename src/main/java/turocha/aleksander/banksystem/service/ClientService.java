package turocha.aleksander.banksystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import turocha.aleksander.banksystem.dao.ClientDao;
import turocha.aleksander.banksystem.entity.dto.client.ClientMapper;
import turocha.aleksander.banksystem.entity.dto.client.InputClientDto;
import turocha.aleksander.banksystem.entity.Client;
import turocha.aleksander.banksystem.entity.dto.client.OutputClientDto;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientDao clientDao;
    private final ClientMapper clientMapper;

    public List<Client> getClients(){
        return clientDao.findAll();
    }

    @Transactional
    public OutputClientDto addClient(InputClientDto inputClientDto) {
        Client savedClient = clientDao.save(clientMapper.mapInputClientToClient(inputClientDto));
        return clientMapper.mapClientToOutputClient(savedClient);
    }

    public Optional<Client> getClientById(Long id) {
        return clientDao.findById(id);
    }
}
