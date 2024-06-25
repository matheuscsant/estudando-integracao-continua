package br.com.mathcsant.mockito.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.mathcsant.mockito.service.CourseService;
import br.com.mathcsant.mockito.service.stubs.CourseServiceStub;

class CourseBusinessStubTest {

	@Test
	void testCoursesRelatedToSpring_When_UsingAsStub() {

		// Given / Arrange
		CourseService stubService = new CourseServiceStub();
		CourseBusiness business = new CourseBusiness(stubService);

		// When / Act
		var filteredCourses = business.retriveCoursesRelatedToSpring("Matheus");

		// Then / Assert
		assertEquals(4, filteredCourses.size());
	}

	@Test
	void testCoursesRelatedToSpring_When_UsingAFooBarStudent() {

		// Given / Arrange
		CourseService stubService = new CourseServiceStub();
		CourseBusiness business = new CourseBusiness(stubService);

		// When / Act
		var filteredCourses = business.retriveCoursesRelatedToSpring("Foo Bar");

		// Then / Assert
		assertEquals(0, filteredCourses.size());
	}

}
