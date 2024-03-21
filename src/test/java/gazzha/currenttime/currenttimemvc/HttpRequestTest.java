package gazzha.currenttime.currenttimemvc;


import gazzha.currenttime.currenttimemvc.dto.Message;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.time.Instant;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {


    private final static String currentDate = LocalDate.now().toString();

    private final static String currentTimeZone = "Europe/Moscow";

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testGettingCurrentTime() {
        assertEquals(this.restTemplate.getForObject("http://localhost:" + port + "/api/time",
                Message.class).date(), currentDate);
    }
    @Test
    void testGettingCurrentTimeZone() {
        assertEquals(this.restTemplate.getForObject("http://localhost:" + port + "/api/time",
                Message.class).timezone(), currentTimeZone);
    }
    @Test
    void testVerifyNotNull() {
        Assertions.assertNotNull(this.restTemplate.getForObject("http://localhost:" + port + "/api/time",
                Message.class));
    }
}
