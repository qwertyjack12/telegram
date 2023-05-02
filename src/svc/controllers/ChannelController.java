package svc.controllers;

import svc.services.channelService.ChannelService;
import svc.services.chatService.ChatService;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChannelController {
    private final ChannelService channelService;
    private final ChatService chatService;
    private final Scanner scanner;
    private final ExecutorService service;

    public ChannelController(ChannelService channelService, ChatService chatService, Scanner scanner){
        this.channelService = channelService;
        this.chatService = chatService;
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
                channelService.saveData();
            }
        });
    }
    public void readData(){
        service.execute(new Runnable() {
            @Override
            public void run() {
                channelService.readData();
            }
        });
    }
    public void closeThread(){
        service.shutdown();
    }

    public void setChannel(){
        System.out.print("id of channel: ");
        int id = listenInt();
        System.out.print("Name: ");
        String name = listenStr();
        System.out.print("Description: ");
        String description = listenStr();

        channelService.setChannel(id, name, description);
    }
    public void removeChannel(){
        channelService.getChannels();
        System.out.print("id of channel: ");
        int id = listenInt();
        channelService.removeChannel(id);
    }
    public void addChannelChat(){
        channelService.getChannels();
        System.out.print("id of channel: ");
        int id = listenInt();

        chatService.getChats();
        System.out.print("id of chat: ");
        int chatId = listenInt();

        channelService.addChannelChat(id, chatService.getChat(chatId));
    }
    public void removeChannelChat(){
        channelService.getChannels();
        System.out.print("id of channel: ");
        int id = listenInt();

        chatService.getChats();
        System.out.print("id of chat: ");
        int chatId = listenInt();

        channelService.removeChannelChat(id, chatService.getChat(chatId));
    }
    public void getChannels(){
        channelService.getChannels();
    }
}
