package svc.view;

import svc.controllers.ChannelController;
import svc.controllers.ChatController;
import svc.controllers.StickerController;

import java.util.Scanner;

public class ConsoleView implements View{
    private final StickerController stickerController;
    private final ChatController chatController;
    private final ChannelController channelController;
    private boolean flag;

    public ConsoleView(StickerController stickerController, ChatController chatController, ChannelController channelController){
        this.flag = true;
        this.stickerController = stickerController;
        this.chatController = chatController;
        this.channelController = channelController;
    }

    @Override
    public int listen() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    @Override
    public void init() {
        while (this.flag) {
            showMenu();
        }
    }

    @Override
    public void saveChanges() {
        stickerController.saveData();
        chatController.saveData();
        channelController.saveData();
    }

    @Override
    public void readData() {
        stickerController.readData();
        chatController.readData();
        channelController.readData();
    }

    @Override
    public void closeThread() {
        stickerController.closeThread();
        chatController.closeThread();
        channelController.closeThread();
    }

    @Override
    public void showMenu() {
        System.out.println("Menu:");
        System.out.println("-> 1: Sticker");
        System.out.println("-> 2: Chat");
        System.out.println("-> 3: Channel");
        System.out.println("-> 4: Save");
        System.out.println("-> 0: Close app");
        System.out.print("Your choice: ");

        switch (listen()) {
            case 0 -> {
                this.flag = false;
                this.closeThread();
                return;
            }
            case 1 -> showStickers();
            case 2 -> showChats();
            case 3 -> showChannels();
            case 4 -> this.saveChanges();
            default -> showMenu();
        }
    }

    @Override
    public void showStickers() {
        System.out.println("Stickers Menu:");
        System.out.println("-> 1: Add free sticker");
        System.out.println("-> 2: Add premium sticker");
        System.out.println("-> 3: Remove sticker");
        System.out.println("-> 4: Show price of stickers");
        System.out.println("-> 5: Show stickers");
        System.out.println("-> 0: Back");
        System.out.print("Your choice: ");

        switch (listen()) {
            case 0 -> {
                showMenu();
            }
            case 1 -> stickerController.setFreeSticker();
            case 2 -> stickerController.setPremiumSticker();
            case 3 -> stickerController.removeSticker();
            case 4 -> stickerController.getStickersPrice();
            case 5 -> stickerController.getStickers();
            default -> showStickers();
        }
    }

    @Override
    public void showChats() {
        System.out.println("Chats Menu:");
        System.out.println("-> 1: Add chat");
        System.out.println("-> 2: Remove chat");
        System.out.println("-> 3: Set premium chat");
        System.out.println("-> 4: Set free chat");
        System.out.println("-> 5: Add sticker for chat");
        System.out.println("-> 6: Show sticker price for any chat");
        System.out.println("-> 7: Show chats");
        System.out.println("-> 0: Back");
        System.out.print("Your choice: ");

        switch (listen()) {
            case 0 -> {
                showMenu();
            }
            case 1 -> chatController.setChat();
            case 2 -> chatController.removeChat();
            case 3 -> chatController.setPremiumChat();
            case 4 -> chatController.setFreeChat();
            case 5 -> chatController.addSticker();
            case 6 -> chatController.getChatStickerPrice();
            case 7 -> chatController.getChats();
            default -> showChats();
        }
    }

    @Override
    public void showChannels() {
        System.out.println("Channels Menu:");
        System.out.println("-> 1: Add channel");
        System.out.println("-> 2: Remove channel");
        System.out.println("-> 3: Add chat for channel");
        System.out.println("-> 4: Remove chat for channel");
        System.out.println("-> 5: Show channels");
        System.out.println("-> 0: Back");
        System.out.print("Your choice: ");

        switch (listen()) {
            case 0 -> {
                showMenu();
            }
            case 1 -> channelController.setChannel();
            case 2 -> channelController.removeChannel();
            case 3 -> channelController.addChannelChat();
            case 4 -> channelController.removeChannelChat();
            case 5 -> channelController.getChannels();
            default -> showChats();
        }
    }
}