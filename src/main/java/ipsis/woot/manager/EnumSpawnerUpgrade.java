package ipsis.woot.manager;

import ipsis.woot.block.EnumVariantUpgrade;
import ipsis.woot.block.EnumVariantUpgradeB;
import ipsis.woot.tileentity.ng.configuration.EnumConfigKey;
import net.minecraft.util.IStringSerializable;

public enum EnumSpawnerUpgrade implements IStringSerializable {

    RATE_I(EnumConfigKey.RATE_1_POWER_TICK, EnumConfigKey.RATE_1_PARAM, 1),
    RATE_II(EnumConfigKey.RATE_2_POWER_TICK, EnumConfigKey.RATE_2_PARAM, 2),
    RATE_III(EnumConfigKey.RATE_3_POWER_TICK, EnumConfigKey.RATE_3_PARAM, 3),
    LOOTING_I(EnumConfigKey.LOOTING_1_POWER_TICK, EnumConfigKey.LOOTING_1_PARAM, 1),
    LOOTING_II(EnumConfigKey.LOOTING_2_POWER_TICK, EnumConfigKey.LOOTING_2_PARAM, 2),
    LOOTING_III(EnumConfigKey.LOOTING_3_POWER_TICK, EnumConfigKey.LOOTING_3_PARAM, 3),
    XP_I(EnumConfigKey.XP_1_POWER_TICK, EnumConfigKey.XP_1_PARAM, 1),
    XP_II(EnumConfigKey.XP_2_POWER_TICK, EnumConfigKey.XP_2_PARAM, 2),
    XP_III(EnumConfigKey.XP_3_POWER_TICK, EnumConfigKey.XP_3_PARAM, 3),
    MASS_I(EnumConfigKey.MASS_1_POWER_TICK, EnumConfigKey.MASS_1_PARAM, 1),
    MASS_II(EnumConfigKey.MASS_2_POWER_TICK, EnumConfigKey.MASS_2_PARAM, 2),
    MASS_III(EnumConfigKey.MASS_3_POWER_TICK, EnumConfigKey.MASS_3_PARAM, 3),
    DECAPITATE_I(EnumConfigKey.DECAP_1_POWER_TICK, EnumConfigKey.DECAP_1_PARAM, 1),
    DECAPITATE_II(EnumConfigKey.DECAP_2_POWER_TICK, EnumConfigKey.DECAP_2_PARAM, 2),
    DECAPITATE_III(EnumConfigKey.DECAP_3_POWER_TICK, EnumConfigKey.DECAP_3_PARAM, 3),
    EFFICIENCY_I(EnumConfigKey.EFF_1_POWER_TICK, EnumConfigKey.EFF_1_PARAM, 1),
    EFFICIENCY_II(EnumConfigKey.EFF_2_POWER_TICK, EnumConfigKey.EFF_2_PARAM, 2),
    EFFICIENCY_III(EnumConfigKey.EFF_3_POWER_TICK, EnumConfigKey.EFF_3_PARAM, 3),
    BLOODMAGIC_I(EnumConfigKey.BM_1_POWER_TICK, EnumConfigKey.BM_1_PARAM1, EnumConfigKey.BM_1_PARAM2, 1),
    BLOODMAGIC_II(EnumConfigKey.BM_2_POWER_TICK, EnumConfigKey.BM_2_PARAM1, EnumConfigKey.BM_2_PARAM2, 2),
    BLOODMAGIC_III(EnumConfigKey.BM_3_POWER_TICK, EnumConfigKey.BM_3_PARAM1, EnumConfigKey.BM_3_PARAM2, 3);

    EnumSpawnerUpgrade() { }

    private EnumConfigKey power;
    private EnumConfigKey param1;
    private EnumConfigKey param2;
    private int tier;
    EnumSpawnerUpgrade(EnumConfigKey power, EnumConfigKey param, int tier) {

        this.power = power;
        this.param1 = param;
        this.param2 = param;
        this.tier = tier;
    }

    EnumSpawnerUpgrade(EnumConfigKey power, EnumConfigKey param, EnumConfigKey param2, int tier) {

        this.power = power;
        this.param1 = param;
        this.param2 = param2;
        this.tier = tier;
    }

