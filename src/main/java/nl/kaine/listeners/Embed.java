package nl.kaine.listeners;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.Objects;

public class Embed extends ListenerAdapter {
    //Help commando
    public static void sendHelpEmbed(@NotNull SlashCommandInteractionEvent event) {
        TextChannel channel = event.getJDA().getTextChannelById("1030070520235970600");
        MessageEmbed sendEmbedHelp = new EmbedBuilder()
                    .setColor(Color.GRAY)
                    .setAuthor("Tale", event.getJDA().getSelfUser().getAvatarUrl())
                    .setThumbnail(Objects.requireNonNull(event.getGuild()).getIconUrl())
                    .setTitle("Overzicht met alle mogelijk commando's.")
                    .setDescription("_Mocht het niet werken, contacteer dan een Developer._")

                    .addField("assist", "Assisteert bij hulp", true)
                    .addField("report", "Rapporteer een lid", true)
                    .addField("Discord", "[link](https://discord.gg/bBDwYajp)", true)
                    .setFooter("Created by: " + event.getUser().getAsTag())
                    .build();
        Objects.requireNonNull(channel).sendMessageEmbeds(sendEmbedHelp).queue();
    }
    public static void sendEmbedReply(@NotNull SlashCommandInteractionEvent event) {
        TextChannel channel = event.getJDA().getTextChannelById("1030070520235970600");
        MessageEmbed sendReplyEmbed = new EmbedBuilder()
                .setColor(Color.RED)
                .setAuthor("Tale", event.getJDA().getSelfUser().getAvatarUrl())
                .setTitle("Onbekend commando")
                .build();
        Objects.requireNonNull(channel).sendMessageEmbeds(sendReplyEmbed).queue();
    }
    public static void sendAssistReply(@NotNull SlashCommandInteractionEvent event) {
        TextChannel channel = event.getJDA().getTextChannelById("1030070520235970600");
        MessageEmbed sendAssistReply = new EmbedBuilder()
                .setColor(Color.GREEN)
                .setAuthor("Tale")
                .setThumbnail(event.getUser().getAvatarUrl())
                .setTitle("Report assist")
                .setDescription("Rapporteren lukt niet? Zet Dev Mode aan en copy user ID")
                .build();
        Objects.requireNonNull(channel).sendMessageEmbeds(sendAssistReply).queue();
    }
}