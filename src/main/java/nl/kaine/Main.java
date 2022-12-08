package nl.kaine;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import nl.kaine.commands.CommandHandler;
import nl.kaine.commands.CommandManager;
import nl.kaine.commands.Report;
import nl.kaine.listeners.Embed;
import nl.kaine.listeners.ReportListener;

public class Main extends ListenerAdapter {
    public static String prefix = "$";
    public static void main(String[] args) throws InterruptedException {
        // Load env file
        Dotenv config = Dotenv.configure().load();
        String token = config.get("TOKEN");

        // Bot startup sequence
        JDA jda = JDABuilder.createDefault(token)
                .disableCache(CacheFlag.VOICE_STATE, CacheFlag.EMOJI, CacheFlag.STICKER)
                .enableIntents(GatewayIntent.GUILD_MESSAGES)
                .build().awaitReady();

        jda.getPresence().setActivity(Activity.listening("bot by: Kaine"));
        jda.getPresence().setStatus(OnlineStatus.ONLINE);
        jda.addEventListener(
                new Main(),
                new Report(),
                new ReportListener(),
                new CommandHandler(),
                new Embed(),
                new CommandManager());

        Guild guild = jda.getGuildById("988150737714442321");
        if (guild != null) {
            jda.updateCommands()
                    .addCommands(Commands.slash("assist", "Command voor jouw hulp"))
                    .addCommands(Commands.slash("report", "Rapporteer een lid"))
                    .addCommands(Commands.slash("help", "Overzicht van commando's"))
                    .queue();
        }
    }
}

//TODO
// Commando toevoegen aan slash-list, verder zie CommandHandler
// Zorgen dat embed word gestuurd als .<command> word gedaan
// CommandManager maken met prefix [$] (zie line: 21) & gemakkelijk commando's kan aanmaken.
// /help commando fix op: "The application did not respond"
// Fix reply report embed message
// Ephemeral(true) op slashcommandinteractionevent
// PREFIX commando's