    public static final EnumSpawnerUpgrade[] RATE_UPGRADES = { RATE_I, RATE_II, RATE_III };
    public static final EnumSpawnerUpgrade[] LOOTING_UPGRADES = { LOOTING_I, LOOTING_II, LOOTING_III };
    public static final EnumSpawnerUpgrade[] XP_UPGRADES = { XP_I, XP_II, XP_III };
    public static final EnumSpawnerUpgrade[] MASS_UPGRADES = { MASS_I, MASS_II, MASS_III };
    public static final EnumSpawnerUpgrade[] DECAPITATE_UPGRADES = { DECAPITATE_I, DECAPITATE_II, DECAPITATE_III };
    public static final EnumSpawnerUpgrade[] EFFICIENCY_UPGRADES = { EFFICIENCY_I, EFFICIENCY_II, EFFICIENCY_III };
    public static final EnumSpawnerUpgrade[] BLOODMAGIC_UPGRADES = { BLOODMAGIC_I, BLOODMAGIC_II, BLOODMAGIC_III };

    public int getPower() {
        return ConfigManager.instance().getInteger(this.power);
    }

    public int getParam() {
        return ConfigManager.instance().getInteger(this.param1);
    }

    public int getParam2() {
        return ConfigManager.instance().getInteger(this.param2);
    }

    public int getMetadata() {

        return this.ordinal();
    }

    public static EnumSpawnerUpgrade getFromMetadata(int meta) {

        if (meta < 0 || meta >= values().length)
            return values()[0];

        return values()[meta];
    }

    @Override
    public String getName() {

        return toString();
    }

    @Override
    public String toString() {

        return super.toString().toLowerCase();
    }

    public int getTier() {

        return this.tier;
    }

    public static EnumSpawnerUpgrade getFromVariant(EnumVariantUpgrade e) {

        return values()[e.ordinal()];
    }

    public static EnumSpawnerUpgrade getFromVariant(EnumVariantUpgradeB e) {

        return values()[e.ordinal() + EFFICIENCY_I.ordinal()];
    }

    public static boolean isRateUpgrade(EnumSpawnerUpgrade upgrade) {

        for (EnumSpawnerUpgrade u : RATE_UPGRADES)
            return u == upgrade;
        return false;
    }

    public static boolean isMassUpgrade(EnumSpawnerUpgrade upgrade) {

        for (EnumSpawnerUpgrade u : MASS_UPGRADES)
            return u == upgrade;
        return false;
    }

    public static boolean isLootingUpgrade(EnumSpawnerUpgrade upgrade) {

        for (EnumSpawnerUpgrade u : LOOTING_UPGRADES)
            return u == upgrade;
        return false;
    }

    public static boolean isXpUpgrade(EnumSpawnerUpgrade upgrade) {

        for (EnumSpawnerUpgrade u : XP_UPGRADES)
            return u == upgrade;
        return false;
    }

    public static boolean isDecapitateUpgrade(EnumSpawnerUpgrade upgrade) {

        for (EnumSpawnerUpgrade u : DECAPITATE_UPGRADES)
            return u == upgrade;
        return false;
    }

    public static boolean isEfficiencyUpgrade(EnumSpawnerUpgrade upgrade) {

        for (EnumSpawnerUpgrade u : EFFICIENCY_UPGRADES)
            return u == upgrade;
        return false;
    }

    public static boolean isBloodMagicUpgrade(EnumSpawnerUpgrade upgrade) {

        for (EnumSpawnerUpgrade u : BLOODMAGIC_UPGRADES)
            return u == upgrade;
        return false;
    }

    public static EnumEnchantKey getEnchantKey(EnumSpawnerUpgrade upgrade) {

        if (upgrade == LOOTING_I)
            return EnumEnchantKey.LOOTING_I;
        else if (upgrade == LOOTING_II)
            return EnumEnchantKey.LOOTING_II;
        else if (upgrade == LOOTING_III)
            return EnumEnchantKey.LOOTING_III;

        return EnumEnchantKey.NO_ENCHANT;
    }
}
