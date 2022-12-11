package turocha.aleksander.banksystem.entity.dto.client;

import org.springframework.stereotype.Service;
import turocha.aleksander.banksystem.entity.Client;

@Service
public class ClientMapper {
    public Client mapInputClientToClient(InputClientDto inputClientDto){
        Client client = new Client();
        client.setFirstName(inputClientDto.getFirstName());
        client.setLastName(inputClientDto.getLastName());
        client.setAge(inputClientDto.getAge());
        return client;
    }

    public OutputClientDto mapClientToOutputClient(Client client){
        OutputClientDto outputClientDto = new OutputClientDto();
        outputClientDto.setId(client.getId());
        outputClientDto.setFirstName(client.getFirstName());
        outputClientDto.setLastName(client.getLastName());
        outputClientDto.setAge(client.getAge());
        return outputClientDto;
    }
}
