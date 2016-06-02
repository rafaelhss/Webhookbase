/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bot.parser;

import bot.model.Chat;
import bot.model.Message;
import bot.model.Update;
import bot.model.User;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;


public class TelegramUpdateDeserializer implements JsonDeserializer<Update>
{
    @Override
    public Update deserialize(JsonElement je, Type type, JsonDeserializationContext jdc)
        throws JsonParseException
    {
        

        Update u = new Update();
        
        u.setUpdate_id(je.getAsJsonObject().get("update_id").getAsLong());
        // Get the "content" element from the parsed JSON
        JsonElement message = je.getAsJsonObject().get("message");
        Message m = new Message();
        
        m.setMessage_id(message.getAsJsonObject().get("message_id").getAsInt());
        m.setDate(message.getAsJsonObject().get("date").getAsLong());
        m.setText(message.getAsJsonObject().get("text").getAsString());

        User f = new User();
        
        JsonElement from = message.getAsJsonObject().get("from");
        
        f.setFirst_name(from.getAsJsonObject().get("first_name").getAsString());
        f.setLast_name(from.getAsJsonObject().get("last_name").getAsString());
        f.setId(from.getAsJsonObject().get("id").getAsInt());
        
        m.setFrom(f);
        
        
        Chat c = new Chat();
        
        JsonElement chat = message.getAsJsonObject().get("chat");
        
        c.setFirst_name(chat.getAsJsonObject().get("first_name").getAsString());
        c.setLast_name(chat.getAsJsonObject().get("last_name").getAsString());
        c.setId(chat.getAsJsonObject().get("id").getAsLong());
        c.setType(chat.getAsJsonObject().get("type").getAsString());
        
        m.setChat(c);
        
        
        u.setMessage(m);
        
        // Deserialize it. You use a new instance of Gson to avoid infinite recursion
        // to this deserializer
        return u;

    }
}