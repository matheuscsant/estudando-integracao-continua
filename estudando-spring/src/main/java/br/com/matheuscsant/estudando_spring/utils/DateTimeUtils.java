package br.com.matheuscsant.estudando_spring.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {

	private final static DateTimeFormatter brazillianLocalDateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

	/**
	 * Método utilizado para transformar um LocalDateTime em uma String no formato
	 * brasileiro
	 * 
	 * <pre>
	 * DateTimeUtils.localDateTimeToBrazillianLocalDateTime(LocalDateTime.now())
	 * // 27/06/2024 15:50
	 * </pre>
	 * 
	 * @param dateTime LocalDateTime que será passado para o formato brasileiro
	 * @return String do dateTime formatado
	 */
	public static String localDateTimeToBrazillianLocalDateTime(LocalDateTime dateTime) {
		return brazillianLocalDateTime.format(dateTime);
	}

}
