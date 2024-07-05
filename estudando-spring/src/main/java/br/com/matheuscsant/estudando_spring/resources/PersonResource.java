package br.com.matheuscsant.estudando_spring.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.matheuscsant.estudando_spring.models.Person;
import br.com.matheuscsant.estudando_spring.services.PersonService;

@RequestMapping(value = "/person")
@RestController
public class PersonResource {

	@Autowired
	private PersonService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Person> findPersonById(@PathVariable String id) {
		var person = service.findById(id);
		return ResponseEntity.ok(person);
	}

	@GetMapping
	public ResponseEntity<List<Person>> findAllPerson() {
		var persons = service.findAll();
		return ResponseEntity.ok(persons);
	}

	@PostMapping
	public ResponseEntity<Void> createPerson(@RequestBody Person person) {
		Long newId = service.createPerson(person);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("person/{id}").buildAndExpand(newId).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping
	public ResponseEntity<Person> updatePerson(@RequestBody Person person) {
		var updatedPerson = service.updatePerson(person);
		return ResponseEntity.ok(updatedPerson);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
		service.deletePerson(id);
		return ResponseEntity.noContent().build();
	}

}
