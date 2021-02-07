package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

	@Autowired
	private TopicRespository topicRepository;

	@GetMapping(path = "/topics")
	public @ResponseBody Iterable<Topic> gettopics() {
		// This returns a JSON or XML with the users
		return topicRepository.findAll();
	}

	@GetMapping(path = "/topics/{id}")
	public Topic gettopic(@PathVariable Integer id) {
		return topicRepository.findById(id).get();
	}

	@PostMapping(path = "/topics") // Map ONLY POST Requests
	public Topic addTopic(@RequestParam String title, @RequestParam String description) {
		Topic topic = new Topic();
		topic.setTitle(title);
		topic.setDescription(description);
		topicRepository.save(topic);
		return topic;
	}

	@DeleteMapping("/topics/{id}")
	private void deleteTopic(@PathVariable int id) {
		topicRepository.deleteById(id);
	}

	@PutMapping("/topics")
	private Topic update(@RequestBody Topic topic) {
		topicRepository.save(topic);
		return topic;
	}
}
