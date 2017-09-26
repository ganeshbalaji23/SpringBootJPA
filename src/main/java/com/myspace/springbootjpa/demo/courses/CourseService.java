package com.myspace.springbootjpa.demo.courses;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	/*private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic(1, "Spring Framework", "Spring Framework Description"),
			new Topic(2, "Java", "Java Description"),
			new Topic(3, ".Net", ".Net Framework Description")
			));*/
	
	public List<Course> getCourses(String topicId){
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId).forEach(courses::add);
		return courses;
	}
	
	public Course getCourse(String id){
		return courseRepository.findOne(id);
	}

	public void addCourse(Course course) {
		courseRepository.save(course);
	}

	public void updateCourse(Course newCourse) {
		//Topic old = topics.stream().filter(t->t.getId()==id).findFirst().get();
		courseRepository.save(newCourse);
	}

	public void deleteCourse(String id) {
		//topics.removeIf(t->t.getId()==id);
		courseRepository.delete(id);
	}
}
