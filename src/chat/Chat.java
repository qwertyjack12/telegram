package chat;

import sticker.Sticker;

import java.util.ArrayList;

public class Chat<T extends Sticker> implements ChatInterface<T> {
    protected String name;
    protected int premiumStatus;
    protected int countPeople;
    protected int premiumCountPeople;
    protected int freeCountPeople;
    protected ArrayList<T> stickersList;

    public Chat(String name) {
        this.name = name;
        this.premiumStatus = 0;
        this.premiumCountPeople = 250;
        this.freeCountPeople = 50;
        this.countPeople = this.freeCountPeople;
        this.stickersList = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPremiumCountPeople() {
        return this.premiumCountPeople;
    }

    public void setPremiumCountPeople(int premiumCountPeople) {
        if (premiumCountPeople > this.freeCountPeople) {
            this.premiumCountPeople = premiumCountPeople;
        }
    }

    public int getFreeCountPeople() {
        return this.freeCountPeople;
    }

    public void setFreeCountPeople(int freeCountPeople) {
        if (freeCountPeople < this.premiumCountPeople) {
            this.freeCountPeople = freeCountPeople;
        }
    }

    public int getCountPeople() {
        return this.countPeople;
    }

    public int getPremiumStatus() {
        return this.premiumStatus;
    }

    public void setPremiumStatus(int premiumStatus) {
        if (premiumStatus == 1) {
            this.countPeople = this.premiumCountPeople;
        } else if (premiumStatus == 0) {
            this.countPeople = this.freeCountPeople;
        }
        this.premiumStatus = premiumStatus;
    }

    public ArrayList<T> getStickersList() {
        return stickersList;
    }

    @Override
    public void addSticker(T sticker) {
        this.stickersList.add(sticker);
    }

    @Override
    public void removeSticker(T sticker) {
        this.stickersList.remove(sticker);
    }

    @Override
    public int calculateStickersPrice() {
        int total = 0;
        if (this.stickersList.size() == 0) {
            return total;
        }
        for (var x : this.stickersList) {
            total += x.getPrice();
        }
        return total;
    }

    @Override
    public int calculateCountStickers() {
        return this.stickersList.size();
    }

    @Override
    public int calculateCountPremiumStickers() {
        int total = 0;
        for (var x: this.stickersList){
            if (x.getPrice() != 0){
                total += 1;
            }
        }
        return total;
    }

    @Override
    public int calculateCountFreeStickers() {
        return this.calculateCountStickers() - this.calculateCountPremiumStickers();
    }

    @Override
    public String toString() {
        return switch (this.premiumStatus){
            case 1 -> "Premium chat";
            default -> "Default chat";
        };
    }
}
