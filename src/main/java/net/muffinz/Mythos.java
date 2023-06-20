package net.muffinz;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.muffinz.items.KingInYellow.KingInYellow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mythos implements ModInitializer {
    public static final String MODID = "mythos";
    
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

    // ** ---------- Item Init --------- ** //

    public static final KingInYellow THE_KING_IN_YELLOW = Registry.register(Registries.ITEM, new Identifier(MODID, "the_king_in_yellow"),
            new KingInYellow(new FabricItemSettings().rarity(Rarity.EPIC).maxCount(1)));



    // ** ---------- Block Init --------- ** //

    public static final Block TOTEMIC_PHANTOM = Registry.register(Registries.BLOCK, new Identifier(MODID, "totemic_phantom"),
            new Block(FabricBlockSettings.copyOf(AbstractBlock.Settings.create().burnable().strength(2.0f).solid())));
    public static final Block TOTEM_BLANK = Registry.register(Registries.BLOCK, new Identifier(MODID, "totem_blank"), 
            new Block(FabricBlockSettings.copyOf(AbstractBlock.Settings.create().burnable().strength(2.0f).solid())));



    
    public void registerBlockItems() {
        Registry.register(Registries.ITEM, new Identifier(MODID, "totemic_phantom"), new BlockItem(TOTEMIC_PHANTOM, new FabricItemSettings().rarity(Rarity.UNCOMMON)));
        Registry.register(Registries.ITEM, new Identifier(MODID, "totem_blank"), new BlockItem(TOTEM_BLANK, new FabricItemSettings().rarity(Rarity.UNCOMMON)));

    }

    @Override
    public void onInitialize() {
        LOGGER.info("Mythos Loaded");

        registerBlockItems();
    }
}