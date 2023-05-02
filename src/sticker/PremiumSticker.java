package sticker;

import java.io.Serializable;

public class PremiumSticker extends Sticker implements Serializable {
    public PremiumSticker(String name, String message, int price) {
        super(name, message);
        this.price = price;
    }
    public void setPrice(int price){
        if (price != 0){
            this.price = price;
        }
    }

    @Override
    public void stickerStatus() {
        System.out.println("This sticker is premium");
    }

    @Override
    public String toString() {
        return this.name + " " + this.message + " " + this.price;
    }

    @Override
    public int hashCode() {
        int result = 19;
        result = 29 * result + this.name.hashCode();
        result = 29 * result + this.message.hashCode();
        result = 29 * result + this.price;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        return this.hashCode() == obj.hashCode();
    }
}
