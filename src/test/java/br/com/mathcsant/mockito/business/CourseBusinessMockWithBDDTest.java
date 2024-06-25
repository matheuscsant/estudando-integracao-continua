package br.com.mathcsant.mockito.business;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import br.com.mathcsant.mockito.service.CourseService;

// Utilizando o hamcrest
class CourseBusinessMockWithBDDTest {

	CourseService mockService;
	CourseBusiness business;
	List<String> courses;

	@BeforeEach
	void setup() {
		// Given / Arrange
		mockService = mock(CourseService.class);
		business = new CourseBusiness(mockService);
		courses = Arrays.asList("REST API's RESTFul do 0 à Azure com ASP.NET Core 5 e Docker",
				"Agile Desmistificado com Scrum, XP, Kanban e Trello", "Spotify Engineering Culture Desmistificado",
				"REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker",
				"Docker do Zero à Maestria - Contêinerização Desmistificada",
				"Docker para Amazon AWS Implante Apps Java e .NET com Travis CI",
				"Microsserviços do 0 com Spring Cloud, Spring Boot e Docker",
				"Arquitetura de Microsserviços do 0 com ASP.NET, .NET 6 e C#",
				"REST API's RESTFul do 0 à AWS com Spring Boot 3 Kotlin e Docker",
				"Kotlin para DEV's Java: Aprenda a Linguagem Padrão do Android",
				"Microsserviços do 0 com Spring Cloud, Kotlin e Docker");
	}

	@Test
	void testCoursesRelatedToSpring_When_UsingAMock() {

		// Given / Arrange
		given(mockService.retriveCourses("Matheus")).willReturn(courses);

		// When / Act
		var filteredCourses = business.retriveCoursesRelatedToSpring("Matheus");

		// Then / Assert
		assertThat(filteredCourses.size(), is(4));
	}

	// test[System Under Test]_[Condition or State Change_[Expected Result]
	@DisplayName("Delete Courses not Related to Spring Using Mockito sould call Method")
	@Test
	void testDleteCoursesNotRelatedToSpring_UsinMockitoVerify_Should_CallMethodDeleteCourse() {

		// Given / Arrange
		given(mockService.retriveCourses("Matheus")).willReturn(courses);

		// When / Act
		business.deleteCoursesNotRelatedToSpring("Matheus");

		// Then / Assert
//		verify(mockService).deleteCourse("Agile Desmistificado com Scrum, XP, Kanban e Trello");
//		verify(mockService).deleteCourse("Docker do Zero à Maestria - Contêinerização Desmistificada");
//		verify(mockService, times(1)).deleteCourse("Agile Desmistificado com Scrum, XP, Kanban e Trello");
//		verify(mockService, atLeast(1)).deleteCourse("Agile Desmistificado com Scrum, XP, Kanban e Trello");
		verify(mockService).deleteCourse("Kotlin para DEV's Java: Aprenda a Linguagem Padrão do Android");
		verify(mockService, never()).deleteCourse("REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker");
		verify(mockService, atLeastOnce()).deleteCourse("Agile Desmistificado com Scrum, XP, Kanban e Trello");
		verify(mockService, times(1)).deleteCourse("Docker do Zero à Maestria - Contêinerização Desmistificada");
	}

	// test[System Under Test]_[Condition or State Change_[Expected Result]
	@DisplayName("Delete Courses not Related to Spring Using Mockito sould call Method V2")
	@Test
	void testDleteCoursesNotRelatedToSpring_UsinMockitoVerify_Should_CallMethodDeleteCourseV2() {

		// Given / Arrange
		given(mockService.retriveCourses("Matheus")).willReturn(courses);

		String agileCourse = "Agile Desmistificado com Scrum, XP, Kanban e Trello";
		String springCourse = "REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker";
		String dockerCourse = "Docker do Zero à Maestria - Contêinerização Desmistificada";
		String kotlinCourse = "Kotlin para DEV's Java: Aprenda a Linguagem Padrão do Android";

		// When / Act
		business.deleteCoursesNotRelatedToSpring("Matheus");

		// Then / Assert
		then(mockService).should().deleteCourse(kotlinCourse);
		then(mockService).should(never()).deleteCourse(springCourse);
		then(mockService).should(atLeastOnce()).deleteCourse(agileCourse);
		then(mockService).should(times(1)).deleteCourse(dockerCourse);
	}

	// test[System Under Test]_[Condition or State Change_[Expected Result]
	@DisplayName("Delete Courses not Related to Spring Capturing Arguments sould call Method")
	@Test
	void testDleteCoursesNotRelatedToSpring_CapturingArguments_Should_CallMethodDeleteCourseV2() {

		// Given / Arrange
//		courses = Arrays.asList("Agile Desmistificado com Scrum, XP, Kanban e Trello",
//				"REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker");

		given(mockService.retriveCourses("Matheus")).willReturn(courses);

		ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);

//		String agileCourse = "Agile Desmistificado com Scrum, XP, Kanban e Trello";

		// When / Act
		business.deleteCoursesNotRelatedToSpring("Matheus");

		// Then / Assert
		then(mockService).should(times(7)).deleteCourse(argumentCaptor.capture());
		assertThat(argumentCaptor.getAllValues().size(), is(7));
	}

}
