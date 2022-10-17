package nl.kaine;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import nl.kaine.commands.CommandHandler;
import nl.kaine.commands.Report;
import nl.kaine.listeners.ReportListener;
import nl.kaine.token.token;


public class Main extends ListenerAdapter {
    public static void main(String[] args) throws InterruptedException{
        JDA jda = (JDA) JDABuilder.createDefault(token.token)
                .disableCache(CacheFlag.VOICE_STATE, CacheFlag.EMOJI, CacheFlag.STICKER)
                .build().awaitReady();

        jda.getPresence().setActivity(Activity.listening("bot by: Kaine"));
        jda.getPresence().setStatus(OnlineStatus.ONLINE);

        jda.addEventListener(new Report(), new ReportListener(), new CommandHandler());

        Guild guild = jda.getGuildById("988150737714442321");

        if (guild != null) {
            guild.upsertCommand("assist", "De command voor jouw hulp!").queue();
            guild.upsertCommand("report", "Rapporteer een lid").queue();
        }
        System.out.println();
    }
}