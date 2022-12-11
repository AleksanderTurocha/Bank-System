package turocha.aleksander.banksystem.service;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.stereotype.Service;
import turocha.aleksander.banksystem.dao.ClientDao;
import turocha.aleksander.banksystem.entity.dto.client.ClientMapper;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@Service
class ClientServiceTest {

    @Mock
    private ClientDao clientDao;
    @Mock
    private ClientMapper clientMapper;
    private ClientService underTest;
//    private AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
//        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new ClientService(clientDao, clientMapper);
    }
    @AfterEach
    void tearDown() throws Exception {
//        autoCloseable.close();
    }

    @Test
    void getClients() {
        // when
        underTest.getClients();
        // then
        verify(clientDao).findAll();
    }

    @Test
    void addClient() {
    }

    @Test
    void getClientById() {
    }
}