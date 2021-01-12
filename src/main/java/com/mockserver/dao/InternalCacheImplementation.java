package com.mockserver.dao;

import com.mockserver.event.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class InternalCacheImplementation implements InternalCache {

    private static final Logger logger = LoggerFactory.getLogger(InternalCacheImplementation.class);
    private static final HashMap<String,Message> messagePayload = new HashMap<>();
    private static final String success = "SUCCESS";

    @Override
    public String insertMessageInCache(Message message) {
        messagePayload.put(message.getMembers().get(0), message);
        messagePayload.put(message.getMembers().get(1), message);
        logger.info("message saved in cache");
        return success;
    }

    @Override
    public Message getMessageById(String key) {
        return messagePayload.get(key);
    }
}
