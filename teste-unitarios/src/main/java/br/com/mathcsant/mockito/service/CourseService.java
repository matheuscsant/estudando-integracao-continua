package br.com.mathcsant.mockito.service;

import java.util.List;

public interface CourseService {

	public List<String> retriveCourses(String student);

	public List<String> doSomething(String student);

	public void deleteCourse(String course);

}
