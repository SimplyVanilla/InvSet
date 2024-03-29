package net.simplyvanilla.invset;

import de.tr7zw.changeme.nbtapi.utils.MinecraftVersion;
import me.hsgamer.hscore.bukkit.command.CommandManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class InvSet extends JavaPlugin {
    private final CommandManager commandManager = new CommandManager(this);

    @Override
    public void onLoad() {
        MinecraftVersion.disableBStats();
        MinecraftVersion.disableUpdateCheck();
        MinecraftVersion.replaceLogger(this.getLogger());
        MinecraftVersion.getVersion();
    }

    @Override
    public void onEnable() {
        Permissions.register();

        commandManager.register(new GetCommand(this));
        commandManager.register(new AirCommand(this));
        CommandManager.syncCommand();
    }

    @Override
    public void onDisable() {
        commandManager.unregisterAll();
        Permissions.unregister();
    }
}
