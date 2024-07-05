package br.com.matheuscsant.estudando_spring.services;

import org.springframework.stereotype.Service;

import br.com.matheuscsant.estudando_spring.dtos.ResponseMathDTO;
import br.com.matheuscsant.estudando_spring.utils.NumericUtils;

@Service
public class MathService {

	public ResponseMathDTO sum(String numberOne, String numberTwo) {
		if (!NumericUtils.isNumeric(numberOne) || !NumericUtils.isNumeric(numberTwo))
			throw new NumberFormatException("Parâmetros inválidos");
		return new ResponseMathDTO("Sucesso na soma", Double.parseDouble(numberOne) + Double.parseDouble(numberTwo));
	}

	public ResponseMathDTO subtraction(String numberOne, String numberTwo) {
		if (!NumericUtils.isNumeric(numberOne) || !NumericUtils.isNumeric(numberTwo))
			throw new NumberFormatException("Parâmetros inválidos");
		return new ResponseMathDTO("Sucesso na subtração", Double.parseDouble(numberOne) - Double.parseDouble(numberTwo));
	}

	public ResponseMathDTO multiplication(String numberOne, String numberTwo) {
		if (!NumericUtils.isNumeric(numberOne) || !NumericUtils.isNumeric(numberTwo))
			throw new NumberFormatException("Parâmetros inválidos");
		return new ResponseMathDTO("Sucesso na multiplicação",
				Double.parseDouble(numberOne) * Double.parseDouble(numberTwo));
	}

	public ResponseMathDTO division(String numberOne, String numberTwo) {
		if (!NumericUtils.isNumeric(numberOne) || !NumericUtils.isNumeric(numberTwo))
			throw new NumberFormatException("Parâmetros inválidos");

		double firstNum = Double.parseDouble(numberOne);
		double secondNum = Double.parseDouble(numberTwo);

		if (firstNum == 0 || secondNum == 0)
			throw new ArithmeticException("Não é possível realizar a divisão por zero");

		return new ResponseMathDTO("Sucesso na divisão", firstNum / secondNum);
	}

	public ResponseMathDTO mean(String numberOne, String numberTwo) {
		if (!NumericUtils.isNumeric(numberOne) || !NumericUtils.isNumeric(numberTwo))
			throw new NumberFormatException("Parâmetros inválidos");
		return new ResponseMathDTO("Sucesso na realização da média",
				(Double.parseDouble(numberOne) + Double.parseDouble(numberTwo)) / 2);
	}

	public ResponseMathDTO squareRoot(String number) {
		if (!NumericUtils.isNumeric(number))
			throw new NumberFormatException("Parâmetros inválidos");
		return new ResponseMathDTO("Sucesso na extração da raiz quadrada", Math.sqrt(Double.parseDouble(number)));
	}

}
