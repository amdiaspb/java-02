package com.tweteroo.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dtos.TweetDTO;
import com.tweteroo.api.models.TweetModel;
import com.tweteroo.api.services.TweetService;

@RestController
@RequestMapping("/tweets")
public class TweetController {
    
    final TweetService tweetService;

    TweetController(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @GetMapping
    public List<TweetModel> getTweets() {
        return tweetService.findAll();
    }

    @GetMapping("/user/{userId}")
    public List<TweetModel> getTweetsByUser(@PathVariable Long userId) {
        return tweetService.findTweetById(userId);
    }


    @PostMapping
    public ResponseEntity<Object> postTweets(@RequestBody TweetDTO body) {

        Optional<TweetModel> user = tweetService.save(body);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

}
