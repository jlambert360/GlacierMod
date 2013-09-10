

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.Icon;

public class ItemTuskSpear extends ItemSword implements ExtendWeaponReach{

	public ItemTuskSpear(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		this.setCreativeTab(mod_GlacierMain.tabGlacier);
	}

	@Override
	public float getReachModifierInBlocks(ItemStack stack) {
		return 3.0F;
	}
	
private String texturePath;
	
	@SideOnly(Side.CLIENT)
	private Icon icon;
	
	


	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister){
		this.icon = par1IconRegister.registerIcon("mod/tuskspear");
	}
	
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int par1){
		return this.icon;
	}
}