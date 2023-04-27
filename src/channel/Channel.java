package channel;

import chat.Chat;

import java.util.ArrayList;

public class Channel {
    protected String name;
    protected String channelDescription;
    protected ArrayList<Chat<?>> chatsList;

    public Channel(String name, String channelDescription){
        this.name = name;
        this.channelDescription = channelDescription;
        this.chatsList = new ArrayList<>();
    }


}
