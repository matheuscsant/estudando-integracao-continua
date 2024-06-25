package br.com.mathcsant.mockito.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;

public class ListTest {

	@Test
	void testMockingList_When_SizeIsCalled_ShouldReturn10() {

		// Given / Arrange
		List<?> list = mock(List.class);
		when(list.size()).thenReturn(10);

		// When / Act and Then / Assert
		assertEquals(10, list.size());
		assertEquals(10, list.size());
		assertEquals(10, list.size());
	}

	@Test
	void testMockingList_When_SizeIsCalled_ShouldReturnMultipleValues() {

		// Given / Arrange
		List<?> list = mock(List.class);
		when(list.size()).thenReturn(10).thenReturn(20).thenReturn(30);

		// When / Act and Then / Assert
		assertEquals(10, list.size());
		assertEquals(20, list.size());
		assertEquals(30, list.size());
	}

	@Test
	void testMockingList_When_GetIsCalled_ShouldReturnMatheus() {

		// Given / Arrange
		var list = mock(List.class);
		when(list.get(0)).thenReturn("Matheus");

		// When / Act and Then / Assert
		assertEquals("Matheus", list.get(0));
		assertNull(list.get(1)); // Dados não mockados viram null
	}

	@Test
	void testMockingList_When_GetIsCalledWithArgumentMatcher_ShouldReturnMatheus() {

		// Given / Arrange
		var list = mock(List.class);
		when(list.get(anyInt())).thenReturn("Matheus"); // Argument Matchers

		// When / Act and Then / Assert
		assertEquals("Matheus", list.get(anyInt()));
		assertEquals("Matheus", list.get(anyInt())); // Dados não mockados viram null
	}

	@Test
	void testMockingList_When_ThrowsAnException_() {

		// Given / Arrange
		var list = mock(List.class);
		when(list.get(anyInt())).thenThrow(new RuntimeException("Foo Bar")); // Mock de exception

		// When / Act and Then / Assert
		assertThrows(RuntimeException.class, () -> list.get(anyInt()), () -> "Should habe throw an RuntimeException");
	}

}
