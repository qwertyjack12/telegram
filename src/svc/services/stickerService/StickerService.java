package svc.services.stickerService;

import sticker.Sticker;

public interface StickerService {
    void saveData();
    void readData();
    boolean checkStickerId(int id);

    void setFreeSticker(int id, String name, String massage);
    void setPremiumSticker(int id, String name, String massage, int price);
    void removeSticker(int id);
    void getStickersPrice();
    void getStickers();
    Sticker getSticker(int id);
}
