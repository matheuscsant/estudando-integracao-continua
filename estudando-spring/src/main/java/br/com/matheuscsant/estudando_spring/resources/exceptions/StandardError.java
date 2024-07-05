package br.com.matheuscsant.estudando_spring.resources.exceptions;

import java.io.Serializable;

public record StandardError(String moment, Integer status, String error, String uri, String description) implements Serializable {

}
