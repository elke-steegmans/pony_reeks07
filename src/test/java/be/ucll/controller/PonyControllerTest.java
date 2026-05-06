package be.ucll.controller;

import be.ucll.repository.DBInitializer;
import be.ucll.repository.PonyRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
@Sql("classpath:schema.sql")
public class PonyControllerTest {

    private WebTestClient client;
    private PonyRepository ponyRepository;
    private DBInitializer dbInitializer;

    @Autowired
    public PonyControllerTest(WebTestClient client, PonyRepository ponyRepository, DBInitializer dbInitializer) {
        this.ponyRepository = ponyRepository;
        this.client = client;
        this.dbInitializer = dbInitializer;
    }

    //@AfterEach
    @BeforeEach
    public void resetData() {
        dbInitializer.initialize();
        //ponyRepository.reset();
    }

    @Test
    public void given2Ponies_whenPostNewPony_thenReturnNewPonyInJsonFormat() {
        client.post()
                .uri("/pony")
                .header("Content-Type", "application/json")
                .bodyValue("{\n" +
                        "        \"name\": \"Unicorn\",\n" +
                        "        \"age\": 12\n" +
                        "}")
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBody()
                .json("{\n" +
                        "        \"name\": \"Unicorn\",\n" +
                        "        \"age\": 12\n" +
                        "}");
        assertEquals("Unicorn", ponyRepository.findByName("Unicorn").get().getName());
    }

    @Test
    public void given2Ponies_whenGetPony_then2PoniesReturnedInJsonFormat () {
        client.get()
                .uri("/pony")
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBody()
                .json("""
                        [
                            {
                                "name": "Bella",
                                "age": 5
                            },
                            {
                                "name": "Luna",
                                "age": 7
                            }
                        ]
                """);
    }

}
