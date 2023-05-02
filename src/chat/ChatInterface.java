package chat;

import sticker.Sticker;

public interface ChatInterface {
    void addSticker(Sticker sticker);
    void removeSticker(Sticker sticker);
    int calculateStickersPrice();
    int calculateCountStickers();
    int calculateCountPremiumStickers();
    int calculateCountFreeStickers();
}
