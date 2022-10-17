package nl.kaine.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.Modal;
import net.dv8tion.jda.api.interactions.components.text.TextInput;
import net.dv8tion.jda.api.interactions.components.text.TextInputStyle;

public class Report extends ListenerAdapter {

    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
            if (event.getName().equals("report")) {
                TextInput subject = TextInput.create("header", "Rapporteer Discord ID", TextInputStyle.SHORT)
                        .setPlaceholder("Wie wil je rapporteren")
                        .setMinLength(18)
                        .setMaxLength(18)
                        .setRequired(true)
                        .build();

                TextInput body = TextInput.create("body", "Reden van rapportage", TextInputStyle.PARAGRAPH)
                        .setPlaceholder("Definieer de reden zo duidelijk & specifiek mogelijk")
                        .setMinLength(30)
                        .setMaxLength(1000)
                        .setRequired(true)
                        .build();

                Modal modal = Modal.create("report", "Rapporteer een lid")
                        .addActionRows(ActionRow.of(subject), ActionRow.of(body))
                        .build();

                event.replyModal(modal).queue();
            }
    }

}
