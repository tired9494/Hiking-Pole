package github.tired9494.hiking_pole;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class HikingPole implements ModInitializer {

    public static final HikingPoleItem HIKING_POLE = new HikingPoleItem(new Item.Settings().maxCount(1).group(ItemGroup.TOOLS));

    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("hiking_pole","hiking_pole"), HIKING_POLE);
    }
}
