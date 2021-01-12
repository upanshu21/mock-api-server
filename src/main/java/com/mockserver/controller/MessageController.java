package com.mockserver.controller;

import com.mockserver.dao.InternalCacheImplementation;
import com.mockserver.event.Message;
import com.sun.istack.internal.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RequestMapping("mockserver")
@RestController
public class MessageController {

    @Autowired
    private InternalCacheImplementation internalCacheImplementation;

    private static final Logger logger = LoggerFactory.getLogger(MessageController.class);

    @PostMapping(value = "/insert")
    public String addMessageToList(@Valid @NotNull @RequestBody Message message) {
        logger.info("Message successfully parsed");
        return internalCacheImplementation.insertMessageInCache(message);
    }

    @GetMapping(path = "/get/{id}")
    public Optional<Message> getMessageById(@PathVariable("id") String key) {
        Optional<Message> message = Optional.ofNullable(internalCacheImplementation.getMessageById(key));
        if (!message.isPresent()) {
            logger.info("does not exist");
            return Optional.empty();
        } else {
            logger.info("Message with key {} found", key);
            return message;
        }
    }
}
