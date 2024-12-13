package com.mimiceraddon;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = "mimiceraddon") // Replace with your mod's ID if needed
public class LootDropHandler {

    @SubscribeEvent
    public static void onLivingDrops(LivingDropsEvent event) {
        // Get the ResourceLocation (registry name) of the entity type
        ResourceLocation entityName = ForgeRegistries.ENTITY_TYPES.getKey(event.getEntity().getType());

        // Check if the entity killed is Mimicer
        if (entityName != null && entityName.toString().equals("mimicer:mimicer")) {
            // Add 2 diamonds to the drops
            ItemEntity diamondDrop = new ItemEntity(
                    event.getEntity().level,
                    event.getEntity().getX(),
                    event.getEntity().getY(),
                    event.getEntity().getZ(),
                    Items.DIAMOND.getDefaultInstance()
            );
            diamondDrop.getItem().setCount(2); // Set the amount of diamonds
            event.getDrops().add(diamondDrop);
        }
    }
}