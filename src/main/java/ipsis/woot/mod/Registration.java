package ipsis.woot.mod;

import ipsis.woot.Woot;
import ipsis.woot.debug.DebugItem;
import ipsis.woot.factory.FactoryComponent;
import ipsis.woot.factory.FactoryUpgrade;
import ipsis.woot.factory.blocks.*;
import ipsis.woot.factory.items.UpgradeItem;
import ipsis.woot.factory.multiblock.MultiBlockTileEntity;
import ipsis.woot.tools.InternItem;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.ChunkGeneratorType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.RegisterDimensionsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class Registration {

    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event) {
        Woot.LOGGER.info("registerBlocks");
        event.getRegistry().register(new HeartBlock());
        event.getRegistry().register(new ControllerBlock());
        event.getRegistry().register(new LayoutBlock());

        event.getRegistry().register(new FactoryBlock(FactoryComponent.FACTORY_A));
        event.getRegistry().register(new FactoryBlock(FactoryComponent.FACTORY_B));
        event.getRegistry().register(new FactoryBlock(FactoryComponent.FACTORY_C));
        event.getRegistry().register(new FactoryBlock(FactoryComponent.FACTORY_D));
        event.getRegistry().register(new FactoryBlock(FactoryComponent.FACTORY_E));
        event.getRegistry().register(new FactoryBlock(FactoryComponent.CAP_A));
        event.getRegistry().register(new FactoryBlock(FactoryComponent.CAP_B));
        event.getRegistry().register(new FactoryBlock(FactoryComponent.CAP_C));
        event.getRegistry().register(new FactoryBlock(FactoryComponent.CAP_D));
        event.getRegistry().register(new FactoryBlock(FactoryComponent.FACTORY_CONNECT));
        event.getRegistry().register(new FactoryBlock(FactoryComponent.FACTORY_CTR_BASE));
        event.getRegistry().register(new FactoryBlock(FactoryComponent.IMPORT));
        event.getRegistry().register(new FactoryBlock(FactoryComponent.EXPORT));
        event.getRegistry().register(new UpgradeBlock(FactoryComponent.FACTORY_UPGRADE));
    }

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event) {
        Woot.LOGGER.info("registerItems");

        Item.Properties properties = new Item.Properties().group(Woot.itemGroup);

        event.getRegistry().register(new DebugItem());
        event.getRegistry().register(new InternItem());

        event.getRegistry().register(new UpgradeItem(FactoryUpgrade.CAPACITY_1));
        event.getRegistry().register(new UpgradeItem(FactoryUpgrade.CAPACITY_2));
        event.getRegistry().register(new UpgradeItem(FactoryUpgrade.CAPACITY_3));
        event.getRegistry().register(new UpgradeItem(FactoryUpgrade.EFFICIENCY_1));
        event.getRegistry().register(new UpgradeItem(FactoryUpgrade.EFFICIENCY_2));
        event.getRegistry().register(new UpgradeItem(FactoryUpgrade.EFFICIENCY_3));
        event.getRegistry().register(new UpgradeItem(FactoryUpgrade.LOOTING_1));
        event.getRegistry().register(new UpgradeItem(FactoryUpgrade.LOOTING_2));
        event.getRegistry().register(new UpgradeItem(FactoryUpgrade.LOOTING_3));
        event.getRegistry().register(new UpgradeItem(FactoryUpgrade.MASS_1));
        event.getRegistry().register(new UpgradeItem(FactoryUpgrade.MASS_2));
        event.getRegistry().register(new UpgradeItem(FactoryUpgrade.MASS_3));
        event.getRegistry().register(new UpgradeItem(FactoryUpgrade.RATE_1));
        event.getRegistry().register(new UpgradeItem(FactoryUpgrade.RATE_2));
        event.getRegistry().register(new UpgradeItem(FactoryUpgrade.RATE_3));
        event.getRegistry().register(new UpgradeItem(FactoryUpgrade.XP_1));
        event.getRegistry().register(new UpgradeItem(FactoryUpgrade.XP_2));
        event.getRegistry().register(new UpgradeItem(FactoryUpgrade.XP_3));

        event.getRegistry().register(new BlockItem(ModBlocks.CONTROLLER_BLOCK, properties).setRegistryName(Woot.MODID, "controller"));
        event.getRegistry().register(new BlockItem(ModBlocks.HEART_BLOCK, properties).setRegistryName(Woot.MODID, "heart"));
        event.getRegistry().register(new BlockItem(ModBlocks.LAYOUT_BLOCK, properties).setRegistryName(Woot.MODID, "layout"));

        event.getRegistry().register(new BlockItem(ModBlocks.FACTORY_A_BLOCK, properties).setRegistryName(Woot.MODID, FactoryComponent.FACTORY_A.getName()));
        event.getRegistry().register(new BlockItem(ModBlocks.FACTORY_B_BLOCK, properties).setRegistryName(Woot.MODID, FactoryComponent.FACTORY_B.getName()));
        event.getRegistry().register(new BlockItem(ModBlocks.FACTORY_C_BLOCK, properties).setRegistryName(Woot.MODID, FactoryComponent.FACTORY_C.getName()));
        event.getRegistry().register(new BlockItem(ModBlocks.FACTORY_D_BLOCK, properties).setRegistryName(Woot.MODID, FactoryComponent.FACTORY_D.getName()));
        event.getRegistry().register(new BlockItem(ModBlocks.FACTORY_E_BLOCK, properties).setRegistryName(Woot.MODID, FactoryComponent.FACTORY_E.getName()));
        event.getRegistry().register(new BlockItem(ModBlocks.CAP_A_BLOCK, properties).setRegistryName(Woot.MODID, FactoryComponent.CAP_A.getName()));
        event.getRegistry().register(new BlockItem(ModBlocks.CAP_B_BLOCK, properties).setRegistryName(Woot.MODID, FactoryComponent.CAP_B.getName()));
        event.getRegistry().register(new BlockItem(ModBlocks.CAP_C_BLOCK, properties).setRegistryName(Woot.MODID, FactoryComponent.CAP_C.getName()));
        event.getRegistry().register(new BlockItem(ModBlocks.CAP_D_BLOCK, properties).setRegistryName(Woot.MODID, FactoryComponent.CAP_D.getName()));
        event.getRegistry().register(new BlockItem(ModBlocks.FACTORY_CONNECT_BLOCK, properties).setRegistryName(Woot.MODID, FactoryComponent.FACTORY_CONNECT.getName()));
        event.getRegistry().register(new BlockItem(ModBlocks.FACTORY_CTR_BASE_BLOCK, properties).setRegistryName(Woot.MODID, FactoryComponent.FACTORY_CTR_BASE.getName()));
        event.getRegistry().register(new BlockItem(ModBlocks.IMPORT_BLOCK, properties).setRegistryName(Woot.MODID, FactoryComponent.IMPORT.getName()));
        event.getRegistry().register(new BlockItem(ModBlocks.EXPORT_BLOCK, properties).setRegistryName(Woot.MODID, FactoryComponent.EXPORT.getName()));
        event.getRegistry().register(new BlockItem(ModBlocks.FACTORY_UPGRADE_BLOCK, properties).setRegistryName(Woot.MODID, FactoryComponent.FACTORY_UPGRADE.getName()));
    }

    @SubscribeEvent
    public static void registerTileEntities(final RegistryEvent.Register<TileEntityType<?>> event) {
        Woot.LOGGER.info("registerTileEntities");
        event.getRegistry().register(TileEntityType.Builder.create(HeartTileEntity::new, ModBlocks.HEART_BLOCK).build(null).setRegistryName(Woot.MODID, "heart"));
        event.getRegistry().register(TileEntityType.Builder.create(ControllerTileEntity::new, ModBlocks.CONTROLLER_BLOCK).build(null).setRegistryName(Woot.MODID, "controller"));
        event.getRegistry().register(TileEntityType.Builder.create(LayoutTileEntity::new, ModBlocks.LAYOUT_BLOCK).build(null).setRegistryName(Woot.MODID, "layout"));
        event.getRegistry().register(TileEntityType.Builder.create(UpgradeTileEntity::new, ModBlocks.FACTORY_UPGRADE_BLOCK).build(null).setRegistryName(Woot.MODID, "factory_upgrade"));
        event.getRegistry().register(TileEntityType.Builder.create(
                MultiBlockTileEntity::new,
                ModBlocks.IMPORT_BLOCK, ModBlocks.EXPORT_BLOCK,
                ModBlocks.FACTORY_A_BLOCK, ModBlocks.FACTORY_B_BLOCK, ModBlocks.FACTORY_C_BLOCK, ModBlocks.FACTORY_D_BLOCK, ModBlocks.FACTORY_E_BLOCK,
                ModBlocks.CAP_A_BLOCK, ModBlocks.CAP_B_BLOCK, ModBlocks.CAP_C_BLOCK, ModBlocks.CAP_D_BLOCK,
                ModBlocks.FACTORY_CONNECT_BLOCK,
                ModBlocks.FACTORY_CTR_BASE_BLOCK)
                .build(null).setRegistryName(Woot.MODID, "multiblock"));
    }

    @SubscribeEvent
    public static void registerEnchantments(final RegistryEvent.Register<Enchantment> event) {
        Woot.LOGGER.info("registerEnchantments");
    }

    @SubscribeEvent
    public static void registerModDimensions(final RegistryEvent.Register<ModDimension> event) {
        Woot.LOGGER.info("registerModDimensions");
        event.getRegistry().register(ModDimensions.tartarusModDimension.setRegistryName(Woot.MODID, "tartarus_dim"));
        ModDimensions.tartarusDimensionType = DimensionManager.registerDimension(
                new ResourceLocation(Woot.MODID, "tartarus_simulator"), ModDimensions.tartarusModDimension, null, true);
        DimensionManager.keepLoaded(ModDimensions.tartarusDimensionType, true);
    }

    @SubscribeEvent
    public static void registerDimensions(RegisterDimensionsEvent registerDimensionsEvent) {
        Woot.LOGGER.info("registerDimensions");
    }

    @SubscribeEvent
    public static void registerChunkGeneratorTypes(final RegistryEvent.Register<ChunkGeneratorType<?, ?>> event) {
        Woot.LOGGER.info("registerChunkGeneratorTypes");
        event.getRegistry().register(ModDimensions.tartarusChunkGeneratorType.setRegistryName(Woot.MODID, "tartarus_gen"));
    }
}