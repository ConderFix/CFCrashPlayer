package ru.quizie.cfcrashplayer;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.settings.PacketEventsSettings;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
import ru.quizie.cfcrashplayer.commands.CrashCommand;
import ru.quizie.cfcrashplayer.crash.CrashManager;

public final class CFCrashPlayer extends JavaPlugin {

    private final CrashManager crashManager = new CrashManager();

    @Override
    public void onLoad() {
        PacketEvents.getAPI().load();
    }

    @Override
    public void onEnable() {
        PacketEvents.getAPI().init();

        final PacketEventsSettings settings = PacketEvents.getAPI().getSettings();
        settings.checkForUpdates(false);
        settings.debug(false);

        this.getCommand("crash").setExecutor(new CrashCommand(crashManager));
        this.crashManager.initCrashPacket();
    }

    @Override
    public void onDisable() {
        PacketEvents.getAPI().terminate();
    }
}

