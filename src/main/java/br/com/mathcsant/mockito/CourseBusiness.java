package br.com.mathcsant.mockito;

import java.util.ArrayList;
import java.util.List;

import br.com.mathcsant.mockito.service.CourseService;

// SUT - System (Method) Under Test
public class CourseBusiness {

	// CourseService is a Dependecy
	private CourseService service;

	public CourseBusiness(CourseService service) {
		this.service = service;
	}

	public List<String> retriveCoursesRelatedToSpring(String student) {

		var filteredCourses = new ArrayList<String>();
		var allCourses = service.retriveCourses("");

		for (String course : allCourses) {
			if (course.contains("Spring"))
				filteredCourses.add(course);
		}

		return filteredCourses;
	}

}
