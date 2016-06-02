package bot.model;

import java.io.Serializable;
import java.util.Arrays;

/**
 * stas
 * 8/4/15.
 */
public class Message  implements Serializable  {

    public Integer message_id;
    public User from;
    public Long date;
    public Chat chat;
    public String text;

    public Integer getMessage_id() {
        return message_id;
    }

    public void setMessage_id(Integer message_id) {
        this.message_id = message_id;
    }

    public User getFrom() {
        return from;
    }

    public void setFrom(User from) {
        this.from = from;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    
    

}
