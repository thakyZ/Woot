package ipsis.woot.item;

import ipsis.woot.tileentity.ng.WootMob;
import ipsis.woot.tileentity.ng.WootMobBuilder;
import ipsis.woot.util.StringHelper;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ItemBlockController extends ItemBlock {

    public ItemBlockController(Block block) {

        super(block);
        this.setMaxDamage(0);
        this.setHasSubtypes(false);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {

        if (stack != null && stack.hasTagCompound()) {

            WootMob wootMob = WootMobBuilder.create(stack.getTagCompound());
            if (wootMob.isValid())
                tooltip.add(String.format("Mob: %s", StringHelper.localize(wootMob.getDisplayName())));
        }

        super.addInformation(stack, playerIn, tooltip, advanced);
    }
}
