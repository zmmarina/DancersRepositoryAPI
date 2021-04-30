package com.zmonteiro.dancersapi;

import org.springframework.boot.test.context.SpringBootTest;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.zmonteiro.dancersapi.document.Dancers;
import com.zmonteiro.dancersapi.repository.DancersRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import static com.zmonteiro.dancersapi.constants.DancersConstant.DANCERS_ENDPOINT_LOCAL;
import java.util.List;

@RunWith(SpringRunner.class)
@DirtiesContext
@AutoConfigureWebTestClient
@SpringBootTest
public class DancersapiApplicationTests {

	@Autowired
	WebTestClient webTestClient;

	@Autowired
	DancersRepository dancersRepository;

	@Test
	public void getOneDancerById(){

		webTestClient.get().uri(DANCERS_ENDPOINT_LOCAL.concat("/{id}"), "10")
				.exchange()
				.expectStatus().isOk()
				.expectBody();
	}

	@Test
	public void getOneDancerNotFound(){

		webTestClient.get().uri(DANCERS_ENDPOINT_LOCAL.concat("{id}"), "100")
				.exchange()
				.expectStatus().isNotFound();
	}

	@Test
	public void deletedDancer(){

		webTestClient.get().uri(DANCERS_ENDPOINT_LOCAL.concat("/{id}"), "1")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isNotFound()
				.expectBody(Void.class);
	}

}
