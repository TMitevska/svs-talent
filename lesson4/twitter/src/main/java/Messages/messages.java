package Messages;

import Message.Message;

import java.util.LinkedList;

public interface messages {
    void add(Message message);
    LinkedList<Message> getList();
    void list();
}
