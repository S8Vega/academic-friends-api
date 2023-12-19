package co.com.ufps.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HealthRestTest {

    HealthRest healthRest = new HealthRest();

    @Test
    void apiRestTest() {
        var response = healthRest.health();
        assertEquals("Hello World", response);
    }
}
