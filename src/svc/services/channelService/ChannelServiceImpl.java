package svc.services.channelService;

import channel.Channel;
import chat.Chat;
import svc.Deserializator;
import svc.Serializator;

import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

public class ChannelServiceImpl implements ChannelService{
    private Hashtable<Integer, Channel> channelHashtable;
    private final String fileName = "src\\usedFiles\\Channel.txt";

    private void checkFIle(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        fileReader.close();
    }

    @Override
    public void saveData() {
        Serializator.serialization(channelHashtable, fileName);
    }

    @Override
    public void readData() {
        try {
            this.checkFIle(fileName);
            this.channelHashtable = Deserializator.getHashtable(fileName);
        } catch (IOException | ClassNotFoundException e) {
            this.channelHashtable = new Hashtable<>();
        }
    }

    @Override
    public boolean checkChannelId(int id) {
        if (channelHashtable.containsKey(id)) {
            return true;
        } else {
            System.out.println("Wrong channel id input!");
            return false;
        }
    }

    @Override
    public void setChannel(int id, String name, String channelDescription) {
        channelHashtable.put(id, new Channel(name, channelDescription));
    }

    @Override
    public void removeChannel(int id) {
        if ((channelHashtable.size() != 0) & (channelHashtable.containsKey(id))) {
            channelHashtable.remove(id);
        }
    }

    @Override
    public void addChannelChat(int id, Chat chat) {
        channelHashtable.get(id).addChat(chat);
    }

    @Override
    public void removeChannelChat(int id, Chat chat) {
        channelHashtable.get(id).removeChat(chat);
    }

    @Override
    public void getChannels() {
        System.out.println(channelHashtable);
    }
}
