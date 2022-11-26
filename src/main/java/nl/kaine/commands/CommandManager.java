package nl.kaine.commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import nl.kaine.Main;
import org.jetbrains.annotations.NotNull;

public class CommandManager extends ListenerAdapter {
    // PREFIX commando's
    public void MessageReceivedEvent(@NotNull MessageReceivedEvent e) {
        String[] args = e.getMessage().getContentRaw().split(" ");
        if (args[0].equalsIgnoreCase(Main.prefix + "test")) {
            e.getChannel().sendMessage("lorem ipsum").queue();
        }
    }
}
