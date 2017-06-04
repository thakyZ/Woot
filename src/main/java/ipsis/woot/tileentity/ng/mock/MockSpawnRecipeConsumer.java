package ipsis.woot.tileentity.ng.mock;

import ipsis.woot.tileentity.ng.ISpawnRecipe;
import ipsis.woot.tileentity.ng.ISpawnRecipeConsumer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class MockSpawnRecipeConsumer implements ISpawnRecipeConsumer {

    @Override
    public boolean consume(World world, BlockPos pos, @Nullable ISpawnRecipe spawnRecipe, int mobCount) {
        return true;
    }
}
