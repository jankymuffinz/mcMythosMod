package net.muffinz.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class KingInYellow extends Item {

    public KingInYellow(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        player.playSound(SoundEvents.BLOCK_SCULK_SHRIEKER_SHRIEK, 1.0f, 1.0f);
        return TypedActionResult.success(player.getStackInHand(hand));
    }

}
