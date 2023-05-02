package sticker;

import java.io.Serializable;

public class FreeSticker extends Sticker implements Serializable {
    public FreeSticker(String name, String message) {
        super(name, message);
        this.price = 0;
    }

    @Override
    public void stickerStatus() {
        System.out.println("This sticker is free");
    }
    @Override
    public String toString() {
        return this.name + " " + this.message + " " + this.price;
    }

    @Override
    public int hashCode() {
        int result = 21;
        result = 31 * result + this.name.hashCode();
        result = 31 * result + this.message.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        return this.hashCode() == obj.hashCode();
    }
}
