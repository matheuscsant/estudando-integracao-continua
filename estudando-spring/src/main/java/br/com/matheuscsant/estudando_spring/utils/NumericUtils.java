package br.com.matheuscsant.estudando_spring.utils;

public class NumericUtils {

	public static boolean isNumeric(String strNumber) {
		return strNumber.matches("[-+]?[0-9]*\\.?[0-9]+");
	}

}
