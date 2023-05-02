package svc.controllers;

import svc.services.stickerService.StickerService;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StickerController {
    private final StickerService stickerService;
    private final Scanner scanner;
    private final ExecutorService service;

    public StickerController(StickerService stickerService, Scanner scanner){
        this.stickerService = stickerService;
        this.scanner = scanner;
        this.service = Executors.newSingleThreadExecutor();
    }

    public int listenInt() {
        return scanner.nextInt();
    }

    public String listenStr() {
        return scanner.next();
    }

    public void saveData(){
        service.execute(new Runnable() {
            @Override
            public void run() {
                stickerService.saveData();
            }
        });
    }
    public void readData(){
        service.execute(new Runnable() {
            @Override
            public void run() {
                stickerService.readData();
            }
        });
    }
    public void closeThread(){
        service.shutdown();
    }

    public  void setFreeSticker(){
        System.out.print("id of sticker: ");
        int id = listenInt();
        System.out.print("Name: ");
        String name = listenStr();
        System.out.print("Message: ");
        String message = listenStr();

        stickerService.setFreeSticker(id, name, message);
    }
    public  void setPremiumSticker(){
        System.out.print("id of sticker: ");
        int id = listenInt();
        System.out.print("Name: ");
        String name = listenStr();
        System.out.print("Message: ");
        String message = listenStr();
        System.out.print("Price: ");
        int price = listenInt();

        stickerService.setPremiumSticker(id, name, message, price);
    }
    public  void removeSticker(){
        stickerService.getStickers();
        System.out.print("id of sticker: ");
        int id = listenInt();
        stickerService.removeSticker(id);
    }
    public  void getStickersPrice(){
        stickerService.getStickersPrice();
    }
    public  void getStickers(){
        stickerService.getStickers();
    }
}
