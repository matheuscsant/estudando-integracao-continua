package br.com.matheuscsant.estudando_spring.dtos;

import java.io.Serializable;

public record ResponseMathDTO(String message, Double result) implements Serializable {
}
