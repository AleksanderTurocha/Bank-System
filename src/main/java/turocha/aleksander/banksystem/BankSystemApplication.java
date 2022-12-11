package turocha.aleksander.banksystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BankSystemApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BankSystemApplication.class, args);
        TestData testData = context.getBean(TestData.class);
        testData.createTestData();
    }

}
