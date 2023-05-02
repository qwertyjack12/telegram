package svc.services.channelService;

import chat.Chat;

public interface ChannelService {
    void saveData();
    void readData();
    boolean checkChannelId(int id);

    void setChannel(int id, String name, String channelDescription);
    void removeChannel(int id);
    void addChannelChat(int id, Chat chat);
    void removeChannelChat(int id, Chat chat);
    void getChannels();
}
