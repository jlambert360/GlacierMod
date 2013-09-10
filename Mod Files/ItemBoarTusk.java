

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;

public class ItemBoarTusk extends Item{

	public ItemBoarTusk(int par1) {
		super(par1);
	}

private String texturePath;
	
	@SideOnly(Side.CLIENT)
	private Icon icon;
	
	


	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister){
		this.icon = par1IconRegister.registerIcon("mod/boarttusk");
	}
	
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int par1){
		return this.icon;
	}
}