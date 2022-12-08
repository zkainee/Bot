package nl.kaine.listeners;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.interaction.ModalInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Objects;

public class ReportListener extends ListenerAdapter {
    @Override
    public void onModalInteraction(ModalInteractionEvent event) {
        if (event.getModalId().equals("report")) {
            String header = Objects.requireNonNull(event.getValue("header")).getAsString();
            String body = Objects.requireNonNull(event.getValue("body")).getAsString();

            event.reply("Bedankt voor je report!").setEphemeral(true).queue();

            //Reported embed
            TextChannel channel = event.getJDA().getTextChannelById("1031605982314381352");
            if (Objects.requireNonNull(channel).canTalk()) {
                MessageEmbed embed = new EmbedBuilder()
                        .setAuthor("TALE", event.getJDA().getSelfUser().getAvatarUrl())
                        .setThumbnail(event.getUser().getAvatarUrl())
                        .setTitle("ID: " + header)
                        .setDescription("Reden: " + body)
                        .setFooter("Reported by: " + event.getUser().getAsTag())
                        .build();
                channel.sendMessageEmbeds(embed).queue();
            }
        }
    }
}
