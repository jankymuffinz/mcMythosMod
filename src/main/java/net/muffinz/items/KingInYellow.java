package net.muffinz.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class KingInYellow extends Item implements IAnimatable, ISyncable {
    public KingInYellow(Settings settings) {
        super(settings);

        //Register the item as a geckolib syncable
        GeckoLibNetwork.registerSyncable(this);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        player.playSound(SoundEvents.BLOCK_SCULK_SHRIEKER_SHRIEK, 1.0f, 1.0f);
        return TypedActionResult.success(player.getStackInHand(hand));
    }

    private static final int ACTIVATE_ANIM_STATE = 0;
    private static final AnimationBuilder ACTIVATE_ANIM = new AnimationBuilder().addAnimation("misc.activate", false)

    public final AnimationFactory factory = GeckoLibUtil.createFactory(this);

    @Override
    public void registerControllers(final AnimationData data) {
        data.addAnimationController(new AnimationController(this, "Activation", 20, event -> PlayState.CONTINUE));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (!world.isClientSide) {
            final int id = GeckoLibUtil.guaranteeIDForStack(stack , (ServerLevel)level);
            // Assign an ID for animations to this stack, then use it to sync an animation to the client
            GeckoLibNetwork.syncAnimation(PacketDistributor.TRACKING_ENTITY_AND_SELF.with(() -> player), this, id, ACTIVATE_ANIM_STATE);
        }

        return InteractionResultHolder.consume(stack);
    }

    @Override
    public void onAnimationSync(int id, int state) {
        if (state == ACTIVATE_ANIM_STATE) {
            // Always use GeckoLibUtil to get AnimationControllers when you don't have
            // access to an AnimationEvent
            final AnimationController controller = GeckoLibUtil.getControllerForID(this.factory, id, "Activation");

            if (controller.getAnimationState() == AnimationState.Stopped) {
                final Player player = MyClientUtils.getPlayer();

                if (player != null)
                    player.sendMessage(new TextComponent("Activating my item!"));

                // If you don't do this, the popup animation will only play once because the
                // animation will be cached.
                controller.markNeedsReload();
                // Set the animation to open the JackInTheBoxItem which will start playing music
                // and
                // eventually do the actual animation. Also sets it to not loop
                controller.setAnimation(ACTIVATE_ANIM);
            }
        }
    }
}
