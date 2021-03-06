package com.duggles.exptools.item;

import com.duggles.exptools.handler.ConfigurationHandler;
import com.duggles.exptools.reference.Reference;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class itemXpEnderP extends item_exptools {
    public itemXpEnderP() {
        super();
        this.setUnlocalizedName("xpEnderP");
        this.setMaxStackSize(1);
        this.setTextureName(Reference.MODID + ":xpEnderP");
        this.setMaxDamage(10);
        this.isDamageable();
    }


    public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
        if (p_77659_3_.capabilities.isCreativeMode) {
            return p_77659_1_;
        } else {

            if (p_77659_3_.isSneaking()) {
                if (p_77659_1_.getItemDamage() > 0) {
                    float additionalXp = Math.round(p_77659_3_.experience * 10);
                    float pitch = 5.0f / p_77659_1_.getItemDamage();
                    if (additionalXp > 0) {
                        p_77659_3_.addExperience(-1);
                        p_77659_1_.damageItem(-1, p_77659_3_);
                        p_77659_2_.playSoundAtEntity(p_77659_3_, "note.bass", 0.5F, pitch);
                    } else if (p_77659_3_.experienceLevel > 0) {
                        p_77659_3_.addExperienceLevel(-1);
                        p_77659_1_.damageItem(-1, p_77659_3_);
                        if (p_77659_3_.experienceLevel <= 15) {
                            p_77659_3_.addExperience(16);
                        } else if (p_77659_3_.experienceLevel <= 30) {
                            p_77659_3_.addExperience(19);
                        } else {
                            p_77659_3_.addExperience(63);
                        }
                        p_77659_2_.playSoundAtEntity(p_77659_3_, "note.bass", 0.5F, pitch);
                    } else {
                        p_77659_2_.playSoundAtEntity(p_77659_3_, "random.fizz", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
                    }
                } else {
                    p_77659_2_.playSoundAtEntity(p_77659_3_, "random.wood_click", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
                }
            }
            else if (!p_77659_2_.isRemote){
                if (p_77659_1_.getItemDamage()==(ConfigurationHandler.pearlMaxCharge)) {
                    p_77659_2_.playSoundAtEntity(p_77659_3_, "random.fizz", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
                }else{
                p_77659_2_.playSoundAtEntity(p_77659_3_, "random.successful_hit", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
                p_77659_2_.spawnEntityInWorld(new EntityEnderPearl(p_77659_2_, p_77659_3_));
                p_77659_1_.damageItem(1, p_77659_3_);}}
        }
        return p_77659_1_;
    }
}

