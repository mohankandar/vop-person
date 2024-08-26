package com.wynd.vop.person;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
    properties = {"vop.framework.security.http.cors.enabled=true",
        "vop-person.or-ig-ins=https://vop-person-ui-dev.corproot.com"})
public class PersonServiceApplicationTests {


  @Autowired
  private TestRestTemplate restTemplate;


  @Test
  public void contextLoads() {
  }

  @Test
  public void exampleTest() {
    String body = this.restTemplate.getForObject("/swagger-ui.html", String.class);
    assertThat(body).contains("Swagger UI");
  }

}
