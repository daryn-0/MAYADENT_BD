package com.mayadent.MAYADENTBD.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NotificacionDto {
    private String title;
    private String message;
    private String type;
    private String recipientRole;
    private Long recipientId;
    public NotificacionDto(String title, String message, String type, String recipientRole, Long recipientId) {
        this.title = title;
        this.message = message;
        this.type = type;
        this.recipientRole = recipientRole;
        this.recipientId = recipientId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getRecipientRole() {
        return recipientRole;
    }
    public void setRecipientRole(String recipientRole) {
        this.recipientRole = recipientRole;
    }
    public Long getRecipientId() {
        return recipientId;
    }
    public void setRecipientId(Long recipientId) {
        this.recipientId = recipientId;
    }
}
