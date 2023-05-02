package svc.view;

public interface View {
    int listen();

    void init();
    void saveChanges();
    void readData();
    void closeThread();

    void showMenu();

    void showStickers();

    void showChats();

    void showChannels();
}
