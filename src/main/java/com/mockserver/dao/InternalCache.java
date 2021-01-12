package com.mockserver.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mockserver.event.Message;

public interface InternalCache {

    String insertMessageInCache(Message message);

    Message getMessageById(String previousMessageId) throws JsonProcessingException;
}
