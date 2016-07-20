package xyz.mkotb.tg.convo;

import pro.zackpollard.telegrambot.api.TelegramBot;
import pro.zackpollard.telegrambot.api.conversations.Conversation;
import pro.zackpollard.telegrambot.api.event.Listener;
import pro.zackpollard.telegrambot.api.event.chat.message.CommandMessageReceivedEvent;

public class TelegramConversationTest implements Listener {
    private TelegramBot bot;

    TelegramConversationTest(TelegramBot bot) {
        this.bot = bot;
    }

    public static void main(String[] args) {
        TelegramBot bot = TelegramBot.login("nice one");
        bot.getEventsManager().register(new TelegramConversationTest(bot));
        bot.startUpdates(false);
    }

    @Override
    public void onCommandMessageReceived(CommandMessageReceivedEvent event) {
        if (!"test".equalsIgnoreCase((event.getCommand()))) {
            return;
        }

        Conversation.builder(bot)
                .forWhom(event.getChat())
                .prompts()
                    .first(new EmailPrompt())
                    .then(new FavouriteNumberPrompt()) // can be called repeatedly
                    .last(new FavouriteStickerPrompt())
                .disableGlobalEvents(false)
                .build()
                .begin();
    }
}
