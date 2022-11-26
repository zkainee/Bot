package nl.kaine.listeners;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.message.MessageEmbedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.hooks.SubscribeEvent;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.Objects;

public class Embed extends ListenerAdapter {
    //TODO Zorgen dat embed word gestuurd als .<command> word gedaan
    @SubscribeEvent
    public void sendEmbedHelp(@NotNull MessageEmbedEvent event) {
        if (event.equals("help")) {
            MessageEmbed sendEmbedHelp = new EmbedBuilder()
                    .setColor(Color.GRAY)
                    .setAuthor("TALE", event.getJDA().getSelfUser().getAvatarUrl())
                    .setThumbnail(Objects.requireNonNull(event.getGuild()).getIconUrl())
                    .setTitle("Lorem")
                    .setDescription("Sit amet")

                    .addField("assist", "Assisteert bij hulp", true)
                    .addField("report", "Rapporteer een lid", true)

                    .addField("Discord", "[link](https://discord.gg/bBDwYajp)", true)
                    .build();
//            event.replyEmbed(sendEmbedHelp).queue();
        }
    }
}