package svc.services.chatService;

import chat.Chat;
import sticker.Sticker;
import svc.Deserializator;
import svc.Serializator;

import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

public class ChatServiceImpl implements ChatService{
    private Hashtable<Integer, Chat> chatHashtable;
    private final String fileName = "src\\usedFiles\\Chat.txt";

    private void checkFIle(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        fileReader.close();
    }

    @Override
    public void saveData() {
        Serializator.serialization(chatHashtable, fileName);
    }

    @Override
    public void readData() {
        try {
            this.checkFIle(fileName);
            this.chatHashtable = Deserializator.getHashtable(fileName);
        } catch (IOException | ClassNotFoundException e) {
            this.chatHashtable = new Hashtable<>();
        }
    }

    @Override
    public boolean checkChatId(int id) {
        if (chatHashtable.containsKey(id)) {
            return true;
        } else {
            System.out.println("Wrong chat id input!");
            return false;
        }
    }

    @Override
    public void setChat(int id, String name) {
        chatHashtable.put(id, new Chat(name));
    }

    @Override
    public void removeChat(int id) {
        if ((chatHashtable.size() != 0) & (chatHashtable.containsKey(id))) {
            chatHashtable.remove(id);
        }
    }

    @Override
    public void setPremiumChat(int id) {
        chatHashtable.get(id).setPremiumStatus(1);
    }
    @Override
    public void setFreeChat(int id) {
        chatHashtable.get(id).setPremiumStatus(0);
    }

    @Override
    public void addSticker(int id, Sticker sticker) {
        chatHashtable.get(id).addSticker(sticker);
    }

    @Override
    public void removeSticker(int id, Sticker sticker) {
        chatHashtable.get(id).removeSticker(sticker);
    }

    @Override
    public void getChatStickerPrice() {
        for (var x: chatHashtable.keySet()){
            System.out.println(chatHashtable.get(x).getName());
            System.out.println(chatHashtable.get(x).calculateStickersPrice());
        }
    }

    @Override
    public void getChats() {
        System.out.println(chatHashtable);
    }

    @Override
    public Chat getChat(int id) {
        return chatHashtable.get(id);
    }
}
