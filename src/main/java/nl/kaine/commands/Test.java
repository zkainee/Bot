package nl.kaine.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.Objects;

public class Test extends ListenerAdapter {
    //TODO Zorgen dat .<test> command werkt, zie CommandHandler.java

    public void MessageReceivedEvent(@NotNull MessageReceivedEvent e) {
        String[] args = e.getMessage().getContentRaw().split(" ");
        if (args[0].equalsIgnoreCase("test")){
            if (!Objects.requireNonNull(e.getMember()).getUser().isBot()) {
                EmbedBuilder em = new EmbedBuilder()
                        .setColor(Color.GRAY)
                        .setAuthor("TALE", e.getJDA().getSelfUser().getAvatarUrl())
                        .setThumbnail(Objects.requireNonNull(e.getGuild()).getIconUrl())
                        .setTitle("Test Command")
                        .setDescription("Sit amet")

                        .addField("assist", "Assisteert bij hulp", true)
                        .addField("report", "Rapporteer een lid", true)

                        .addField("Discord", "[link](https://discord.gg/bBDwYajp)", true);
                e.getChannel().sendMessageEmbeds(em.build()).queue();
            }
        }
    }
}
