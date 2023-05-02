package svc.services.stickerService;

import sticker.FreeSticker;
import sticker.PremiumSticker;
import sticker.Sticker;
import svc.Deserializator;
import svc.Serializator;

import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

public class StickerServiceImpl implements StickerService{
    private Hashtable<Integer, Sticker> stickerHashtable;
    public final String fileName = "src\\usedFiles\\Sticker.txt";

    private void checkFIle(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        fileReader.close();
    }
    @Override
    public void saveData() {
        Serializator.serialization(stickerHashtable, fileName);
    }

    @Override
    public void readData() {
        try {
            this.checkFIle(fileName);
            this.stickerHashtable = Deserializator.getHashtable(fileName);
        } catch (IOException | ClassNotFoundException e) {
            this.stickerHashtable = new Hashtable<>();
        }
    }

    @Override
    public boolean checkStickerId(int id) {
        if (stickerHashtable.containsKey(id)) {
            return true;
        } else {
            System.out.println("Wrong sticker id input!");
            return false;
        }
    }

    @Override
    public void setFreeSticker(int id, String name, String massage) {
        stickerHashtable.put(id, new FreeSticker(name, massage));
    }

    @Override
    public void setPremiumSticker(int id, String name, String massage, int price) {
        stickerHashtable.put(id, new PremiumSticker(name, massage, price));
    }

    @Override
    public void removeSticker(int id) {
        if ((stickerHashtable.size() != 0) & (stickerHashtable.containsKey(id))) {
            stickerHashtable.remove(id);
        }
    }

    @Override
    public void getStickersPrice() {
        int total = 0;
        for (var x: stickerHashtable.keySet()){
            total += stickerHashtable.get(x).getPrice();
        }
        System.out.println(total);
    }

    @Override
    public void getStickers() {
        System.out.println(stickerHashtable);
    }

    @Override
    public Sticker getSticker(int id) {
        return stickerHashtable.get(id);
    }
}
