package svc.services.chatService;

import chat.Chat;
import sticker.Sticker;

public interface ChatService {
    void saveData();
    void readData();
    boolean checkChatId(int id);

    void setChat(int id, String name);
    void removeChat(int id);
    void setPremiumChat(int id);
    void setFreeChat(int id);
    void addSticker(int id, Sticker sticker);
    void removeSticker(int id, Sticker sticker);
    void getChatStickerPrice();
    void getChats();
    Chat getChat(int id);
}
