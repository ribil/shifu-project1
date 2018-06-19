package com.gmail.ribil39.repos;

import com.gmail.ribil39.domain.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepo extends CrudRepository<Message, Long> {

    Message findBySlug(String slug);
}
