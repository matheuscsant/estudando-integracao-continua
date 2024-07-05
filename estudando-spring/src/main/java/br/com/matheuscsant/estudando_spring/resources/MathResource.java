package br.com.matheuscsant.estudando_spring.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.matheuscsant.estudando_spring.dtos.ResponseMathDTO;
import br.com.matheuscsant.estudando_spring.services.MathService;

@RequestMapping(value = "/math")
@RestController
public class MathResource {

	@Autowired
	private MathService mathService;

	@GetMapping(value = "/sum/{numberOne}/{numberTwo}")
	public ResponseEntity<ResponseMathDTO> sum(@PathVariable String numberOne, @PathVariable String numberTwo) {
		ResponseMathDTO dto = mathService.sum(numberOne, numberTwo);
		return ResponseEntity.ok(dto);
	}

	@GetMapping(value = "/subtraction/{numberOne}/{numberTwo}")
	public ResponseEntity<ResponseMathDTO> subtraction(@PathVariable String numberOne, @PathVariable String numberTwo) {
		ResponseMathDTO dto = mathService.subtraction(numberOne, numberTwo);
		return ResponseEntity.ok(dto);
	}

	@GetMapping(value = "/multiplication/{numberOne}/{numberTwo}")
	public ResponseEntity<ResponseMathDTO> multiplication(@PathVariable String numberOne,
			@PathVariable String numberTwo) {
		ResponseMathDTO dto = mathService.multiplication(numberOne, numberTwo);
		return ResponseEntity.ok(dto);
	}

	@GetMapping(value = "/division/{numberOne}/{numberTwo}")
	public ResponseEntity<ResponseMathDTO> division(@PathVariable String numberOne, @PathVariable String numberTwo) {
		ResponseMathDTO dto = mathService.division(numberOne, numberTwo);
		return ResponseEntity.ok(dto);
	}

	@GetMapping(value = "/mean/{numberOne}/{numberTwo}")
	public ResponseEntity<ResponseMathDTO> mean(@PathVariable String numberOne, @PathVariable String numberTwo) {
		ResponseMathDTO dto = mathService.mean(numberOne, numberTwo);
		return ResponseEntity.ok(dto);
	}

	@GetMapping(value = "/squareRoot/{number}")
	public ResponseEntity<ResponseMathDTO> squareRoot(@PathVariable String number) {
		ResponseMathDTO dto = mathService.squareRoot(number);
		return ResponseEntity.ok(dto);
	}

}
