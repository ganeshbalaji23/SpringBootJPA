package com.myspace.springbootjpa.demo.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicControlller {
	
	@Autowired
	private TopicService topicService;
	
	/**
	 * GET method to get all the topics 
	 * @return list of topics
	 */
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getTopics();
	}
	
	/**
	 * GET method to get a specific topic
	 * @param id
	 * @return a topic
	 */
	@RequestMapping("topics/{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}
	
	/**
	 * POST method to add a topic
	 * @param topic
	 */
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}

	/**
	 * PUT method to update a topic
	 * @param topic
	 */
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicService.updateTopic(id, topic);
	}
	
	/**
	 * DELETE method to delete a topic
	 * @param id
	 */
	@RequestMapping(method=RequestMethod.DELETE, value="topics/{id}")
	public void deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
	}
	
}
