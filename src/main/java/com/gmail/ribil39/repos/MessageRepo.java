package com.gmail.ribil39.repos;

import com.gmail.ribil39.domain.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface MessageRepo extends CrudRepository<Message, Long> {

    Message findBySlug(String slug);

    Message findById(Integer id);



    @Transactional
    void deleteBySlug(String s);

}
