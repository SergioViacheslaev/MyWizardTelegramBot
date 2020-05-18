package ru.home.mywizard_bot;


import lombok.SneakyThrows;
import org.springframework.util.ResourceUtils;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.home.mywizard_bot.botapi.TelegramFacade;

import java.io.File;


public class MyWizardTelegramBot extends TelegramWebhookBot {
    private String webHookPath;
    private String botUserName;
    private String botToken;

    private TelegramFacade telegramFacade;


    public MyWizardTelegramBot(DefaultBotOptions botOptions, TelegramFacade telegramFacade) {
        super(botOptions);
        this.telegramFacade = telegramFacade;
    }


    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public String getBotUsername() {
        return botUserName;
    }

    @Override
    public String getBotPath() {
        return webHookPath;
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        final BotApiMethod<?> replyMessageToUser = telegramFacade.handleUpdate(update);

        return replyMessageToUser;
    }

    public void setWebHookPath(String webHookPath) {
        this.webHookPath = webHookPath;
    }

    public void setBotUserName(String botUserName) {
        this.botUserName = botUserName;
    }

    public void setBotToken(String botToken) {
        this.botToken = botToken;
    }

    @SneakyThrows
    public void sendPhoto(long chatId, String imageCaption, String imagePath) {
        File image = ResourceUtils.getFile("classpath:" + imagePath);
        SendPhoto sendPhoto = new SendPhoto().setPhoto(image);
        sendPhoto.setChatId(chatId);
        sendPhoto.setCaption(imageCaption);
        execute(sendPhoto);
    }

    @SneakyThrows
    public void sendDocument(long chatId, String caption, File sendFile) {
        SendDocument sendDocument = new SendDocument();
        sendDocument.setChatId(chatId);
        sendDocument.setCaption(caption);
        sendDocument.setDocument(sendFile);
        execute(sendDocument);
    }


}
