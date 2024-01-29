package com.tweteroo.api.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.api.dtos.TweetDTO;
import com.tweteroo.api.models.TweetModel;
import com.tweteroo.api.models.UserModel;
import com.tweteroo.api.repositories.TweetRepository;
import com.tweteroo.api.repositories.UserRepository;

@Service
public class TweetService {
    
    @Autowired private TweetRepository tweetRepository;
    @Autowired private UserRepository userRepository;

    public List<TweetModel> findAll() {
        return tweetRepository.findAll();
    }

    public List<TweetModel> findTweetById(Long id) {
        System.out.println(id);
        return tweetRepository.findByUserId(id);
    }

    public Optional<TweetModel> save(TweetDTO dto) {
        Optional<UserModel> user = userRepository.findById(dto.getId());
        UserModel userAprove = user.orElseThrow(() -> new NoSuchElementException("Usuário não encontrado"));
        return Optional.of(tweetRepository.save(new TweetModel(dto, userAprove)));
    }
}
