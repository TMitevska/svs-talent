package Messages;

import Message.Message;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
@Component
public class Messages implements messages{
    private LinkedList<Message> list;
    public Messages(){list=new LinkedList<Message>();}
    public void add(Message message){list.add(message);}
    public LinkedList<Message> getList(){return this.list;}
    public void list(){

        for(int i=list.indexOf(list.getLast());i!=-1;i--)
        {
            Message message=list.get(i);
            System.out.println(message.display());
        }

    }
}
