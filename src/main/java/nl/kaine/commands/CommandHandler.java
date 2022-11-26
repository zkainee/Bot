package nl.kaine.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class CommandHandler extends ListenerAdapter {
    //TODO CommandManager maken met prefix [.] & gemakkelijk commando's kan aanmaken.

    // Slash Commando's
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getGuild() == null)
            return;

        if ("assist".equals(event.getName())) {
            event.deferReply().queue();
            event.getHook().sendMessage("Rapporteren lukt niet? Zet Dev Mode aan en copy user ID").setEphemeral(true).queue();
        } else if ("report".equals(event.getName())) {
            event.getHook().sendMessage("We gaan je helpen, hulp nodig? /assist!").setEphemeral(true).queue();
        } else if ("help".equals(event.getName())) {
            event.deferReply().queue();
        } else {
            event.reply("Hey, onbekend commando: (").setEphemeral(true).queue();
        }
    }
}
