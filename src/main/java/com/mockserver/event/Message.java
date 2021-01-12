package com.mockserver.event;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Message {

    private final String templateId;
    private final String tenantId;
    private final String conversationId;
    private final String previousMessageId;
    private final List<String> members;
    private final String message;

    public Message(@JsonProperty("templatedId") String templateId,
                   @JsonProperty("tenantId") String tenantId,
                   @JsonProperty("conversationId") String conversationId,
                   @JsonProperty("previousMessageId") String previousMessageId,
                   @JsonProperty("members") List<String> members,
                   @JsonProperty("message") String message) {
        this.templateId = templateId;
        this.tenantId = tenantId;
        this.conversationId = conversationId;
        this.previousMessageId = previousMessageId;
        this.members = members;
        this.message = message;
    }

    public String getTemplateId() {
        return templateId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public String getConversationId() {
        return conversationId;
    }

    public String getPreviousMessageId() {
        return previousMessageId;
    }

    public List<String> getMembers() {
        return members;
    }

    public String getMessage() {
        return message;
    }
}
