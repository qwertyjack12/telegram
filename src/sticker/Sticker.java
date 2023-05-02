package sticker;

import java.io.Serializable;

public abstract class Sticker implements Serializable {
    protected String name;
    protected String message;
    protected int price;
    public Sticker(String name, String message){
        this.name = name;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public abstract void stickerStatus();

    public int getPrice() {
        return this.price;
    }
}
