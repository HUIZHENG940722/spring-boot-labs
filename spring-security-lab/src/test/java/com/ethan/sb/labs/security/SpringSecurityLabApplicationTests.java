package com.ethan.sb.labs.security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringSecurityLabApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void hello() {
        restTemplate.getForObject("/hello", String.class);
    }
}
