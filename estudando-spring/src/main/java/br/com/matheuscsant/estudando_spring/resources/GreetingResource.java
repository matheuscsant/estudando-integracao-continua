package br.com.matheuscsant.estudando_spring.resources;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.matheuscsant.estudando_spring.models.Greeting;

@RestController
@RequestMapping(value = "/greeting")
public class GreetingResource {

	private final AtomicLong counter = new AtomicLong();

	@GetMapping
	public ResponseEntity<Greeting> getAnyGreeting(
			@RequestParam(defaultValue = "World") String content) {

		var teste = new Greeting.GreetingBuilder(counter.incrementAndGet(), content).setOptionalContent("Optional content")
				.build();
		return ResponseEntity.ok(teste);
	}

}
