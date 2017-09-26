package com.myspace.springbootjpa.demo.topic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	/*private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic(1, "Spring Framework", "Spring Framework Description"),
			new Topic(2, "Java", "Java Description"),
			new Topic(3, ".Net", ".Net Framework Description")
			));*/
	
	public List<Topic> getTopics(){
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Topic getTopic(String id){
		return topicRepository.findOne(id);
	}

	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}

	public void updateTopic(String id, Topic topicNew) {
		//Topic old = topics.stream().filter(t->t.getId()==id).findFirst().get();
		topicRepository.save(topicNew);
	}

	public void deleteTopic(String id) {
		//topics.removeIf(t->t.getId()==id);
		topicRepository.delete(id);
	}
}
