package br.com.mathcsant.mockito.business;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.util.List;

import org.junit.jupiter.api.Test;

public class ListWithBDDTest {

	@Test
	void testMockingList_When_SizeIsCalled_ShouldReturn10() {

		// Given / Arrange
		List<?> list = mock(List.class);
		given(list.size()).willReturn(10);

		// When / Act and Then / Assert
		assertThat(list.size(), is(10));
		assertThat(list.size(), is(10));
		assertThat(list.size(), is(10));
	}

	@Test
	void testMockingList_When_SizeIsCalled_ShouldReturnMultipleValues() {

		// Given / Arrange
		List<?> list = mock(List.class);
		given(list.size()).willReturn(10).willReturn(20).willReturn(30);

		// When / Act and Then / Assert
		assertThat(list.size(), is(10));
		assertThat(list.size(), is(20));
		assertThat(list.size(), is(30));
	}

	@Test
	void testMockingList_When_GetIsCalled_ShouldReturnMatheus() {

		// Given / Arrange
		var list = mock(List.class);
		given(list.get(0)).willReturn("Matheus");

		// When / Act and Then / Assert
		assertThat(list.get(0), is("Matheus"));
		assertThat(list.get(1), is(nullValue())); // Dados não mockados viram null
	}

	@Test
	void testMockingList_When_GetIsCalledWithArgumentMatcher_ShouldReturnMatheus() {

		// Given / Arrange
		var list = mock(List.class);
		given(list.get(anyInt())).willReturn("Matheus"); // Argument Matchers

		// When / Act and Then / Assert
		assertThat(list.get(anyInt()), is("Matheus"));
		assertThat(list.get(anyInt()), is("Matheus")); // Dados não mockados viram null
	}

	@Test
	void testMockingList_When_ThrowsAnException_() {

		// Given / Arrange
		var list = mock(List.class);
		given(list.get(anyInt())).willThrow(new RuntimeException("Foo Bar")); // Mock de exception

		// When / Act and Then / Assert
		assertThrows(RuntimeException.class, () -> list.get(anyInt()), () -> "Should habe throw an RuntimeException");
	}

}
