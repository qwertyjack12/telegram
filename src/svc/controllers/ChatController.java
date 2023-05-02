package svc.controllers;

import svc.services.chatService.ChatService;
import svc.services.stickerService.StickerService;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatController {
    private final StickerService stickerService;
    private final ChatService chatService;
    private final Scanner scanner;
    private final ExecutorService service;

    public ChatController(ChatService chatService, StickerService stickerService, Scanner scanner){
        this.chatService = chatService;
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
                chatService.saveData();
            }
        });
    }
    public void readData(){
        service.execute(new Runnable() {
            @Override
            public void run() {
                chatService.readData();
            }
        });
    }
    public void closeThread(){
        service.shutdown();
    }

    public void setChat(){
        System.out.print("id of chat: ");
        int id = listenInt();
        System.out.print("Name: ");
        String name = listenStr();
        chatService.setChat(id, name);
    }
    public void removeChat(){
        chatService.getChats();
        System.out.print("id of chat: ");
        int id = listenInt();
        chatService.removeChat(id);
    }
    public void setPremiumChat(){
        chatService.getChats();
        System.out.print("id of chat: ");
        int id = listenInt();
        chatService.setPremiumChat(id);
    }
    public void setFreeChat(){
        chatService.getChats();
        System.out.print("id of chat: ");
        int id = listenInt();
        chatService.setFreeChat(id);
    }
    public void addSticker(){
        chatService.getChats();
        System.out.print("id of chat: ");
        int id = listenInt();

        stickerService.getStickers();
        System.out.print("id of sticker: ");
        int stickerId = listenInt();

        chatService.addSticker(id, stickerService.getSticker(stickerId));
    }
    public void getChatStickerPrice(){
        chatService.getChatStickerPrice();
    }
    public void getChats(){
        chatService.getChats();
    }
}
