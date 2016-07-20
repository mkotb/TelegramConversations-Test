package xyz.mkotb.tg.convo;

import pro.zackpollard.telegrambot.api.chat.message.content.StickerContent;
import pro.zackpollard.telegrambot.api.chat.message.send.SendableMessage;
import pro.zackpollard.telegrambot.api.chat.message.send.SendableTextMessage;
import pro.zackpollard.telegrambot.api.conversations.ConversationContext;
import pro.zackpollard.telegrambot.api.conversations.prompt.StickerPrompt;

public class FavouriteStickerPrompt extends StickerPrompt {
    @Override
    public boolean process(ConversationContext context, StickerContent input) {
        context.getFrom().sendMessage("Awesome! Your email is " + context.sessionDataBy("email") +
                ", your favourite number is " + context.sessionDataBy("favourite-number") + ", " +
                "and your favourite sticker's emoji is " + input.getContent().getEmoji());
        return false;
    }

    @Override
    public SendableMessage promptMessage(ConversationContext context) {
        return SendableTextMessage.builder()
                .message("That's a cool favourite number! " +
                        "What's your favourite sticker?")
                .build();
    }
}
