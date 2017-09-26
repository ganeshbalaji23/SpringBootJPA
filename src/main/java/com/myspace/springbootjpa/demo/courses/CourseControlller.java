package com.myspace.springbootjpa.demo.courses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myspace.springbootjpa.demo.topic.Topic;

@RestController
public class CourseControlller {
	
	@Autowired
	private CourseService courseService;
	
	/**
	 * GET method to get all the courses of a topic 
	 * @return list of courses for a topic
	 */
	@RequestMapping("topics/{id}/courses/")
	public List<Course> getAllCourses(@PathVariable String id) {
		return courseService.getCourses(id);
	}
	
	/**
	 * GET method to get a specific course
	 * @param id
	 * @return a course
	 */
	@RequestMapping("topics/{topicId}/courses/{id}")
	public Course getCourse(@PathVariable String id) {
		return courseService.getCourse(id);
	}
	
	/**
	 * POST method to add a course
	 * @param course
	 */
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.addCourse(course);
	}

	/**
	 * PUT method to update a course
	 * @param course
	 */
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course course,@PathVariable String topicId, @PathVariable String id) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(course);
	}
	
	/**
	 * DELETE method to delete a course
	 * @param id
	 */
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{id}")
	public void deleteCourse(@PathVariable String id) {
		courseService.deleteCourse(id);
	}
	
}
