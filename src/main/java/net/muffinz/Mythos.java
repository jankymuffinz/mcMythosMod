package net.muffinz;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.block.v1.FabricBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.TorchBlock;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mythos implements ModInitializer {
    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("mythos");

    // ** ---------- Item Init --------- ** //

    public static final Item STRANGER_IN_CARCOSSA = Registry.register(Registries.ITEM, new Identifier("mythos", "stranger_in_carcossa"),
            new Item(new FabricItemSettings().rarity(Rarity.EPIC).maxCount(1)));
    public static final Item



    // ** ---------- Block Init --------- ** //

    public static final Block TOTEMIC_EAGLE = Registry.register(Registries.BLOCK, new Identifier("mythos", "totemic_eagle"),
            new Block(FabricBlockSettings.of().strength(3.0f)));





    public void registerBlockItems() {
        Registry.register(Registries.ITEM, new Identifier("mythos", "totemic_eagle"), new BlockItem(TOTEMIC_EAGLE, new FabricItemSettings().rarity(Rarity.UNCOMMON)));


    }

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        LOGGER.info("Hello Fabric world!");

        registerBlockItems();
    }
}