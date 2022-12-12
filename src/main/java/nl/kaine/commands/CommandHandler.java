package nl.kaine.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import nl.kaine.listeners.Embed;

public class CommandHandler extends ListenerAdapter {

    // Slash Commando's
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        switch (event.getName())
        {
            case "assist":
                Embed.sendAssistReply(event);
                event.getChannel().
                break;
            default:
                Embed.sendEmbedReply(event);
        }

        if (event.getGuild() == null)
            return;

//        if ("assist".equals(event.getName())) {
//            event.deferReply().queue();
//            Embed.sendAssistReply(event);
//        } else if ("report".equals(event.getName())) {
//            event.getHook().sendMessage("We gaan je helpen, hulp nodig? /assist!").setEphemeral(true).queue();
//        } else if ("help".equals(event.getName())) {
//            Embed.sendHelpEmbed(event);
//            event.deferReply().setEphemeral(true).queue();
//        } else {
//            event.deferReply().queue();
//            Embed.sendEmbedReply(event);
//        }
    }
}
