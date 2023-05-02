import svc.controllers.ChannelController;
import svc.controllers.ChatController;
import svc.controllers.StickerController;
import svc.services.channelService.ChannelServiceImpl;
import svc.services.chatService.ChatServiceImpl;
import svc.services.stickerService.StickerServiceImpl;
import svc.view.ConsoleView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StickerServiceImpl stickerService = new StickerServiceImpl();
        ChatServiceImpl chatService = new ChatServiceImpl();
        ChannelServiceImpl channelService = new ChannelServiceImpl();

        Scanner scanner = new Scanner(System.in);

        StickerController stickerController = new StickerController(stickerService, scanner);
        ChatController chatController = new ChatController(chatService, stickerService, scanner);
        ChannelController channelController = new ChannelController(channelService, chatService, scanner);

        ConsoleView consoleView = new ConsoleView(stickerController, chatController, channelController);

        consoleView.readData();
        consoleView.init();

    }
}